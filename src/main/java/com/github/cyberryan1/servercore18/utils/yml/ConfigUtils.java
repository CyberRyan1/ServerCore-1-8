package com.github.cyberryan1.servercore18.utils.yml;

import com.github.cyberryan1.cybercore.managers.FileType;
import com.github.cyberryan1.cybercore.managers.YMLManager;
import com.github.cyberryan1.cybercore.utils.yml.YMLReadTemplate;

public final class ConfigUtils extends YMLReadTemplate {

    public ConfigUtils() {
        setYMLManager( new YMLManager( FileType.CONFIG ) );
    }
}