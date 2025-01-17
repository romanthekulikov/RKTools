plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("maven-publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

subprojects {
    apply(plugin = "maven-publish")
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.roman_kulikov.rktools"
                artifactId = "rk_tools"
                version = "0.2.4"
            }
        }
    }
}


kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}