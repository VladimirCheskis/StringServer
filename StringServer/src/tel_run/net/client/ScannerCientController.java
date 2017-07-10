package tel_run.net.client;

import java.io.IOException;
import java.util.Scanner;

import tel_run.net.IStringClient;
import tel_run.net.Defaults;

public class ScannerCientController implements IClientController{
	IStringClient stringClient;
	Scanner scanner;
	boolean printRequests = false;

	public final boolean isPrintRequests() {
		return printRequests;
	}

	public final void setPrintRequests(boolean printRequests) {
		this.printRequests = printRequests;
	}

	public ScannerCientController(IStringClient stringClient, Scanner scanner) {
		super();
		this.stringClient = stringClient;
		this.scanner = scanner;
	}
	
	@Override
	public void run() throws IOException
	{
		while(true)
		{
			System.out.println("Enter line or exit");
			String line = scanner.nextLine();
			if (printRequests)
				System.out.println(line);			
			if (line.equals(Defaults.EXIT))
				break;
			if (line.startsWith(Defaults.REMARK_START))
				continue;			
			String response = stringClient.sendAndReseive(line);
			System.out.println(response);
		}
	}
	
	@Override	
	public void close() throws IOException
	{
		scanner.close();
		stringClient.close();
	}
}
