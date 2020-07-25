# RoomLab

- Room은 SQLite에 대한 추상화 레이어를 제공하여 원활한 데이터베이스 액세스를 지원하는 동시에 SQLite를 완벽히 활용
- How to use
    - ROOM = Database + Entity + Dao
- Google 가이드

    [](https://developer.android.com/training/data-storage/room#kotlin)


- Gradle 설정

        ```kotlin
        //Module gralde
        apply plugin: 'kotlin-kapt'

        dependencies {
        		def room_version = "2.2.5"
            implementation "androidx.room:room-runtime:$room_version"
            kapt "androidx.room:room-compiler:$room_version"
        }
        ```
