package tel_run.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import tel_run.net.Defaults;
import tel_run.net.IStringProtocol;
import tel_run.net.StringServer;

public class StringServerTCP extends StringServer {

	public StringServerTCP(IStringProtocol protocol, int port) throws IOException {
		super(protocol);
		serverSocket = new ServerSocket(port);
	}
	
	public StringServerTCP(IStringProtocol protocol) throws IOException {
		this(protocol, Defaults.PORT);
	}	
	@Override
	public void receiveAndSend() throws IOException {
		Socket socket = serverSocket.accept();
		clientRun(socket);
	}
	
	private void clientRun(Socket socket) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream writer = new PrintStream(socket.getOutputStream());
		while(true){
			String line = null;
			try
			{
				line = reader.readLine();
			}
			catch(SocketException ex)
			{
				break;
			}
			if (line == null)
				break;
			String responce = protocol.process(line);
			writer.println(responce);
		}
	}	
	
	ServerSocket serverSocket;

	@Override
	public void close() throws IOException {
		serverSocket.close();
		
	}
}
