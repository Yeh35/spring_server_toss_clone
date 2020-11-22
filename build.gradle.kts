import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
    kotlin("kapt") version "1.4.10"

    id("org.springframework.boot") version "2.3.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "me.sangoh.clone.toss"
version = "1.0-SNAPSHOT-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:4.2.1")
    kapt("com.querydsl:querydsl-apt:4.2.2:jpa")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    // DB
    testRuntimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")

    // API 설명서
    implementation ("io.springfox:springfox-swagger2:2.9.2")
    implementation ("io.springfox:springfox-swagger-ui:2.9.2")
    implementation(kotlin("stdlib-jdk8"))
}

// querydsl 적용
sourceSets["main"].withConvention(KotlinSourceSet::class){
    kotlin.srcDir("$buildDir/generated/source/kapt/main")  // QClass 생성 위치
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}