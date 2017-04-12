package q4;
/**
 * Commonly used hash table that handles collisions using linear probing
 * @author Kamal Sandhu
 *
 * @param <T> Generic data type 
 */

public class LinearHashTable<T> {

	/**
	 * Capacity of the hash table.
	 */
	public int capacity = 20;

	/**
	 * Tracks the number of elements stored in the hash table
	 */
	public int size;

	/**
	 * Tracks the number of places where values were stored but have 
	 * been deleted since. Equals sum of such places and size
	 */
	public int q;

	/**
	 * Array that will store all the values
	 */
	@SuppressWarnings("unchecked")
	T[] table = (T[]) new Object[capacity];

	/**
	 * "del" value will be stored at a location from where a value
	 * is deleted 
	 */
	@SuppressWarnings("unchecked")
	T del = (T) "del";

	/**
	 * Creates an empty hash table
	 */
	public LinearHashTable(){
		
	}

	/**
	 * Adds value x to the hash table		(1)
	 * <p>
	 * Adds value x to the hash table using the hash function K mod 13		(2)
	 * where K is the value of the element. Value of the element is passed
	 * to the hash(K) function and it returns i = K mod 13. Value of K is
	 * stored at table[i] location. If this location is already filled or
	 * if this location was previously taken but that value has been 
	 * deleted, then the add function iterates through the table till
	 * finds a position that is empty.
	 * 
	 * @param x element that is to be added to the table			(3)
	 * @return true if value is added to the table and false otherwise
	 */
	public boolean add(T x){		
		/**
		 * This passes the value of element x to the hash function and sets int i equal to
		 * the value that is returned
		 */
		int i = hash(x);
		
		/**
		 * 	Resize if the length of the table is less than 2 times q
		 */
		if(table.length < 2* q){
			resize(2 * q);
		}
		
		/**
		 * Checks to see if there already is an entry with this value in the table.
		 */
		if(table[i] != null && find(x) < 999999){
			System.out.print("\nOur records indicate that " + x + " is already in the database.");
			return false;
		}

		/**
		 * Aim of this while loop is to find an index i such that table[i] is null. i is 
		 * initially set to the value returned by the hash function. If that index is
		 * non-null it looks at i+1 and iterates through the table till finds a
		 * location that is null. When it gets to the end of the table, it starts
		 * looking from the start till it finds a null value. This while loop could
		 * go into an infinite loop but if the array is full, this method will exit at
		 * the first if statement and the program wont reach this point.
		 */
		while(table[i] != null){
			if(i == table.length - 1){
				i = 0;
			}
			else i++;
		}

		/**
		 * Previous while loop stops when a null location is found. Value of index where
		 * value is null is also tracked by the while loop. New value is added at this
		 * location. Size and q are incremented by 1 and true is returned.
		 */
		table[i] = x;
		size++;
		q++;
		System.out.print("\nValue " + x + " was added at: " + i);
		return true;
	}

	/**
	 * Returns true if the value of the parameter is found in the table. Returns false otherwise. 		(1)
	 * <p>
	 * This method starts looking at the location i supplied by the hash function. If the value		(2)
	 * is not found at that location, for loop goes through each element of the table once
	 * to see if its value is equal to x and exists by returning false if unsuccessful
	 * 
	 * @param x value to be found in the table						(3)
	 * @return true is value is found and false otherwise
	 */
	public int find(T x){
		int i = hash(x);
		for(int j = 0; j < table.length; j++){
			if(table[i] != null && table[i].equals(x)){
				return i;
			}
			if(i == table.length -1){
				i = 0;
			}
			else i++;
		}
		return 999999;
	}

	/**
	 * Hash function for this implementation	(1)
	 * <p>
	 * Question states that we have to use K mod 13 as the has function		(2)
	 * so this method returns this value. If the hash function generated is
	 * higher than the size of the array, we call the resize function and
	 * specify new array capacity twice the size of the hash value.
	 * 
	 * @param x	is the generic data type for which the hash code is requested				(3)
	 * @return int h which is the hash function of value x
	 */
	public int hash(T x){
		int h = (int)x % 13;
		if(h > capacity){
			resize(2* h);
		}
		return h;
	}
	
	/**
	 * Removes the value supplied and set the index at the location to 'del'
	 * @param x
	 * @return
	 */
	public boolean remove(T x){
		/**
		 * Passes x to find(x) which returns the index where the value is
		 */
		int f = find(x);
		
		/**
		 * Set the index equal to 'del' at the index and return true
		 */
		if(f == 999999){
			return false;
		}
		else {
			table[f] = del;
			return true;
		}
	}
	
	/**
	 * Standard resize operation to make sure that the array value is always
	 * larger than any index reference in the LinearHashTable class
	 * @param capacity of the new array
	 */
	@SuppressWarnings("unchecked")
	public void resize(int capacity){
		T[] table1 = (T[]) new Object[2*capacity];
		for (int i = 0; i < table.length; i++){
			table1[i] = table[i];
		}
		this.capacity = capacity;
		this.table = table1;
	}
	 
	public void print(){
		System.out.print("\nTable is: \n[ ");
		for(int i = 0; i < q; i++){
			System.out.print(table[i] + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		LinearHashTable<Integer> table = new LinearHashTable<Integer>();
		int[] data = {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};
		
		System.out.print("Copying the supplied array into a hash table using K mod 13 function.\n");
		for(int i = 0; i < data.length; i++){
			table.add(data[i]);
		}
		table.print();
		
		
		System.out.print("\nThe table looks like this after we remove 15.  Removed? " + table.remove(15));
		table.print();
		
		System.out.print("\n\nWhat happens when we try to add 15 back? ");
		table.add(15);
		table.print();
		
		
		System.out.print("\nThe table looks like this after we remove 146. Removed? " + table.remove(146));
		table.print();
		
		System.out.print("\nWhat happens when we try to add 146 back? ");
		table.add(146);
		table.print();
		
		System.out.print("\nWhat happens when we try to add 146 again? ");
		table.add(146);
		table.print();
	}

}
