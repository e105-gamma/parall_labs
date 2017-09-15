package ru.spbstu.telematics.java;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class UUIDtests{
	UUID_generator generator = new UUID_generator();
	
	@Test 
	public void test_for_correct_UUID() {
		try {
		    UUID uuid = UUID.fromString(generator.generateUUID());
		} catch (IllegalArgumentException e) {
			fail("Wrong UUID!");
		}		
    }	
}
