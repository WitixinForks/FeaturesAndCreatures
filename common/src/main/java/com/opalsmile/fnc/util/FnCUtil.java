package com.opalsmile.fnc.util;

import com.opalsmile.fnc.FnCConstants;
import net.minecraft.util.RandomSource;
import software.bernie.geckolib.network.SerializableDataTicket;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class FnCUtil {

    public static final SerializableDataTicket<Boolean> SPEAR_USE = SerializableDataTicket.ofBoolean(FnCConstants.resourceLocation(
            "spear_use_ticks"));

    public static void registerTicket() {
        GeckoLibUtil.addDataTicket(SPEAR_USE);
    }

    public static <T> T getRandomElement(RandomSource random, List<T> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

}
