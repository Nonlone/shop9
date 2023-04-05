
plugins {
    id("java-library")
    id("io.freefair.lombok").version("6.6.3")
    id("org.springframework.boot").version("3.0.3")
    id("io.spring.dependency-management").version("1.1.0")

    id("org.graalvm.buildtools.native").version("0.9.20")

    // id("io.freefair.lombok").version("6.1.0-m3")
    // id("org.springframework.boot").version("2.5.0")
    // id("io.spring.dependency-management").version("1.0.11.RELEASE")
}


dependencies {
    api(project(":app"))
}


// tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
//     mainClass.set("com.shop9.app.Application")
// }

springBoot {
  mainClass.set("com.shop9.app.Application")
}

graalvmNative {
    binaries {
        named("main") {
            javaLauncher.set(javaToolchains.launcherFor {
                languageVersion.set(JavaLanguageVersion.of(17))
                vendor.set(JvmVendorSpec.matching("GraalVM Community"))
            })
        }
    }

    binaries.all {
        resources.autodetect()
    }
//    toolchainDetection.set(false)
}


allprojects {
    apply(plugin = "java-library")

    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }   

    java {
        withSourcesJar()
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
    
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "io.spring.dependency-management")


    dependencies {
        api(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
        implementation("cn.hutool:hutool-all:5.7.6")
        implementation("com.google.guava:guava:30.1.1-jre")
        // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
        implementation("org.apache.commons:commons-lang3:3.12.0")
        constraints {
            // MyBatisPlus ORM 框架增强
            implementation("com.baomidou:mybatis-plus-boot-starter:3.4.3")
        }
    }

    
    
}
