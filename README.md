# aoc-kotlin-utils

Some utilities for my AOC solutions in Kotlin. Published under CC-0 so take what you like.

[![Release](https://jitpack.io/v/xyz.hughjd/aoc-kotlin-utils.svg)]
(https://jitpack.io/#xyz.hughjd/aoc-kotlin-utils)

### Use this library in your project

You can put this library in your build easily via [JitPack](https://jitpack.io).

Browse versions and get Maven/Gradle instructions [here](https://jitpack.io/#xyz.hughjd/aoc-kotlin-utils).

Note for kotlin-syntax gradle users: the syntax for custom Maven repositories is slightly different:
```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}
```

instead of the Groovy
```groovy
repositories {
    mavenCentral()
    maven {
        url "https://jitpack.io"
    }
}
```

### Build JARs

`./gradlew build`

JARs will be in [build/libs](build/libs)

### Run tests

`./gradlew test`
