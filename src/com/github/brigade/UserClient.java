package com.github.brigade;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.github.brigade.network.Client;
import com.github.brigade.network.ClientData;
import com.github.brigade.network.HostClient;
import com.github.brigade.network.Server;
import com.github.brigade.network.UDPClient;
import com.github.brigade.network.packet.Packet0Join;

public class UserClient {
	private final String username;
	private UDPClient connection;
	private BattleStats stats;
	//
	private String host;
	private InetAddress currentServer;
	//
	private boolean isHost;
	private boolean isPlaying;

	public UserClient(String username, String password) {
		this.username = username;
		verify();
	}

	/**
	 * Loads player's stats from a file
	 */
	public void setup() {
		stats = new BattleStats();
		// TODO: Load from file
	}

	/**
	 * Verify that this user owns their account. If they do not, terminate the
	 * program.
	 */
	private void verify() {
		// TODO: Get a web server and make use of this
	}

	/**
	 * Joins a game based on information provided to the 'setGame' method.
	 * 
	 * @throws UnknownHostException
	 *             Thrown if the IP isn't valid
	 * @throws IOException
	 */
	public void joinGame() throws UnknownHostException, IOException {
		Packet0Join packet = new Packet0Join(username);
		connection.sendPacket(packet, InetAddress.getByName(host));
	}

	/**
	 * Adds client data to the current connection.
	 * 
	 * @param clientData
	 *            The client data to add
	 */
	public void addConnectedPlayer(ClientData clientData) {
		connection.addClient(clientData.getName(), clientData.getIp());
	}

	public void setGame(String host, int port, boolean isPlaying, boolean isHost) throws IOException {
		this.host = host;
		this.isPlaying = isPlaying;
		this.isHost = isHost;
		if (isPlaying && isHost) {
			connection = new HostClient(host, port);
		} else if (isPlaying && !isHost) {
			connection = new Client(host, port);
		} else if (!isPlaying && isHost) {
			connection = new Server(port);
		}
	}

	/**
	 * Gets the client's name.
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the client's connection. Types: <br>
	 * <ul>
	 * <li>Client - !isHost() && isPlaying()</li>
	 * <li>Server - isHost() && !isPlaying()</li>
	 * <li>HostClient - isHost() && isPlaying()</li>
	 * </ul>
	 * 
	 * @return
	 */
	public UDPClient getConnection() {
		return connection;
	}

	/**
	 * Set's the InetAddress of the currently connected server.
	 * 
	 * @param address
	 *            The IP that has been connected to
	 */
	public void setCurrentServer(InetAddress address) {
		currentServer = address;
	}

	/**
	 * Returns the current server IP as an InetAddress.
	 */
	public InetAddress getCurrentServerIP() {
		return currentServer;
	}

	/**
	 * @see com.github.brigade.BattleStats
	 */
	public BattleStats getStats() {
		return stats;
	}

	/**
	 * Returns if the UserClient is hosting the game.
	 */
	public boolean isHost() {
		return isHost;
	}

	/**
	 * Returns if the UserClient is playing the game.
	 */
	public boolean isPlaying() {
		return isPlaying;
	}
}
