package com.opalsmile.fnc.platform.network;

import com.opalsmile.fnc.util.AntlerHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketAntlerKeypress {

    private final boolean release;

    public PacketAntlerKeypress(boolean release) {
        this.release = release;
    }

    public static PacketAntlerKeypress decode(FriendlyByteBuf buf) {
        return new PacketAntlerKeypress(buf.readBoolean());
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBoolean(this.release);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            if (context.get().getSender() == null) return;
            AntlerHandler.handlePacket(context.get().getSender(), this.release);
        });
        context.get().setPacketHandled(true);
    }
}
