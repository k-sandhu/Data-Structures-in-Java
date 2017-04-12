/*
 * Question 1a.
 * Implementing add(x), deleteMin() and size() for priority que interface.
 * 
 * Following are definitions for priority que interface.
 * 
 * add(x) – add(x) in the priority queue interface adds value x to the end of the queue. 
 * It returns true if value was added and false if it was not. 
 * 
 * deleteMin()- deleteMin() in the priority que interface removes the smallest value, y, from the queue and returns y.
 * 
 * size() – size() in the priority que interface returns the size n of the queue. 
 * 
 */


public class Question1 {
	
	public static void main(String args[]){
		
		long startTime = System.currentTimeMillis( );
		long endTime = System.currentTimeMillis( );
		long elapsed = endTime - startTime;
		System.out.println("Time taken was: " + elapsed);

		
		SLList list = new SLList();
		for(int i = 0; i <10000; i++){
			list.add((int)(Math.random()*1000));
		}
		list.printList();
		System.out.println("Size of the list is: " + list.size());
		list.deleteMin();
		System.out.println("Size of the list is: " + list.size());
		
	}	
}
