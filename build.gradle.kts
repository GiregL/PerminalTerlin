plugins {
    kotlin("jvm") version "2.4.0"
    application
}

group = "fr.astral"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(26)
}

application {
    mainClass.set("fr.astral.perminalTerlin.MainKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // Inclure les classes compilées dans le JAR
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

    // Définir la classe main dans le manifest
    manifest {
        attributes["Main-Class"] = "fr.astral.perminalTerlin.MainKt"
    }
}