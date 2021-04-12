import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.4.4"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.4.31"
  kotlin("plugin.spring") version "1.4.31"
}

group = "io.pivotal.services.dataTx"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	mavenLocal()
}

extra["springCloudVersion"] = "2020.0.2"
extra["springGeodeVersion"] = "1.4.3"

//configurations {
//	all {
//		exclude(group = "io.pivotal.gemfire")
//	}
//}
dependencyManagement {
  imports {
    mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
  }
}

dependencies {
	 implementation("org.springdoc:springdoc-openapi-ui:1.5.2")
	implementation("io.pivotal.services.dataTx:dataTx-geode-extensions-core:2.4.0")
	//-----------------------
      implementation("org.springframework.boot:spring-boot-starter-actuator")
      implementation("org.springframework.boot:spring-boot-starter-security")
      implementation("org.springframework.boot:spring-boot-starter-web")
      implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
      implementation("org.jetbrains.kotlin:kotlin-reflect")
      implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
      implementation("org.springframework.cloud:spring-cloud-starter-config")
      implementation("org.springframework.geode:spring-geode-starter")
      testImplementation("org.springframework.boot:spring-boot-starter-test")
      testImplementation("org.springframework.security:spring-security-test")


}

dependencyManagement {
	imports {
        mavenBom("org.springframework.geode:spring-geode-bom:${property("springGeodeVersion")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
