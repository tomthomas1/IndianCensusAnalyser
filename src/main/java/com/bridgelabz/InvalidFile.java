package com.bridgelabz;

/**
 * Customer exception class
 * @author Tom
 *
 */
public class InvalidFile extends Exception {
	public InvalidFile() {
		super();
	}
	
	public InvalidFile(String message) {
		super(message);
	}
}
