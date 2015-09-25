package com.github.brigade.network.packet;

import java.net.InetAddress;

import com.github.brigade.Game;
import com.github.brigade.network.ClientData;
import com.github.brigade.network.Server;

public class Packet2JoinAcknowledge extends Packet {
	private static final long serialVersionUID = 1L;
	private final boolean canJoin;

	public Packet2JoinAcknowledge(boolean canJoin) {
		super(2);
		this.canJoin = canJoin;
	}

	@Override
	public void onClientPacketReceive(InetAddress address) {
		if (!canJoin) {
			// TODO: Unable to join the server. Terminate connection.
		}

	}

	@Override
	public void onServerPacketReceive(InetAddress address, Server server) {
		// Should not be received by the server
	}
}
