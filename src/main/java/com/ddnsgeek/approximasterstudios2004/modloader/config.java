package com.ddnsgeek.approximasterstudios2004.modloader;

import net.lenni0451.optconfig.ConfigContext;
import net.lenni0451.optconfig.annotations.*;
import net.lenni0451.optconfig.migrate.ConfigMigrator;

import java.time.Month;

@OptConfig(header = {
        "-----------------------------------",
        "| This is a InternationalX Config! These are for locale change. |",
        "-----------------------------------"

@NotReloadable //Not reloadable
    @Option("Locale")
    @Description({"Attempting to reload this will cause the plugin to corrupt, causing data loss."})
    public String Locale = "Ko-KR";
