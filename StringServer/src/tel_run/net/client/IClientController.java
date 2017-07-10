package tel_run.net.client;

import java.io.IOException;

public interface IClientController {
	public void run() throws IOException;
	public void close() throws IOException;
}
