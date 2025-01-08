# RKTools
[![Release](https://img.shields.io/github/release/romanthekulikov/RKTools.svg?style=flat)](https://jitpack.io/#romanthekulikov/RKTools)

It's a set of development tools. 
It's a convenient way to avoid problems and make error management more enjoyable!

## Table of Contents
1. [Quick Start](#quick-start)
    1. [Gradle](#gradle-setup)
2. [Examples](#examples)
    1. [Result](#result)
    2. [ExceptionCatcher](#exception-catcher)

### Gradle Setup

```gradle-kotlin
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
}
```

## Tools
Now 2 tools available:
- Result
- ExceptionCatcher

## Examples

See examples for understanding

<h2 id="#result">Result</h2>
Use Result for return data or cause of error.
E.g.

```kotlin

fun getUser(val userId): Result<User> {
  if (userId < 0) {
    return Result.Failure(cause = "Invalid userId")
  }

  return Result.Sucess(User(name = "Mike", email = "mike@gmail.com"))
}

```
Now Result support 3 state:
- Success (data: T) -- to return data
- Failure (cause: String) -- to indicate the cause
- NoNetwork ( ) -- to indicate the absence of a network


<h2 id="#exception-catcher">ExceptionCatcher</h2>
This is a interface. You need to implement it for catching your job.

Implement example:
```kotlin

class UserCatcherImpl : ExceptionCatcher {

  override suspend fun <T> launchWithCatch(job: suspend () -> Result<T>): Result<T> {
    return try {
      job()
    } catch(e: Exception) {
      Result.Failure(cause = "Error!")
    }

  }

  override fun <T> withCatch(job: () -> Result<T>): Result<T> {
    return try {
      job()
    } catch(e: Exception) {
      Result.Failure(cause = "Error!")
    }

  }

}

```

Using example:
```kotlin

private val catcher = UserCatcherImpl()

override suspend fun getUser(): Result<User> {
    return catcher.launchWithCatch {
        Result.Success(User(name = "Mike", email = "mike@gmail.com"))
    }
}

```

Supported 2 functions:
- launchWithCatch -- for suspend job
- withCatch -- for sync job




