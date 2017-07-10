package tel_run.net;

import java.io.IOException;

public abstract class StringServer implements IStringServer {


	protected IStringProtocol protocol;

	public StringServer(IStringProtocol protocol) {
		super();
		this.protocol = protocol;
	}
	
	@Override
	public void run() throws IOException
	{
		while(true)
		{
			receiveAndSend();
		}		
	}
	
	protected abstract void receiveAndSend() throws IOException;
}
