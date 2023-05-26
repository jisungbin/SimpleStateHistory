# SimpleStateHistory

- `MutableState<T>.track(): MutableState<T>`
- `redo()`
- `undo()`

[[example]](https://github.com/jisungbin/SimpleStateHistory/blob/main/app/src/main/kotlin/sungbin/simplestatehistory/MainActivity.kt) [[implementation]](https://github.com/jisungbin/SimpleStateHistory/blob/main/app/src/main/kotlin/sungbin/simplestatehistory/SimpleStateHistory.kt) [[preview video]](https://youtube.com/watch?v=aBAZXaGzMUg)

### 사용된 개념

- `StateObject`
- `StateObject#firstStateRecord`
- `StateRecord`
- `StateRecord#assign`
- `StateRecord#create`
- `StateRecord#writable` _(extension)_
- `StateRecord#withCurrent` _(extension)_
- `Snapshot#registerApplyObserver` (`ObserverHandle`)

### 주의 사항

- 멀티 스레드를 고려하지 않았습니다.
- 하나의 `StateObject`만 지원합니다.

### Article

[Deep Dive into Jetpack Compose State 발표 자료 및 슬라이도 답변](https://sungbin.land/deep-dive-into-jetpack-compose-state-%EB%B0%9C%ED%91%9C-%EC%9E%90%EB%A3%8C-%EB%B0%8F-%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%8F%84-%EB%8B%B5%EB%B3%80-4dbea6326b56?source=collection_home---4------0-----------------------)
