package com.github.brigade.network;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

public class Server extends UDPClient {
	// TODO: Keep track of more server data (Other players, ping, etc.) and
	// bounce it back to other clients (Done in packet classes).

	public Server(String ip, int port) throws IOException {
		super(port, true);
	}

	@Override
	protected void handlePacket(Packet packet, InetAddress address) {
		packet.onServerPacketReceive(address, this);
	}
}
