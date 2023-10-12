plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.irinastyazhkina"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}