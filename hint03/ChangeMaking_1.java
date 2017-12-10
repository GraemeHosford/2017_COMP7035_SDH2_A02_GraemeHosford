// Name: Graeme Hosford
// Student ID: R00147327
// Linear Data Structures & Algorithms Assignment 02

package hint03;
/**
 * Classical Change making problem with an unlimited amount of coins of each type. <br> 
 * Version 1: Selection function with basic policy: First available coin.<br> 
 * Leads to non-optimal solution.<br>
 * The class encapsulates all the functions of the Greedy schema<br>
 */

public class ChangeMaking_1 {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking_1(){}

	//-------------------------------------------------------------------
	// 0. displayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this function displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void displayElements(MyList<Integer> m){
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
			System.out.print("MyList has " + size + " items: [");

			//2. We traverse the items
			for (int i = 0; i < size - 1; i++)
				System.out.print(m.getElement(i) + ", ");
			System.out.println(m.getElement(size - 1) + "]");

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. getCandidate --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is very simple: Just pick the first non-discarded type of coin.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @return: The index of candidate to be selected.
	 */	
	public int getCandidate(int changeGenerated, 
			MyList<Integer> discarded, 
			MyList<Integer> coinValues){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'items'.
		int size = coinValues.length();

		//We use 'index' to state the index of the candidate being checked.
		int index = 0;

		//OP1. We traverse all elements in items, so as to find the first one not being picked so far. 
		while ((res == -1) && (index < size)){
			//OP1.1. If the item has not been picked before, we pick it
			if (discarded.getElement(index) == 0){
				res = index;
			}

			//OP1.2. We increase 'index' so as to try the next item
			index++;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 2. isValid --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param itemSelected: The index of the candidate selected.
	 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean isValid(MyList<Integer> coinValues,
			int amount,
			int changeGenerated,
			int itemSelected){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = false;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. We check if the candidate fits or not
		if (coinValues.getElement(itemSelected) + changeGenerated <= amount) {
			res = true;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	//-------------------------------------------------------------------
	// 3. isFinal --> It selects if the current solution is the final solution  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution, this function states whether it is a final solution or it can still be improved.<br> 
	 * To determine it, it checks whether there is (at least) one more coin that can be used as part of the change.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
	 * @param coinValues: The MyList containing the set of coins supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: Whether the current solution is the final solution.
	 */	
	public boolean isFinal(int changeGenerated,
			MyList<Integer> discarded,
			MyList<Integer> coinValues, 
			int amount){



		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'items'.
		int size = coinValues.length();

		//We use 'index' to state the index of the candidate being checked.
		int index = 0;

		//OP1. We traverse all elements in items, so as to check if one not being selected so far can be added to the knapsack. 
		while ((res == true) && (index < size)){
			//OP1.1. If the item has not been picked before
			if (discarded.getElement(index) == 0){
				//OP1.1.1. We check if the items fits into the knapsack. 
				// If so, then the current solution can still be improved 
				/*
				if (coinValues.getElement(index) + changeGenerated <= amount) {
					res = false;
				} else {
					discarded.addElement(index, coinValues.getElement(index));
				}
				 */
				res = false;
			}

			//OP1.2. We increase 'index' so as to try the next item
			index++;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;
	}

	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its value according to:<br>
	 * How many coins are used in the solution.<br>
	 * How accurate it is the change.<br> 
	 * @param sol: The MyList containing the solution to the problem.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param amount: The amount of change we want to generate. 
	 * @return: The value of such solution.
	 */	
	public MyList<Integer> getQuality(MyList<Integer> sol,
			int changeGenerated, 
			int amount){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'sol'.
		int size = sol.length() - 1;

		//OP1. We traverse all the items of the list
		while (size >= 0){
			//OP1.1. We add +1 for each item taken in the solution
			res.addElement(0, sol.getElement(size));

			//OP1.2. We decrease 'size' so as to try the previous item of 'sol'
			size--;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(MyList<Integer> coinValues, 
			int amount){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'items'.
		int size = coinValues.length();

		//We use 'used' as a MyList with the items being considered by selectionFunction so far.
		MyList<Integer> used = null;

		//We use 'capacityUsed' to state the amount of weight our bin contains so far.
		int changeGenerated = 0;			

		//OP1. We initialise all variables: 

		//OP1.1. 'res' is initialised to be a list of the size of items, with all values being 0.
		res = new MyDynamicList<Integer>();
		for (int i = 0; i < size; i++)
			res.addElement(0, 0);

		//OP1.2. 'used' is initialised to be a list of the size of items, with all values being 0.
		used = new MyDynamicList<Integer>();
		for (int i = 0; i < size; i++)
			used.addElement(0, 0);

		//OP2. We construct the final solution:
		while (isFinal(changeGenerated, used, coinValues, amount) == false) {
			//OP2.1 Auxiliary variables:
			//We use 'itemSelected' to state the index of the candidate being selected.
			int itemSelected = -1;

			//OP2.1. We pick the most promising candidate
			itemSelected = getCandidate(amount, used, coinValues);

			//OP2.2. If the candidate is feasible
			if (isValid(coinValues, amount, changeGenerated, itemSelected) == true){
				//OP2.2.1. We add it to the solution

				//OP2.2.2. We update the capacity used in the bin
				changeGenerated += coinValues.getElement(itemSelected);

				int numCoinsOfTypePickedSoFar = res.getElement(itemSelected);
				res.removeElement(itemSelected);
				res.addElement(itemSelected, numCoinsOfTypePickedSoFar + 1);

			} else {
				used.removeElement(itemSelected);
				used.addElement(itemSelected, coinValues.getElement(itemSelected));
			}
		}

		System.out.println("Solution = " + changeGenerated);

		//OP3. We print the solution and its associated objective value
		displayElements(res);

		res = getQuality(res, changeGenerated, amount);

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

}
