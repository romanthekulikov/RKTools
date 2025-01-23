plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("maven-publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.roman_kulikov.rktools.tools"
            artifactId = "tools"
            version = "0.2.8"
            from(components["java"])
        }
    }
}