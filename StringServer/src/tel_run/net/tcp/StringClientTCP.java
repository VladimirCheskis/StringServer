package tel_run.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import tel_run.net.Defaults;
import tel_run.net.IStringClient;

public class StringClientTCP implements IStringClient {

	@Override
	public String sendAndReseive(String request) throws IOException {
		writer.println(request);
		return reader.readLine();
	}

	static BufferedReader reader;
	static PrintStream writer;	
	static Socket socket;
	
	public StringClientTCP(String hostName, int port) throws UnknownHostException, IOException {
		super();
		initConnection(hostName, port);		
	}
	
	public StringClientTCP() throws UnknownHostException, IOException {
		super();
		initConnection(Defaults.LOCALHOST, Defaults.PORT);		
	}	

	private void initConnection(String hostName, int port) throws UnknownHostException, IOException {
		socket = new Socket(hostName, port);		
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintStream(socket.getOutputStream());
	}

	@Override
	public void close() throws IOException {
		socket.close();
		reader = null;
		writer = null;
	}	
}
