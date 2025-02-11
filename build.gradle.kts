/*
 * Approximaster ModLoader 1.20.6
 * Copyright (C) Approximaster Studios 2004. All Rights Reversed.
 *
 * Powered By Slimefun
 * Can Run on Spigot.
 * 
 * the 
 * Deprecated: This Build is Dropped at 1.20.6 in favor of 1.21.4
 */


plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.ddnsgeek.approximasterstudios2004.modloader"
version = "1.20.6-R000-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        name = "CodeMC"
        url = uri("https://repo.codemc.io/repository/maven-public/")
    }    
    maven {
        name = "OpenCollab"
        url = uri("https://repo.opencollab.dev/maven-snapshots/")
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
    maven {
         url = uri("https://maven.citizensnpcs.co/repo")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT") // PaperMC
    compileOnly("com.github.Slimefun:Slimefun4:RC-37") // Dropped
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.14.1") // NBT
    compileOnly("su.nightexpress.nightcore:nightcore:2.7.3") // NightCore
    compileOnly("org.geysermc.floodgate:api:2.2.3-SNAPSHOT") // Cumulus
    compileOnly("org.geysermc.cumulus:cumulus:1.1.2-SNAPSHOT") // Floodgate Hook
    compileOnly("net.citizensnpcs:citizens-main:2.0.37-SNAPSHOT")
    /* 
     * Patched SpigotMC in case all org.bukkit.*, org.spigotmc.* is eliminated on PaperMC. 
     * Currently, there are no Status about removal of Bukkit 1.21.4-R0.1-SNAPSHOT 3339db1, Implemented on CraftBukkit Commit c294e05, which is known as Spigot Commit 33ece3e.
     * if that happens, this comment will be removed. 
     * implementation(:project("approximaster-paper-spigot-adapter")) 
     */ 
    compileOnly("com.viaversion:viaversion-api:5.2.2-SNAPSHOT") // 1.20.6-1.21.4 PacketHandler
    implementation("net.lenni0451:optconfig:1.1.1-SNAPSHOT") // Bukkit Config API Replacement
}
 
tasks {
    withType<Jar> {
        archiveClassifier.set("")
        manifest {
            attributes["Main-Class"] = "com.ddnsgeek.approximasterstudios2004.modloader"
        }
        from(sourceSets.main.get().output)
    }

    shadowJar {
        archiveClassifier.set("shadow")
        from(sourceSets.main.get().output)
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(mapOf("version" to project.version))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}
