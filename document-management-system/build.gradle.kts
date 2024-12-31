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
    testImplementation("junit:junit:4.13.1")

}

application {
    // Define the main class for the application.
    mainClass = "org.drs.Main"
}