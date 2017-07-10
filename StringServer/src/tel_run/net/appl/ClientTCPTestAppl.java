package tel_run.net.appl;

import java.io.IOException;

import tel_run.net.client.ConsoleClient;
import tel_run.net.tcp.StringClientTCP;

public class ClientTCPTestAppl {
	public static void main(String[] args) throws IOException {
		StringClientTCP tcp = new StringClientTCP();
		ConsoleClient consoleClient = new ConsoleClient(tcp);
		consoleClient.run();
		consoleClient.close();
	}
}
