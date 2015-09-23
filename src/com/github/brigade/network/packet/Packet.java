package com.github.brigade.network.packet;

import java.io.Serializable;
import java.net.InetAddress;

import com.github.brigade.network.Server;

public abstract class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int packetID;

	public Packet(int packetID) {
		this.packetID = packetID;
	}

	/**
	 * Called when the packet is received and the user is a client.
	 * 
	 * @param address
	 *            Where the packet is from
	 */
	public abstract void onClientPacketReceive(InetAddress address);

	/**
	 * Called when the packet is received and the user is a server.
	 * 
	 * @param address
	 *            Where the packet is from
	 * @param server
	 *            The current server instance
	 */
	public abstract void onServerPacketReceive(InetAddress address, Server server);

	public int getPacketID() {
		return packetID;
	}
}
