package tel_run.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

import tel_run.net.Defaults;
import tel_run.net.IStringClient;

public class StringClientUDP implements IStringClient {

	@Override
	public String sendAndReseive(String request) throws IOException {
		byte[] bytes = request.getBytes();
		DatagramPacket spacket = new DatagramPacket(bytes, bytes.length, address, port);
		socket.send(spacket);
		
		byte[] result = new byte[maxLength];
		DatagramPacket rpacket = new DatagramPacket(result, maxLength);
		socket.receive(rpacket);
		String response = new String(Arrays.copyOf(result, rpacket.getLength()));	
		return response;
	}

	@Override
	public void close() throws IOException {
		socket.close();
	}
	

	public StringClientUDP(String hostName, int port, int maxLength) throws UnknownHostException, SocketException {
		super();
		this.port = port;
		this.maxLength = maxLength;
		address = InetAddress.getByName(hostName);
		socket = new DatagramSocket();
	}
	
	public StringClientUDP() throws UnknownHostException, SocketException {
		this(Defaults.LOCALHOST, Defaults.PORT, Defaults.MAX_LENGTH);
	}
	
	DatagramSocket socket;
	InetAddress address;	
	int port;	
	int maxLength;
}
