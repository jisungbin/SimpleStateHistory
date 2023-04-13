package sungbin.simplestatehistory

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.snapshots.ObserverHandle
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.runtime.snapshots.StateRecord
import androidx.compose.runtime.snapshots.withCurrent
import androidx.compose.runtime.snapshots.writable

private var currentFrame = 0
private val frames = mutableVectorOf<StateRecord>()

private var target: StateObject? = null
private var handle: ObserverHandle? = null

private fun StateObject.restoreFrom(record: StateRecord) {
    firstStateRecord.writable(this) {
        assign(record)
    }
}

private fun StateObject.copyCurrentRecord(): StateRecord {
    val newRecord = firstStateRecord.create()
    firstStateRecord.withCurrent { current ->
        newRecord.assign(current)
    }
    return newRecord
}

private fun startRecording() {
    handle = Snapshot.registerApplyObserver { stateObjects, _ ->
        if (target != null && stateObjects.any { it == target }) {
            saveFrame()
        }
    }
}

private fun saveFrame() {
    if (currentFrame < frames.size - 1) {
        frames.removeRange(currentFrame + 1, frames.size)
    }
    frames += target!!.copyCurrentRecord()
    currentFrame = frames.size
}

private fun stopRecording() {
    handle!!.dispose()
}

fun <T> MutableState<T>.track(): MutableState<T> {
    target = this as StateObject
    startRecording()
    return this
}

fun undo() {
    stopRecording()
    if (currentFrame - 1 in frames.indices) {
        target!!.restoreFrom(frames[--currentFrame])
    }
    startRecording()
}

fun redo() {
    stopRecording()
    if (currentFrame + 1 in frames.indices) {
        target!!.restoreFrom(frames[++currentFrame])
    }
    startRecording()
}
