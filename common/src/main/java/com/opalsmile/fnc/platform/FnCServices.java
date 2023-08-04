package com.opalsmile.fnc.platform;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.platform.services.IConfigHelper;
import com.opalsmile.fnc.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class FnCServices {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IConfigHelper CONFIG = load(IConfigHelper.class);


    public static <T> T load(Class<T> clazz){

        final T loadedService = ServiceLoader.load(clazz).findFirst().orElseThrow(
                () -> new NullPointerException("Failed to load service for " + clazz.getName()));
        FnCConstants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}