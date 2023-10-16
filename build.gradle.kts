plugins {
    kotlin("jvm") version "1.9.0"
    jacoco
    application
}

group = "me.irinastyazhkina"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}


kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}