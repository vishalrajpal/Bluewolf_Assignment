package com.bluewolf;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssignmentUtilsTest {

	AssignmentUtils testAssignmentUtils = new AssignmentUtils();
	
	/**
	 * Test testFindDuplicateEmptyArray
	 * @Description : Tests the 'findDuplicate' method with an empty integer
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
	 * @Description : Tests the 'findDuplicate' method with an array which
	 * has no duplicates. Hence the 'findDuplicate' method should return -1.
	 */
	@Test
	public void testFindDuplicateNoDuplicate()
	{
		int[] noDuplicateArray = new int[]{5,4,2,7,1,12,13,20,90000};
		assertEquals(-1, testAssignmentUtils.findDuplicate(noDuplicateArray));
	}
	
	/**
	 * Test testFindDuplicateValidArray
	 * @Description : Tests the 'findDuplicate' method with an array which has
	 * several duplicates, but the 'findDuplicate' should return the first
	 * integer it finds repeated twice.
	 */
	@Test
	public void testFindDuplicateValidArray()
	{
		int[] validArray = new int[]{5,98000,90000,2,7,2,7,13,20,90000};
		assertEquals(2, testAssignmentUtils.findDuplicate(validArray));
	}
	
	/**
	 * Test testFindFirstNonRepeatedCharEveryRepeatString
	 * @Description : Tests the 'findFirstNonRepeatedChar' method with a String
	 * which has every character repeated. Hence the method should return null. 
	 */
	@Test
	public void testFindFirstNonRepeatedCharEveryRepeatString()
	{
		String everyRepeatStr = "QQWWEERRTTYY";
		Character NullNoRepeatedChar =
				testAssignmentUtils.findFirstNonRepeatedChar(everyRepeatStr);
		assertEquals(null, NullNoRepeatedChar);
	}
	
	/**
	 * Test testFindFirstNonRepeatedCharNoRepeatString
	 * @Description : Tests the 'findFirstNonRepeatedChar' method with a String
	 * which has no character repeated. Hence it should return the first
	 * character of this String.
	 */
	@Test
	public void testFindFirstNonRepeatedCharNoRepeatString()
	{
		String noRepeatString = "QWERTY";
		Character firstNoRepeatedChar = 
				testAssignmentUtils.findFirstNonRepeatedChar(noRepeatString);
		assertEquals('Q', firstNoRepeatedChar.charValue());
	}

	/**
	 * Test testShuffleCardsArrayChange
	 * @Description : Tests the 'shuffleCards' method with a deck of cards
	 * and the array should have atleast one shuffle else the test fails.
	 * Due to randomness of the values, cannot check against the exact values.
	 */
	@Test
	public void testShuffleCardsArrayChange()
	{
		boolean isChanged = false;
		int[] deck = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
				20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
				41,42,43,44,45,46,47,48,49,50,51,52};
		int[] deckToModify = new int[52];
		System.arraycopy(deck, 0, deckToModify, 0, 52);
		testAssignmentUtils.shuffleCards(deckToModify);
		for(int deckCount = 0; deckCount<52; deckCount++)
		{
			if(deck[deckCount] != deckToModify[deckCount])
			{
				isChanged = true;
				break;
			}
		}
		assertEquals(true, isChanged);
	}
}
