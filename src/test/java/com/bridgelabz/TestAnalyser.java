package com.bridgelabz;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * We have written the test cases here.
 * @author Tom
 *
 */
public class TestAnalyser {
	StateCensusAnalyser analyser;

	@Before
	public void initialization() {
		analyser = new StateCensusAnalyser();
	}

	@Test
	public void testRecordMatch() throws InvalidFile {
		analyser.loadData("src/main/resources/IndiaStateCensusData.csv");
		assertEquals(true, analyser.checkData());
	}
	@Test
	public void testFileCheckSad() throws InvalidFile {
		analyser.loadData("src/main/resources/IndiaStateCensus.csv");
	}
}
