plugins {
    application
//    id("java")
}

group = "org.drs"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Define the main class for the application.
    mainClass = "org.drs.Main"
}