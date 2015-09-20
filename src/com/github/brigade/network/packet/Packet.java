package com.github.brigade.network.packet;

import java.io.Serializable;

public abstract class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int packetID;

	public Packet(int packetID) {
		this.packetID = packetID;
	}

	public int getPacketID() {
		return packetID;
	}
}
