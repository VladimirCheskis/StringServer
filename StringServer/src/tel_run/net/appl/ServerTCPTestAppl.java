package tel_run.net.appl;

import java.io.IOException;

import tel_run.net.tcp.StringServerTCP;

public class ServerTCPTestAppl {

	public static void main(String[] args) throws IOException {

		StringServerTCP server = new StringServerTCP(x->"tcp->" + x);
		server.run();
		server.close();
	}

}
