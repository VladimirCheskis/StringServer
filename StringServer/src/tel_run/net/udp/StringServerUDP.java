package tel_run.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

import tel_run.net.Defaults;
import tel_run.net.IStringProtocol;
import tel_run.net.StringServer;

public class StringServerUDP extends StringServer {


	public StringServerUDP(IStringProtocol protocol) throws SocketException {
		this(protocol, Defaults.PORT, Defaults.MAX_LENGTH);
	}
	
	public StringServerUDP(IStringProtocol protocol,
							int port,
							int maxLength) throws SocketException {
		super(protocol);
		socket = new DatagramSocket(port);
		this.maxLength = maxLength;
	}

	@Override
	protected void receiveAndSend() throws IOException{
	 
	byte[] result = new byte[maxLength];
		DatagramPacket rpacket = new DatagramPacket(result, maxLength);
		socket.receive(rpacket);
		String request = new String(Arrays.copyOf(result, rpacket.getLength()));
		String responce = protocol.process(request);
		if (responce != null){
			byte[] bytes = responce.getBytes();
			DatagramPacket spacket = new DatagramPacket(bytes, bytes.length, 
														rpacket.getAddress(), 
														rpacket.getPort());
			socket.send(spacket);
		}
	}
	
	DatagramSocket socket;
	int maxLength;
	
	@Override	
	public void close() {
		socket.close();
		
	}
}
