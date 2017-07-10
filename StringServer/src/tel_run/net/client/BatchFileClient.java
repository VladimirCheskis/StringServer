package tel_run.net.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import tel_run.net.IStringClient;

public class BatchFileClient extends ScannerCientController {

	public BatchFileClient(IStringClient stringClient, String fileName) throws FileNotFoundException {
		super(stringClient, new Scanner(new FileReader(fileName)));
		setPrintRequests(true);
	}
}
