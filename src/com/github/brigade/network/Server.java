package com.github.brigade.network;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

public class Server extends UDPClient {
	public Server(int port, boolean isClient) throws IOException {
		super(port, isClient);
	}

	public Server(int port) throws IOException {
		this(port, false);
	}

	@Override
	protected void handlePacket(Packet packet, InetAddress address) {
		packet.onServerPacketReceive(address, this);
	}
}
