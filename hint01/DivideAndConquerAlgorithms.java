// Name: Graeme Hosford
// Student ID: R00147327
// Linear Data Structures & Algorithms Assignment 02

package hint01;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");

			break;

			//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");

			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){

		int biggestInt = 0;
		int res = 0;
		int first = 0;

		if(m.length() > 0) {

			first = m.getElement(0);
			m.removeElement(0);

			biggestInt = first;

			res = maxInt(m);

			if(biggestInt < res) {
				biggestInt = res;
			}

			m.addElement(0, first);

			return biggestInt;
		}

		return -1;
	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){

		int first = 0;
		int second = 0;
		boolean sorted = false;;

		if(m.length() >= 2) {

			first = m.getElement(0);
			m.removeElement(0);

			second = m.getElement(0);
			sorted = isReverse(m);

			if(first < second) {
				sorted = false;
			}

			m.addElement(0, first);

			return sorted;
		}

		return true;
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){

		int numCount;

		if(m.length() > 0) {
			int first = m.getElement(0);
			m.removeElement(0);

			numCount = getNumAppearances(m, n);

			if(n == first) {
				numCount++;
			}

			m.addElement(0, first);

			return numCount;
		}

		return 0;
	}

	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){

		if(m == 0) {
			return 1;
		}

		return n * power(n, m - 1);
	}

	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){

		int lucasNum = 0;
		int firstNum = 2;
		int secondNum = 1;

		if(n == 0) {
			return firstNum;
		} else if(n == 1) {
			return secondNum;
		} else if(n > 1) {
			lucasNum = lucas(n - 1) + lucas(n - 2);
		}

		return lucasNum;
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n) {

		int starsPerLine = 0;

		if(n > 0) {

			drawImage(n - 1);

			while(starsPerLine < n) {
				System.out.print("*");
				starsPerLine++;
			}

			System.out.println();
		}
	}
}
