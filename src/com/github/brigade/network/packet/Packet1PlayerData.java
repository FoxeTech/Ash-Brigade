package com.github.brigade.network.packet;

import java.net.InetAddress;

import com.github.brigade.Game;
import com.github.brigade.network.ClientData;
import com.github.brigade.network.Server;

public class Packet1PlayerData extends Packet {
	private static final long serialVersionUID = 1L;
	private final ClientData clientData;

	public Packet1PlayerData(ClientData clientData) {
		super(1);
		this.clientData = clientData;
	}

	@Override
	public void onClientPacketReceive(InetAddress address) {
		Game.getClient().addConnectedPlayer(clientData);
	}

	@Override
	public void onServerPacketReceive(InetAddress address, Server server) {
		//Should not be received by the server
	}
}
