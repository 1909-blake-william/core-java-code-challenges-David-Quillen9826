package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String[] words = phrase.split("[, ?.@-]"); 				// splitting the string on some punctuation
		String result = "";										// initializing the output string
		for (int i = 0; i < words.length; i++) {				// for loop to traverse the array 
			if (!words[i].isEmpty()) {							// checking that the word is not empty 
				String firstLetter = Character.toString(Character.toUpperCase(words[i].charAt(0)));		//grabbing the first letter of the word
				result = result.concat(firstLetter);			// adding the first letter to the result string
			}
		}

		return result;											//return result string
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {					// checks if all sides are equal
			if (sideOne == sideTwo && sideOne == sideThree) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {						// checks if any two sides are equal
			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {						//checks that no side is equal to another
			if (sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;										// initializing the word's score and setting it to 0
		String word = string.toUpperCase();							
		for (int i = 0; i < word.length(); i++) {			// for loop to get each letter
			char letter = word.charAt(i);
			switch (letter) {								// switch case to check each letter and add to the score
			case 'A':
				score += 1;
				break;
			case 'B':
				score += 3;
				break;
			case 'C':
				score += 3;
				break;
			case 'D':
				score += 2;
				break;
			case 'E':
				score += 1;
				break;
			case 'F':
				score += 4;
				break;
			case 'G':
				score += 2;
				break;
			case 'H':
				score += 4;
				break;
			case 'I':
				score += 1;
				break;
			case 'J':
				score += 8;
				break;
			case 'K':
				score += 5;
				break;
			case 'L':
				score += 1;
				break;
			case 'M':
				score += 3;
				break;
			case 'N':
				score += 1;
				break;
			case 'O':
				score += 1;
				break;
			case 'P':
				score += 3;
				break;
			case 'Q':
				score += 10;
				break;
			case 'R':
				score += 1;
				break;
			case 'S':
				score += 1;
				break;
			case 'T':
				score += 1;
				break;
			case 'U':
				score += 1;
				break;
			case 'V':
				score += 4;
				break;
			case 'W':
				score += 4;
				break;
			case 'X':
				score += 8;
				break;
			case 'Y':
				score += 4;
				break;
			case 'Z':
				score += 10;
				break;
			default:
				break;
			}
		}
		return score;										// return the score
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String trimmed = string.trim();								// trimming whitespace
		String result = trimmed.replaceAll("[^a-zA-Z0-9]", "");		// removing all special characters

		if (result.length() > 11) {									// checks that the string is not too long
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < result.length(); i++) {				// checks each character for if it is a digit
				char letter = result.charAt(i);
				if (!Character.isDigit(letter)) {					// if it is not a digit throw an exception
					throw new IllegalArgumentException();
				}
			}
		}
		return result;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {

		String[] words = string.replaceAll("[\\n]", "").split("[ ,]");		// removing whitespace and splitting the string into individual words
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {							// for loop to collect a word
			int wordCount = 0;												// initializing a wordCount variable
			for (int j = 0; j < words.length; j++) {						// for loop to count the number of times a word is in the array
				if (words[i].equals(words[j])) {							
					wordCount++;											// increment the wordCount if the words match
				}
			}
			if (words[i] != "") {											// checking that we actually have a word and not an empty string
				map.put(words[i], wordCount);								
			}
		}
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			List<T> array = sortedList;										//create an array
			int halfOfArray = sortedList.size() / 2;						//create an int for the half of the array
			int result = halfOfArray;										//initialize a result int at half of the array
			while (t.compareTo(array.get(halfOfArray)) != 0) {				//while loop to find the element of the array
				if (t.compareTo(array.get(halfOfArray)) > 0) {				//if the element is greater than the given element 
					array = array.subList(halfOfArray, array.size());		//create a new subarray containing everything greater than the array
					halfOfArray = array.size() / 2;							//resize the new half of the array
					result += halfOfArray;									//add the new half of the array to the result
					if (array.size() == 1) {								//if you get down to a single element use the sorted list size-1
						result = sortedList.size()-1;
					}
				} else {													//if the element is lesser than the given element 
					array = array.subList(0, halfOfArray);					//create a new subarray containing everything lesser than the array
					halfOfArray = array.size() / 2;							//resize the new half of the array
					result = result - halfOfArray;							//subtract the new half of the array to the result
					if (array.size() == 1) {								//edge case for the first element 
						result = 0;
					}
				}
			}
			return result;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		boolean restOfWord = false;								// initializing boolean for telling if we are in the rest of the word
		boolean hasQ = false;									// initializing boolean if word has a q
		StringBuilder result = new StringBuilder();
		String[] words = string.split(" ");						// splitting the string into individual words
		for (String word : words) {								// for loop iterating through the words
			StringBuilder str = new StringBuilder();			// stringbuilder for first part of word
			StringBuilder str2 = new StringBuilder();			// string builder for second part of word
			for (int i = 0; i < word.length(); i++) {			// for loop iterating through each letter of a word
				char letter = word.charAt(i);					// intitializing a variable for the letter
				if (letter == 'q') {							// checking for a 'q'
					restOfWord = true;
					hasQ = true;
				}
				if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {	// checking for a vowel
					restOfWord = true;
				}
				if (!restOfWord) {								// add the letter to the first stringbuilder if its not part of the
					str.append(letter);							// rest of the world
				} else {
					if (hasQ) {									// if it has a q, add a u and ignore the next letter
						str.append("qu");
						i++;
						hasQ = false;
					} else {									//add the rest of the word to the other stringbuilder
						str2.append(letter);
					}
				}
			}
			str.append("ay ");									//adding the "ay " to the ending
			result.append(str2.toString());						//add the second part of the original word to the result
			result.append(str.toString());						//add the first part of the original word and "ay" to the result
			restOfWord = false;									//reset the restofWord boolean
		}
		return result.toString().trim();						//trim and return the result
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int power = Integer.toString(input).length();				//getting the number of digits
		int total = 0;												//initializing the total 
		for (int i = 0; i < power; i++) {							//for loop to get each digit 
			int number = Character.getNumericValue(Integer.toString(input).charAt(i));
			double n = Math.pow(number, power);						//putting each digit to the power 
			total += n;												//adding the resulting number to the total
		}
		if (total == input) {										//if the total and the input match
			return true;											//it is an Armstrong number
		} else {													//else it isn't
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList<Long>();			//initialize a list of factors

		for (long i = 2l; i <= l; i++) {					//for loop to test every number between 2 and l
			while (l % i == 0) {							//while loop so that as long as long l is divisible by i
				factors.add(i);								// it adds i to the list of factors
				l = (long) (l / i);							// and then divides l by i to get a new l
			}
		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {

			StringBuilder str = new StringBuilder();				//initialize a stringbuilder
			boolean upperCase = false;								
			int letter = 0;
			for (int i = 0; i < string.length(); i++) {				//for loop to get each letter
				letter = string.charAt(i);							//checks if the character is a letter
				if ((letter >= 97 && string.charAt(i) <= 122) || (string.charAt(i) >= 65 && string.charAt(i) <= 90)) {
					if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {	// checks if it is uppercase
						upperCase = true;
					}
					letter = letter + key;							//rotate the letter
					if (upperCase) {								//if uppercase checks if it is no longer a letter and converts back if true
						if (letter > 122) {
							letter = letter - 26;
						}
					} else {										//if lowercase checks if it is no longer a letter and converts back if true
						if (letter > 90) {
							letter = letter - 26;
						}
					}
				}
				upperCase = false;									//reset the boolean upperCase
				str.append((char) (letter));						//appends the converted letter to the string
			}
			String result = str.toString();
			return result;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		if (i < 1) {
			throw new IllegalArgumentException();			//check for valid input
		}
		List<Integer> primes = new ArrayList<Integer>();	// create a list
		primes.add(2);										//added first prime
		boolean isPrime = true;
		for (int j = 3; j < 1000000; j++) {					//starting at 3 checks every number 
			for (int k = 0; k < primes.size(); k++) {		//checks every number in the list to 
				if (j % primes.get(k) == 0) {				//see if it divides cleanly
					isPrime = false;						//if it does, it's not prime
					break;
				}
			}
			if (isPrime) {									//adds it to primes if it is prime
				primes.add(j);
			}
			isPrime = true;									//reset primes
			if (primes.size() >= i) {						//ends the loop when we are when we have enough primes
				break;
			}
		}
		return primes.get(i - 1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String lower = string.toLowerCase();					
			String words = lower.replaceAll("[^a-zA-Z0-9]", "");	//sets everything to lowercase and removes special characters
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < words.length(); i++) {				//for loop to iterate through all the words
				char letter = words.charAt(i);						//for loop to get each letter
				if (i % 5 == 0) {									//appends a space every 5th letter
					str.append(' ');
				}
				switch (letter) {									//switch case to change the letter
				case 'a':
					str.append("z");
					break;
				case 'b':
					str.append("y");
					break;
				case 'c':
					str.append("x");
					break;
				case 'd':
					str.append("w");
					break;
				case 'e':
					str.append("v");
					break;
				case 'f':
					str.append("u");
					break;
				case 'g':
					str.append("t");
					break;
				case 'h':
					str.append("s");
					break;
				case 'i':
					str.append("r");
					break;
				case 'j':
					str.append("q");
					break;
				case 'k':
					str.append("p");
					break;
				case 'l':
					str.append("o");
					break;
				case 'm':
					str.append("n");
					break;
				case 'n':
					str.append("m");
					break;
				case 'o':
					str.append("l");
					break;
				case 'p':
					str.append("k");
					break;
				case 'q':
					str.append("j");
					break;
				case 'r':
					str.append("i");
					break;
				case 's':
					str.append("h");
					break;
				case 't':
					str.append("g");
					break;
				case 'u':
					str.append("f");
					break;
				case 'v':
					str.append("e");
					break;
				case 'w':
					str.append("d");
					break;
				case 'x':
					str.append("c");
					break;
				case 'y':
					str.append("b");
					break;
				case 'z':
					str.append("a");
					break;
				default:
					str.append(letter);
					break;
				}
			}
			String result = str.toString().trim();
			return result;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String sentence = string.replaceAll("[^a-zA-Z0-9]", "");			//strips string of special characters
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < sentence.length(); i++) {						//for loop to get each letter
				char letter = sentence.charAt(i);
				switch (letter) {												//switch case to change letters
				case 'a':
					str.append("z");
					break;
				case 'b':
					str.append("y");
					break;
				case 'c':
					str.append("x");
					break;
				case 'd':
					str.append("w");
					break;
				case 'e':
					str.append("v");
					break;
				case 'f':
					str.append("u");
					break;
				case 'g':
					str.append("t");
					break;
				case 'h':
					str.append("s");
					break;
				case 'i':
					str.append("r");
					break;
				case 'j':
					str.append("q");
					break;
				case 'k':
					str.append("p");
					break;
				case 'l':
					str.append("o");
					break;
				case 'm':
					str.append("n");
					break;
				case 'n':
					str.append("m");
					break;
				case 'o':
					str.append("l");
					break;
				case 'p':
					str.append("k");
					break;
				case 'q':
					str.append("j");
					break;
				case 'r':
					str.append("i");
					break;
				case 's':
					str.append("h");
					break;
				case 't':
					str.append("g");
					break;
				case 'u':
					str.append("f");
					break;
				case 'v':
					str.append("e");
					break;
				case 'w':
					str.append("d");
					break;
				case 'x':
					str.append("c");
					break;
				case 'y':
					str.append("b");
					break;
				case 'z':
					str.append("a");
					break;
				default:
					str.append(letter);
					break;
				}
			}
			String result = str.toString().trim();
			return result;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String iSBN = string.replaceAll("[-]", "");											//strips hyphens
		boolean isValid = true;
		int total = 0;
		for (int i = 0; i < iSBN.length(); i++) {											//for loop to get each single character
			if (Character.isDigit(iSBN.charAt(i)) || iSBN.charAt(i) == 'X') {				//checks that the character is an 'X' or a digit
				if (Character.isDigit(iSBN.charAt(i))) {									//if it is a digit
					int addition = Character.getNumericValue(iSBN.charAt(i)) * (10 - i);	//parses the digit into a number and multiplies it by the length from the end of the word 
					total += addition;														//adds the number to the total
				} else {																	//it it is an 'X'
					int addition = 10 * (10 - i);											//does what the digit would do if the digit was 10
					total += addition;
				}

			} else {																		//if it has any non-X, non-digits
				isValid = false;															//invalidates the number
			}
		}
		if (total % 11 != 0) {																//invalidates the number if the total is not divisible by 11 
			isValid = false;
		}
		return isValid;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {			
		boolean foundA = false;							//create 26 different booleans, 1 for each letter
		boolean foundB = false;
		boolean foundC = false;
		boolean foundD = false;
		boolean foundE = false;
		boolean foundF = false;
		boolean foundG = false;
		boolean foundH = false;
		boolean foundI = false;
		boolean foundJ = false;
		boolean foundK = false;
		boolean foundL = false;
		boolean foundM = false;
		boolean foundN = false;
		boolean foundO = false;
		boolean foundP = false;
		boolean foundQ = false;
		boolean foundR = false;
		boolean foundS = false;
		boolean foundT = false;
		boolean foundU = false;
		boolean foundV = false;
		boolean foundW = false;
		boolean foundX = false;
		boolean foundY = false;
		boolean foundZ = false;
		String upper = string.toUpperCase();			//converts to uppercase
		for (int i = 0; i < upper.length(); i++) {		//for loop to get each letter
			char letter = upper.charAt(i);
			switch (letter) {							//switch case for setting the boolean true for each letter
			case 'A':
				foundA = true;
				break;
			case 'B':
				foundB = true;
				break;
			case 'C':
				foundC = true;
				break;
			case 'D':
				foundD = true;
				break;
			case 'E':
				foundE = true;
				break;
			case 'F':
				foundF = true;
				break;
			case 'G':
				foundG = true;
				break;
			case 'H':
				foundH = true;
				break;
			case 'I':
				foundI = true;
				break;
			case 'J':
				foundJ = true;
				break;
			case 'K':
				foundK = true;
				break;
			case 'L':
				foundL = true;
				break;
			case 'M':
				foundM = true;
				break;
			case 'N':
				foundN = true;
				break;
			case 'O':
				foundO = true;
				break;
			case 'P':
				foundP = true;
				break;
			case 'Q':
				foundQ = true;
				break;
			case 'R':
				foundR = true;
				break;
			case 'S':
				foundS = true;
				break;
			case 'T':
				foundT = true;
				break;
			case 'U':
				foundU = true;
				break;
			case 'V':
				foundV = true;
				break;
			case 'W':
				foundW = true;
				break;
			case 'X':
				foundX = true;
				break;
			case 'Y':
				foundY = true;
				break;
			case 'Z':
				foundZ = true;
				break;
			default:
				break;
			}

		}													// returns the "anding" of every boolean
		return (foundA && foundB && foundC && foundD && foundE && foundF && foundG && foundH && foundI && foundJ
				&& foundK && foundL && foundM && foundN && foundO && foundP && foundQ && foundR && foundS && foundT
				&& foundU && foundV && foundW && foundX && foundY && foundZ);
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		LocalDateTime result = LocalDateTime.now();							//instantiate a LocalDateTime
		if (given instanceof LocalDate) {									//if it's a LocalDate 
			LocalDateTime dateTime = ((LocalDate) given).atTime(0, 0, 0);	//create a LocalDateTime at the start of day
			result = dateTime.plusSeconds(1000000000);						//adding 1 gigasecond
		} else {															//else
			LocalDateTime dateTime = (LocalDateTime) given;					//collect the given
			result = dateTime.plusSeconds(1000000000);						//adding 1 gigasecond
		}
		return result;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int result = 0;														//initialize result
		HashSet<Integer> numSet = new HashSet<Integer>();					//create hashset to hold all multiples of numbers
		for (int j = 0; j < set.length; j++) {								//for loop to get the numbers in the input set
			int upperLimit = i / (set[j]);									//create an int to find the upper multiple for each int in the input set
			for (int k = 0; k <= upperLimit; k++)							//for loop to get the multiples and add them to numSet
				numSet.add(k * set[j]);
		}
		for (int l : numSet) {												//for loop to iterate through numSet
			if (l < i) {													//if the numSet element is less than the int i it added l to the result
				result += l;
			}
		}
		return result;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		boolean isValid = true;															//initialize boolean for validity of the string
		for (Character digit : string.toCharArray()) {									//for loop iterates through string and checks that it is all digits or whitespace
			if (digit != ' ' && !Character.isDigit(digit)) {
				isValid = false;
			}
		}
		if (isValid) {																	//if the string is still valid
			int total = 0;																//initialize a total int
			String number = string.replaceAll("[^0-9]", "");							//strips out the whitespace
			for (int i = 0; i < number.length(); i++) {									//for loop to iterate through the number
				if (number.length() % 2 == 0) {											//checks if the number has an even number of digits
					if (i % 2 == 0) {													//checks if if the digit number is even
						int twoTimes = Integer.parseInt(number.substring(i, i + 1));	//parses the character as an int and multiplies it by 2
						twoTimes = 2 * twoTimes;
						if (twoTimes > 9) {												//checks if the resulting number is greater than 9 and subtracts 9 from it if it does
							twoTimes = twoTimes - 9;
						}
						total += twoTimes;												//adds the int to the total
					} else {
						total += Integer.parseInt(number.substring(i, i + 1));			//else adds the int to the total
					}
				} else {
					if (i % 2 != 0) {													//checks if if the digit number is odd
						int twoTimes = Integer.parseInt(number.substring(i, i + 1));	//parses the character as an int and multiplies it by 2
						twoTimes = 2 * twoTimes;										
						if (twoTimes > 9) {												//checks if the resulting number is greater than 9 and subtracts 9 from it if it does
							twoTimes = twoTimes - 9;
						}
						total += twoTimes;												//adds the int to the total
					} else {
						total += Integer.parseInt(number.substring(i, i + 1));			//else adds the int to the total
					}

				}
			}

			if (total % 10 != 0) {														//if the total is not divisible by 10, invalidates the number
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {

		String[] words = string.replaceAll("[^a-zA-Z0-9 -]", "").split(" ");		//strips all special characters except hyphens and then splits on spaces
		int lastObject = words.length - 1;											// get the last "word"
		int first = Integer.parseInt(words[2]);										// parse the third word as an int
		int second = Integer.parseInt(words[lastObject]);							// parse the last word as an int
		int result = 0;																// initialize a result int
		switch (words[3]) {															// switch case on the fourth word to find what operation to do
		case "plus":
			result = first + second;
			break;
		case "minus":
			result = first - second;
			break;
		case "multiplied":
			result = first * second;
			break;
		case "divided":
			result = first / second;
			break;

		default:
			break;
		}
		return result;
	}

}
