package PreTesting_CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.CSVReaderBuilder;

//	Reference: https://www.callicoder.com/java-read-write-csv-file-opencsv/
public class testingCoonectToCSV2 {
	
	private static final String SAMPLE_CSV_FILE_PATH = "./Data/LoginCredentials_withHeader.csv";
	
	public static void main(String[] args) throws IOException, CsvException {
		/*
			try (
					Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
					
					//	Header Row included
					//CSVReader csvReader = new CSVReader(reader);
					
					//	To Skip Header Row
					CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
				)
		*/
		
		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				
		//	Header Row included
		//CSVReader csvReader = new CSVReader(reader);
				
		//	To Skip Header Row
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		
		/*
			// Reading Records One by One in a String array
			System.out.println("Reading Records One by One in a String array");
				
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				System.out.println("UserID   : " + nextRecord[0]);
				System.out.println("PassWord : " + nextRecord[1]);
				System.out.println("Message  : " + nextRecord[2]);
				System.out.println("==========================");
			}
		*/
		
		
			//	Reading All Records at once into a List<String[]>
			//	Note:	Since this method loads the entire CSV contents into memory,
			//			it is not suitable for large CSV files.
				
			System.out.println("Reading All Records at once into a List<String[]>");
				
			List<String[]> records = csvReader.readAll();
			for (String[] record : records) {
				System.out.println("UserID   : " + record[0]);
				System.out.println("PassWord : " + record[1]);
				System.out.println("Message  : " + record[2]);
				System.out.println("---------------------------");
			}
	}
}