package com.opalsmile.fnc.platform.network;

import com.opalsmile.fnc.client.FnCClient;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class PacketJockeyInformation {
    private final boolean sameLevel;
    @Nullable private BlockPos position;
    
    public PacketJockeyInformation(boolean sameLevel, BlockPos position) {
        this.sameLevel = sameLevel;
        this.position = position;
    }

    public static PacketJockeyInformation decode(FriendlyByteBuf buf) {
        boolean sameLevel = buf.readBoolean();
        if (sameLevel) return new PacketJockeyInformation(true, buf.readBlockPos());
        else return new PacketJockeyInformation(false, null);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBoolean(this.sameLevel);
        if (sameLevel) {
            buf.writeBlockPos(position);
        }
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            FnCClient.setSameJockeyLevel(this.sameLevel);
            if (this.sameLevel) FnCClient.setJockeyPosition(this.position);
        });
        context.get().setPacketHandled(true);
    }
}
