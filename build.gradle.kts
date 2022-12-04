plugins {
    kotlin("jvm") version "1.7.20"
    `java-library`
    `maven-publish`
}

group = "xyz.hughjd"
version = "0.0.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("org.hamcrest", "hamcrest", "2.2")
}

java {
    withJavadocJar()
    withSourcesJar()
}


tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name, "Implementation-Version" to project.version))
        writeTo(layout.buildDirectory.file("manifest.mf"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
