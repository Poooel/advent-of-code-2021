plugins {
    kotlin("jvm") version "1.6.10"
    application
    id("com.diffplug.spotless") version "6.0.5"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.0.1-jre")
    implementation("com.github.ajalt.clikt:clikt:3.3.0")
    implementation("com.github.ajalt.mordant:mordant:2.0.0-beta4")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("com.github.advent.of.code.AppKt")
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()

        ktlint()
    }
    kotlinGradle {
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()

        ktlint()
    }
}
