package com.bluewolf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class AssignmentUtils
{
	/* 
	 * Question 1:
	 * Given an array of integers between 1 and 1,000,000.
	 * One integer is in the array twice. Find the duplicate.
	 * 
	 *  Understanding: The input array can be of arbitrary length
	 *  and will contain integers between 1 and 1,000,000.
	 *  Hence, there is an assumption that this array may not
	 *  contain all integers from 1 to 1,000,000.
	 */

	/**
	 * findDuplicate : int[] -> int
	 * @param inputArray : The array of integers of arbitrary length
	 * and containing integers between 1 and 1,000,000
	 * @return int : The first element which has occured twice in the array
	 * or -1 if there is no such element
	 * @TimeComplexity: O(k) where k is the index at which the duplicate
	 * element is found.
	 */
	public int findDuplicate(int[] inputArray)
	{
		int arrLen = inputArray.length;
		if(arrLen == 0)
			return -1;
		
		Map<Integer, Boolean> arrMap = new HashMap<Integer, Boolean>();
		for(int arrCount = 0; arrCount < arrLen; arrCount++)
		{
			Boolean prevVal = arrMap.putIfAbsent(inputArray[arrCount], true);
			if(prevVal != null)
			{
				return inputArray[arrCount];
			}
		}
		return -1;
	}
	
	/*
	 * Question 2
	 * Find the first non-repeating character in a string:
	 */
	
	/**
	 * findFirstNonRepeatedChar : String -> Character
	 * @param str : The String from which the first non repeated character
	 * is to be found.
	 * @return Character : The first non repeated Character in the given
	 * String and null if there is none.
	 * @throws NullPointerException : If String 'str' is null
	 * @TimeComplexity : O(k) where k is the number of distinct characters 
	 * in the String
	 * The HashMap will be have one key per character and hence its size
	 * is the number of possible characters.
	 * @OverallComplexity: O(k + n) where n is the length of the String.
	 * O(n) is the complexity of the function 'getOnlyNonRepeatedChars'
	 * which is invoked once in this method. Pease refer the Contract and
	 * Purpose Statement of 'getOnlyNonRepeatedChars' for more details 
	 */
	public Character findFirstNonRepeatedChar(String str)
	{
		if(str == null)
		{
			String desc ="Cannot find non repeated character from null String";
			NullPointerException nullStrExc = new NullPointerException(desc);
			throw nullStrExc;
		}
		int resultIndex = Integer.MAX_VALUE;
		Character firstNonRepeatedChar = null;
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		charMap = getOnlyNonRepeatedChars(str);
		Iterator<Entry<Character, Integer>> mapIterator = 
				charMap.entrySet().iterator();
		while(mapIterator.hasNext())
		{
			Map.Entry<Character, Integer> currentChar = 
					(Entry<Character, Integer>) mapIterator.next();
			int currentCharVal = currentChar.getValue(); 
			if(currentCharVal!= -1 && currentCharVal < resultIndex)
			{
				resultIndex = currentCharVal;
				firstNonRepeatedChar = currentChar.getKey(); 
			}
		}
		return firstNonRepeatedChar;
	}
	
	/**
	 * getOnlyNonRepeatedChars : String -> Map<Character, Integer>
	 * @param str : The String for which a count of individual characters is
	 * to be found.
	 * @return Map<Character, Integer> : The Map having Character which appear
	 * in the String as a key and its index in String 'str' as a value. The 
	 * Character which appear twice or more have their value as -1. Therefore, 
	 * the Characters which appear once have a valid index and the lowest index 
	 * is the first non repeated Character in the String 'str'.
	 * @TimeComplexity: O(n) where n is the length of the String. 
	 * This method does a one-pass over the characters of the String 'str'
	 */
	private Map<Character, Integer> getOnlyNonRepeatedChars(String str)
	{
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] charArray = str.toCharArray();
		int arrLen = charArray.length;
		for(int charCount = 0; charCount<arrLen; charCount++)
		{
			Character currentChar = charArray[charCount];
			Integer curVal = charMap.get(currentChar);
			Integer charIndex = charCount;
			if(curVal != null)
			{
				charIndex = -1;
			}
			charMap.put(currentChar, charIndex);
		}
		return charMap;
	}
	
	/**
	 * shuffleCards : int[] -> void
	 * @param deckOfCards : The deck of 52 Cards with each card represented as
	 * an integer (1-52) in this array
	 * @effect : Shuffles the cards by randomly choosing an index
	 * @TimeComplexity : O(n) where n is the length of the array 'deckOfCards'
	 * The length is suppose to be 52 i.e. the number of cards in the deck.
	 * @throws IllegalArgumentException : If the array 'deckOfCards' is not of
	 * length 52, throws an exception
	 */
	public void shuffleCards(int[] deckOfCards)
	{
		int arrLen = deckOfCards.length;
		if(arrLen != 52)
		{
			String improperDeckMessage = "A Deck must contain 52 cards";
			IllegalArgumentException improperDeck = 
					new IllegalArgumentException(improperDeckMessage);
			throw improperDeck;
		}
		Random randomGenerator = new Random();
		for(int cardCount = 0; cardCount < arrLen; cardCount++)
		{
			int randIndex = randomGenerator.nextInt(arrLen);
			swap(deckOfCards, cardCount, randIndex);
		}
	}
	
	/**
	 * @param arr : The array of which the indexes are to be swapped.
	 * @param indexToSwap : This index will be swapped with 'randomIndex'.
	 * @param randomIndex : This index will be swapped with 'indexToSwap'.
	 * @effect: Swaps the values of 'indexToSwap' and 'randomIndex' in 
	 * integer array 'arr'.
	 * @throws IndexOutOfBoundsException : If the indexes 'indexToSwap' or
	 * 'randomIndex' are greater than or equal to length of array 'arr'.
	 */
	private void swap(int[] arr, int indexToSwap, int randomIndex)
	{
		int arrLen = arr.length;
		if(indexToSwap >= arrLen || randomIndex >= arrLen)
		{
			IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
			throw ex;
		}
		int tempVal = arr[indexToSwap];
		arr[indexToSwap] = arr[randomIndex];
		arr[randomIndex] = tempVal;
	}
	
	public static void main(String[] args)
	{
		AssignmentUtils as = new AssignmentUtils();
		int dup = as.findDuplicate(new int[]
				{3,2,1,4,5,6,7,8,9,10,11,12,13,14,15,1000000,17,18,19,20,1000000});
		System.out.println(dup);
		
		Character nonRep = as.findFirstNonRepeatedChar("DDDEABCFGHIJKLMNOLPOERA");
		System.out.println(nonRep);
		
		int[] deck = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};
		as.shuffleCards(deck);
		for(int i=0;i<52; i++)
		{
			System.out.print(deck[i]+",");
		}
				
		
	}
}
