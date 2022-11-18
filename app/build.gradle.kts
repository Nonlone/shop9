
plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

application {
    // Define the main class for the application.
    mainClass.set("com.shop9.app.Application")
}

apply(plugin = "org.springframework.boot")


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Hikari 连接池
    implementation("com.zaxxer:HikariCP")
    // MyBatisPlus ORM 框架增强
    implementation("com.baomidou:mybatis-plus-boot-starter")


    implementation("per.nonlone:vertebra:1.0")

    // MySQL 数据库连接
    runtimeOnly("mysql:mysql-connector-java")



    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}