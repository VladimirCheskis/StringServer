package tel_run.net.client;

import java.util.Scanner;

import tel_run.net.IStringClient;

public class ConsoleClient extends ScannerCientController{
	public ConsoleClient(IStringClient stringClient) {
		super(stringClient, new Scanner(System.in));
		setPrintEnterLine(true);
	}
}
