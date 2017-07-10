package tel_run.net.appl;

import java.io.IOException;

import tel_run.net.client.ConsoleClient;
import tel_run.net.udp.StringClientUDP;

public class ClientUDPTestAppl {
	public static void main(String[] args) throws IOException {
		StringClientUDP udp = new StringClientUDP();
		ConsoleClient consoleClient = new ConsoleClient(udp);
		consoleClient.run();
		consoleClient.close();
	}
}
