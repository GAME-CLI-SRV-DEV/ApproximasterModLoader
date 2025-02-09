plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.example"
version = "1.20.6-R000-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
    maven {
        url = uri("https://jitpack.io/")
    }
    maven {
        name = "CodeMC"
        url = uri("https://repo.codemc.io/repository/maven-public/")
    }
    maven {
        name = "ViaVersion"
        url = uri("https://repo.viaversion.com/everything/")
    }
    maven {
        name = "My Favorite Dev"
        url = uri("https://maven.lenni0451.net/everything/")
    }
    maven {
      url = uri("https://repo.nightexpressdev.com/releases")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT") // PaperMC
    compileOnly("com.github.Slimefun:Slimefun4:master-SNAPSHOT") // item
    compileOnly("de.tr7zw:item-nbt-api-plugin:VERSION") // NBT
    compileOnly("su.nightexpress.nightcore:nightcore:2.7.1") // NightCore
    compileOnly("com.viaversion:viaversion-api:5.2.2-SNAPSHOT") // 1.20.6-1.21.4 PacketHandler
    implementation("net.lenni0451:optconfig:1.1.1-SNAPSHOT") // Bukkit Config API Replacement
}

 /* 
tasks {
    withType<Jar> {
        archiveClassifier.set("")
        manifest {
            attributes["Main-Class"] = "com.example.MyPlugin"
        }
        from(sourceSets.main.get().output)
    }

    shadowJar {
        archiveClassifier.set("shadow")
        from(sourceSets.main.get().output)
    }
  */

    processResources {
        filesMatching("plugin.yml") {
            expand(mapOf("version" to project.version))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}
