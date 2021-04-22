import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val projectGroup: String by project
val projectVersion: String by project
val springBootVersion: String by project
val springCloudVersion: String by project

plugins {
    id("org.springframework.boot") apply false
    kotlin("jvm")
    kotlin("plugin.spring") apply false
    kotlin("plugin.jpa") apply false
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

allprojects {
    group = projectGroup
    version = projectVersion

    repositories {
        mavenCentral()
    }
}

configurations {
    all {
        exclude(group = "com.fasterxml.jackson.datatype", module = "jackson-datatype-hibernate4")
    }
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "idea")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
        }
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
        }
        imports {
            mavenBom("com.amazonaws:aws-java-sdk-bom:1.11.693")
        }
        dependencies {
            dependency("org.codehaus.janino:janino:3.0.15")
            dependency("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
            dependency("org.springframework.kafka:spring-kafka:2.2.11.RELEASE")

            dependency("org.junit.platform:junit-platform-commons:1.5.2")
            dependency("org.junit.platform:junit-platform-launcher:1.5.2")
            dependency("com.github.ben-manes.caffeine:caffeine:2.8.5")
        }
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))
        implementation("io.github.microutils:kotlin-logging:1.8.3")
        implementation("io.springfox:springfox-swagger-ui:2.0.2")
        implementation("io.springfox:springfox-swagger2:2.9.2")

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
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
}
