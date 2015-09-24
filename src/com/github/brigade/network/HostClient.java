package com.github.brigade.network;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

public class HostClient extends Server {
	private final InetAddress IPAddress;

	public HostClient(String ip, int port) throws IOException {
		super(port, true);
		IPAddress = InetAddress.getByName(ip);
	}

	@Override
	protected void handlePacket(Packet packet, InetAddress address) {
		packet.onServerPacketReceive(address, this);
		packet.onClientPacketReceive(address);
	}

	/**
	 * Returns the server address the client is connected to. Should be
	 * localhost in this instance.
	 */
	public InetAddress getIPAddress() {
		return IPAddress;
	}
}
