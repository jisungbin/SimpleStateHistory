# SimpleStateHistory

- `MutableState<T>.track(): MutableState<T>`
- `redo()`
- `undo()`

[[example]](https://github.com/jisungbin/SimpleStateHistory/blob/main/app/src/main/kotlin/sungbin/simplestatehistory/MainActivity.kt) [[implementation]](https://github.com/jisungbin/SimpleStateHistory/blob/main/app/src/main/kotlin/sungbin/simplestatehistory/SimpleStateHistory.kt)

### 주의 사항

- 멀티 스레드를 고려하지 않았습니다.
- 하나의 `StateObject`만 지원합니다.