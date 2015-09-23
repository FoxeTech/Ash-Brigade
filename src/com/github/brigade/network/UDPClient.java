package com.github.brigade.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.github.brigade.network.packet.Packet;

/**
 * TODO: Make an abstract and flexible packet object that networking will use
 * instead of generic objects.
 */
public abstract class UDPClient {
	protected final DatagramSocket socket;
	protected final int port;
	protected final boolean isClient;
	protected byte[] out = new byte[1024], in = new byte[1024];

	public UDPClient(int port, boolean isClient) throws IOException {
		this.port = port;
		this.isClient = isClient;
		socket = new DatagramSocket(port);
	}

	/**
	 * Handles the given packet from the given address.
	 * 
	 * @param packet
	 *            The packet to handle
	 * @param address
	 *            The address the packet is from
	 */
	protected abstract void handlePacket(Packet packet, InetAddress address);

	/**
	 * Checks for incoming packets. When packets are found they are parsed and
	 * handled by 'handlePacket'.
	 */
	public void receive() {
		try {
			DatagramPacket receivePacket = new DatagramPacket(in, in.length);
			socket.receive(receivePacket);
			ByteArrayInputStream bis = new ByteArrayInputStream(receivePacket.getData());
			ObjectInput in = new ObjectInputStream(bis);
			Object objIn = in.readObject();
			if (objIn instanceof Packet) {
				handlePacket((Packet) objIn, receivePacket.getAddress());
			}
			bis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends a packet to a given address.
	 * 
	 * @param packet
	 *            The packet to send
	 * @param address
	 *            The address that receives
	 * @throws IOException
	 *             Thrown if the packet cannot be sent
	 */
	public void sendPacket(Packet packet, InetAddress address) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput objOut = null;
		try {
			objOut = new ObjectOutputStream(bos);
			objOut.writeObject(packet);
			out = bos.toByteArray();
			DatagramPacket sendPacket = new DatagramPacket(out, out.length, address, port);
			socket.send(sendPacket);
			objOut.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DatagramSocket getSocket() {
		return socket;
	}

	public int getPort() {
		return port;
	}
	
	public boolean isClient(){
		return isClient;
	}
}
