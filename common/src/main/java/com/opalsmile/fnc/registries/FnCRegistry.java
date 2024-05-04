package com.opalsmile.fnc.registries;

import com.opalsmile.fnc.util.FnCUtil;

public class FnCRegistry {

    public static void initialise(){
        FnCEntities.init();
        FnCBlocks.init();
        FnCItems.init();
        FnCSounds.init();
        FnCUtil.registerTicket();
    }
}
