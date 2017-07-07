package tel_run.net.appl;

import java.io.IOException;

import tel_run.net.udp.StringServerUDP;

public class ServerUDPTestAppl {

	public static void main(String[] args) throws IOException {

		StringServerUDP server = new StringServerUDP(x->">" + x);
		server.run();
		server.close();
	}

}
