# RoomLab

- Room은 SQLite에 대한 추상화 레이어를 제공하여 원활한 데이터베이스 액세스를 지원하는 동시에 SQLite를 완벽히 활용
- How to use
    - ROOM = Database + Entity + Dao
- Google 가이드

    [](https://developer.android.com/training/data-storage/room#kotlin)


- Gradle 설정

```
//Module gralde
apply plugin: 'kotlin-kapt'

dependencies {
    def room_version = "2.2.5"
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
}
```

---

[Sqlite와 비교한 Room의 장점](https://www.notion.so/Sqlite-Room-ad5c85f72277405d8684db2433698fde)

[**Room vs Realm**](https://www.notion.so/Room-vs-Realm-1650e31090024fab8a355ae739c9891e)
