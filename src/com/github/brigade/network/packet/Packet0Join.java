package com.github.brigade.network.packet;

import java.io.IOException;
import java.net.InetAddress;

import com.github.brigade.Game;
import com.github.brigade.network.ClientData;
import com.github.brigade.network.Server;

public class Packet0Join extends Packet {
	private static final long serialVersionUID = 1L;
	private final String name;

	public Packet0Join(String name) {
		super(0);
		this.name = name;
	}

	@Override
	public void onClientPacketReceive(InetAddress address) {
		Game.getClient().setCurrentServer(address);
	}

	@Override
	public void onServerPacketReceive(InetAddress address, Server server) {
		server.addClient(name, address);
		for (ClientData clientData : server.getClients()) {
			if (clientData == null) {
				continue;
			}
			String otherIP = clientData.getIp().getHostAddress();
			String fromIP = address.getHostAddress();
			boolean sendLocal = server.isClient() ? (clientData.getIp().isAnyLocalAddress() || clientData.getIp().isLoopbackAddress()) : false;
			if (!otherIP.equals(fromIP) || sendLocal) {
				try {
					server.sendPacket(new Packet1PlayerData(clientData), clientData.getIp());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
