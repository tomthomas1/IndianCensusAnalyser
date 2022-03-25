package com.bridgelabz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 *  Class to read the csv file.
 * @author Tom
 *
 */
public class StateCensusAnalyser {
	ArrayList<CSVStateCensus> censusData = new ArrayList<CSVStateCensus>();

	/**
	 * [1] Method to load the data and display
	 * 1. The CSVReader class is used to read a CSV file. The class provides CSVReader class constructor to parse a CSV file.
	 * 2. We are using a while loop to read the file line by line.
	 * 3. We are adding the data to the list.
	 * 4. Then we are using a advanced for loop to display the list.
	 * 5. We are throwing the custom exception
	 */
	public void loadData(String filePath) throws InvalidFile, InvalidDelimiter { 

		try {
			//parsing a CSV file into CSVReader class constructor  
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/IndiaStateCensusData.csv"));
			String[] record;
			record = reader.readNext();
			//reads one line at a time 
			if (!checkHeader(record))
				throw new InvalidFile(" This is an invalid header");
			while ((record = reader.readNext()) != null) {
				if (record.length != 4) 
					//custom exception for invalid delimiter
					throw new InvalidDelimiter();
				censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
						Double.parseDouble(record[3])));
			}

		} catch (FileNotFoundException e) {
			//Throws Invalid file exception
			throw new InvalidFile(" This was an invalid File");
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (NumberFormatException e) {
			throw new InvalidFile(" This record had an invalid type ");
		}
	}

	/**
	 * We are checking the size of the list to check if we have all the entries.
	 * @return -  true if sized is 29
	 */
	public boolean checkData() {
		if (censusData.size() == 29)
			return true;
		return false;
	}
	
	/**
	 *  Method to check header if incorrect
	 * @param record - We will pass the each record
	 * @return -  return true or false
	 */
	public boolean checkHeader(String[] record) {
		return (record[0].compareTo("State") + record[1].compareTo("Population") + record[2].compareTo("AreaInSqKm")
				+ record[3].compareTo("DensityPerSqKm") == 0);
	}

}
