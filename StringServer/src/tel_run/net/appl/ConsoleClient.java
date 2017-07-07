package tel_run.net.appl;

import java.io.IOException;
import java.util.Scanner;

import tel_run.net.IStringClient;

public class ConsoleClient {
	IStringClient stringClient;
	Scanner scanner;

	public ConsoleClient(IStringClient stringClient) {
		super();
		this.stringClient = stringClient;
		scanner = new Scanner(System.in);
	}
	
	public void run() throws IOException
	{
		while(true)
		{
			System.out.println("Enter line or exit");
			String line = scanner.nextLine();
			if (line.equals("exit"))
				break;
			String response = stringClient.sendAndReseive(line);
			System.out.println(response);
		}
	}
	
	public void close() throws IOException
	{
		scanner.close();
		stringClient.close();
	}
}
