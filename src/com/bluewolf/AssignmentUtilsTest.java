package com.bluewolf;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssignmentUtilsTest {

	AssignmentUtils testAssignmentUtils = new AssignmentUtils();
	
	/**
	 * Test testFindDuplicateEmptyArray
	 * @Description : Tests the findDuplicate method with an empty integer
	 * array. Since there is no element the method should return -1. 
	 */
	@Test
	public void testFindDuplicateEmptyArray() 
	{
		int[] emptyArray = new int[]{};
		assertEquals(-1, testAssignmentUtils.findDuplicate(emptyArray));
	}
	
	/**
	 * Test testFindDuplicateNoDuplicate
	 * @Description: Tests the findDuplicate method with an array which
	 * has no duplicates. Hence the findDuplicate method should return -1.
	 */
	@Test
	public void testFindDuplicateNoDuplicate()
	{
		int[] noDuplicateArray = new int[]{5,4,2,7,1,12,13,20,90000};
		assertEquals(-1, testAssignmentUtils.findDuplicate(noDuplicateArray));
	}
	
	@Test
	public void testFindDuplicateValidArray()
	{
		int[] validArray = new int[]{5,98000,90000,2,7,2,12,13,20,90000};
		assertEquals(2, testAssignmentUtils.findDuplicate(validArray));
	}

}
