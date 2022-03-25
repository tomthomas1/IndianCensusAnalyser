package com.bridgelabz;
import org.junit.Test;

/**
 * We have written the test cases here.
 * @author Tom
 *
 */
public class TestAnalyser {
	@Test
	public void testCensusAnalyser() {
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		analyser.loadData();
	}
}
