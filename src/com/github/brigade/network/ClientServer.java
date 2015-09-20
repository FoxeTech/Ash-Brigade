package com.github.brigade.network;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

public class ClientServer extends Networker {
	// TODO: Keep track of more server data (Other players, ping, etc.)
	// TODO: Since you can't run a server AND client (Same port binding
	// exception), this will have to serve as both. Life will find a way ;-;
	private final InetAddress IPAddress;

	public ClientServer(String ip, int port) throws IOException {
		super(port);
		IPAddress = InetAddress.getByName(ip);
	}

	@Override
	protected void handlePacket(Packet packet, InetAddress address) {
		// Should packet handling be done here, or should the packet handle
		// itself?
		/*
		 * packet.handle() or something.
		 * 
		 * Each packet would have enough data in order to be self sufficient.
		 */
	}

	public InetAddress getIPAddress() {
		return IPAddress;
	}
}
