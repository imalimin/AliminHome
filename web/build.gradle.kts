import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    war
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "com.alimin"
version = "0.0.5-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jsoup:jsoup:1.14.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.9.+")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.+")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.10")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("mysql:mysql-connector-java:5.1.13")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("javax.el:javax.el-api:3.0.0")

    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
