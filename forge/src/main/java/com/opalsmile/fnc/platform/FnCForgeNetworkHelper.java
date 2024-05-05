package com.opalsmile.fnc.platform;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.platform.network.PacketAntlerKeypress;
import com.opalsmile.fnc.platform.network.PacketJockeyInformation;
import com.opalsmile.fnc.platform.services.FnCINetworkHelper;
import com.opalsmile.fnc.util.JockeySavedData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class FnCForgeNetworkHelper implements FnCINetworkHelper {

    private static final String PROTOCOL_VERSION = "1";

    private static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            FnCConstants.resourceLocation("packets"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    @Override
    public void sendAntlerKeypress(boolean release){
        INSTANCE.send(PacketDistributor.SERVER.noArg(), new PacketAntlerKeypress(release));
    }

    @Override
    public void notifyPlayerOfJockey(ServerPlayer player, BlockPos jockeyPosition){
        JockeySavedData savedData = JockeySavedData.get(player.server);
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new PacketJockeyInformation(savedData.hasJockeySpawned() && savedData.getDimensionId().equals(player.level().dimension().location()),
                        jockeyPosition)
                );
    }

    @Override
    public void broadcastJockeySpawning(ServerLevel level, BlockPos position){
        PacketJockeyInformation packet = new PacketJockeyInformation(true, position);
        INSTANCE.send(PacketDistributor.DIMENSION.with(level::dimension), packet);
    }

    @Override
    public void notifyJockeyDeath(ServerLevel level){
        PacketJockeyInformation packet = new PacketJockeyInformation(false, null);
        INSTANCE.send(PacketDistributor.DIMENSION.with(level::dimension), packet);
    }

    public static void register() {
        int counter = 0;
        INSTANCE.messageBuilder(PacketAntlerKeypress.class, ++counter, NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketAntlerKeypress::decode)
                .encoder(PacketAntlerKeypress::encode)
                .consumerMainThread(PacketAntlerKeypress::handle)
                .add();
        INSTANCE.messageBuilder(PacketJockeyInformation.class, ++counter, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketJockeyInformation::decode)
                .encoder(PacketJockeyInformation::encode)
                .consumerMainThread(PacketJockeyInformation::handle)
                .add();
    }


}
