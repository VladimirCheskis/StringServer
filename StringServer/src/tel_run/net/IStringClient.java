package tel_run.net;

import java.io.IOException;

public interface IStringClient {
	String sendAndReseive(String request) throws IOException;
	void close() throws IOException;
}
