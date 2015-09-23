package com.github.brigade.network;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

public class Client extends UDPClient {
	// TODO: Keep track of more server data (Other players, ping, etc.)
	// TODO: Since you can't run a server AND client (Same port binding
	// exception), this will have to serve as both. Life will find a way ;-;
	private final InetAddress IPAddress;

	public Client(String ip, int port) throws IOException {
		super(port, true);
		IPAddress = InetAddress.getByName(ip);
	}

	@Override
	protected void handlePacket(Packet packet, InetAddress address) {
		packet.onClientPacketReceive(address);
	}

	/**
	 * Returns the server address the client is connected to.
	 */
	public InetAddress getIPAddress() {
		return IPAddress;
	}
}
