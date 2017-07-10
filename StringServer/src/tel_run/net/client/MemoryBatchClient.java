package tel_run.net.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tel_run.net.IStringClient;

public class MemoryBatchClient extends ScannerCientController {

	public MemoryBatchClient(IStringClient stringClient, String memoryBatch) throws FileNotFoundException {
		super(stringClient, new Scanner(memoryBatch));
		setPrintRequests(true);		
	}
}
