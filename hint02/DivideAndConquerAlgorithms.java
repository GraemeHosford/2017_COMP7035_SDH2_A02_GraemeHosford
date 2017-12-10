// Name: Graeme Hosford
// Student ID: R00147327
// Linear Data Structures & Algorithms Assignment 02

package hint02;
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
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		if(m.length() == 0) {
			scenario = 1;
		} else {
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		case 1:
			System.out.println("The list is empty");
			break;
		case 2:

			int first = m.getElement(0);

			System.out.println(first);
			m.removeElement(0);
			recursiveDisplayElements(m);
			m.addElement(0, first);

			break;
		}			
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		if(m.length() == 0) {
			scenario = 1;
		} else {
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		case 1:
			res = new MyDynamicList<>();
			break;
		case 2:

			int first = m.getElement(0);
			m.removeElement(0);

			res = smallerMyList(m, e);

			if(first < e) {
				res.addElement(0, first);
			}

			m.addElement(0, first);

			break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		if(m.length() == 0) {
			scenario = 1;
		} else {
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		case 1:
			res = new MyDynamicList<>();
			break;
		case 2:

			int first = m.getElement(0);
			m.removeElement(0);

			res = biggerEqualMyList(m, e);

			if(first >= e) {
				res.addElement(0, first);
			}

			m.addElement(0, first);

			break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList m1 is empty
		if (m1.length() == 0) 
			scenario = 1;
		else{
			//Rule 2. MyList m2 is empty
			if (m2.length() == 0) 
				scenario = 2;
			else{
				//int m1E0 = m1.getElement(0);
				//int m2E0 = m2.getElement(0);

				//Rule 3. m1 first element smaller or equal than m2 first element
				//if (m1E0 < m2E0)
					scenario = 3;	
				//Rule 4. m1 first element bigger than m2 first element
				//else
				//	scenario = 4;	
			}
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		int size = 0;
		int e0 = 0;
		int auxE = 0;

		switch(scenario){	

		//Rule 1. MyList m1 is empty
		case 1: 
			//1. We create the new list as a result
			res = new MyDynamicList<Integer>();

			//2. We traverse all elements of m2, adding them to the list
			size = m2.length() - 1;
			while (size >= 0){
				//2.1. We access to the element in m2
				auxE = m2.getElement(size);

				//2.2. We append the element to res
				res.addElement(0, auxE); 

				//2.3. We decrease the index of size
				size--;
			}

			break;

			//Rule 2. MyList m2 is empty
		case 2: 
			//1. We create the new list as a result
			res = new MyDynamicList<Integer>();

			//2. We traverse all elements of m1, adding them to the list
			size = m1.length() - 1;
			while (size >= 0){
				//2.1. We access to the element in m1
				auxE = m1.getElement(size);

				//2.2. We append the element to res
				res.addElement(0, auxE); 

				//2.3. We decrease the index of size
				size--;
			}

			break;

			//Rule 3. m1 first element smaller or equal than m2 first element
		case 3: 
			//1. We get the first element of m1
			e0 = m1.getElement(0);

			//2. We remove the first element from m1 we just checked
			m1.removeElement(0);

			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);

			//4. We add back e0 to the resulting list.
			res.addElement(0, e0);

			//5. We also add the element back to m1, so as to not to modify its original state
			m1.addElement(0, e0);

			break;			

			//Rule 4. m1 first element bigger than m2 first element
			/*
		case 4: 
			//1. We get the first element of m1
			e0 = m1.getElement(0);

			//2. We remove the first element from m1 we just checked
			m1.removeElement(0);

			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);

			//4. We add back e0 to the resulting list.
			res.addElement(0, e0);

			//5. We also add the element back to m1, so as to not to modify its original state
			m1.addElement(0, e0);

			break;
			*/							
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;
	}

	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		if(m.length() == 0) {
			scenario = 1;
		} else if(m.length() == 1) {
			scenario = 2;
		} else {
			scenario = 3;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		switch(scenario){
		case 1:
			res = new MyDynamicList<>();
			break;
		case 2:
			res = new MyDynamicList<>();
			res.addElement(0, m.getElement(0));
			break;
		case 3:

			MyList<Integer> smaller = null;
			MyList<Integer> bigger = null;

			int first = m.getElement(0);
			m.removeElement(0);

			smaller = smallerMyList(m, first);
			bigger = biggerEqualMyList(m, first);

			bigger = quickSort(bigger);

			bigger.addElement(0, first);

			res = concatenate(quickSort(smaller), bigger);

			m.addElement(0, first);

			break;
		}		

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;
	}		

}
