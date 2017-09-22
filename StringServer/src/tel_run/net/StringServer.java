package tel_run.net;

import java.io.IOException;

public abstract class StringServer implements IStringServer {


	protected IStringProtocol protocol;
	protected boolean isBreaked = false;

	public StringServer(IStringProtocol protocol) {
		super();
		this.protocol = protocol;
	}
	
	@Override
	public void run() throws IOException
	{
		isBreaked = false;
		while(!isBreaked)
		{
			receiveAndSend();
		}		
	}
	
	protected abstract void receiveAndSend() throws IOException;
}
