package com.github.brigade.network;

import java.io.Serializable;
import java.net.InetAddress;

public class ClientData implements Serializable{
	private static final long serialVersionUID = 1L;
	private final InetAddress ip;
	private final String name;

	public InetAddress getIp() {
		return ip;
	}

	public String getName() {
		return name;
	}

	public ClientData(String name, InetAddress ip) {
		this.name = name;
		this.ip = ip;
	}
}
