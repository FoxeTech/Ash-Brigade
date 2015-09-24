package com.github.brigade.network;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

public class Client extends UDPClient {
	// TODO: Keep track of more server data (Other players, ping, etc.) (Should
	// be received from the server that bounces information back to this client)
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
