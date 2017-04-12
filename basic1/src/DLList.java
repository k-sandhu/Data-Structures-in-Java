
public class DLList {
	
	// Class to construct a Node object
	public static class Node{
		
		//declaring variables to be used in node and initializing to 0 or null
		public int value = 0;
		public Node next = null;
		public Node previous = null;
		
		// default constructor
		public Node(){
		}
		
		// node constructor
		public Node(Node p, int v, Node n){
			previous = p;
			value = v;
			next = n;
		}
		
		// return the next Node of the current node
		public Node getNext(){
			return next;
		}
		
		// return the previous node of the current node
		public Node getPrevious(){
			return previous;
		}
		
		// return the value stored in the node
		public int getValue(){
			return value;
		}
		
		// changes the value of the next node from null
		public void setNext(Node n){
			next = n;
		}
		
		// changes the value of the previous node from null
		public void setPrevious(Node p){
			previous = p;
		}
	}
	
	// declare variables and objects to be used in DLList
	// all initialized as private. Why you ask?
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	// constructor
	public DLList(){
		head = new Node(null, 0, null);
		tail = new Node(head, 0, head);
		head.next = tail;
		head.previous = tail;
	}
	
	/*
	 *  adds a node and gives it the user supplied value. Value is
	 *  assigned to head if the list is empty. 
	 *  Initially the previous node is tail and the next node is head.
	 *  After the node has been created new node is made the tail with
	 *  head as the next node. If new node is the first node then it is
	 *  made the head and both next and previous point toward itself
	 */
	public void addNext(int x){
		Node newest; 
		if(head != null){
			newest = new Node(tail, x, head);
			tail = newest;
		}
		else{
			newest = new Node(null, x, null);
			head = newest;
			head.next = head;
			head.previous = head;
		}
		size++;
	}
	
	/*
	 * Trying to make two nodes to swap by changing next and previous only
	 */
	public void swap(Node x, Node y){
		if(head != null){
			x.previous.next = y;
			y.previous = x.previous;
			x.next = y.next;
			y.next = x.next;
		}
	}
	
	public int getSize(){
		
		return size;
	}
	
	public void printList(){
		Node temp = head;
		int i = 0;
		
		if(temp != null){
			while(i <= size && temp.next != null){
				System.out.println("Node " + i + " is: " + temp.value);
				i++;
			}
		}
	}
}
