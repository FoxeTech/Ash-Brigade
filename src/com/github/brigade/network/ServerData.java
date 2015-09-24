package com.github.brigade.network;

public class ServerData {
	private final ClientData[] connected;

	private ServerData(ClientData[] connected) {
		this.connected = connected;
	}

	public ClientData[] getConnected() {
		return connected;
	}

	public int getClientCount() {
		return connected.length;
	}
}
