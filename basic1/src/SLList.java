/*
 * Implementation of the singly linked list.
 * 
 * 1. Create a SLList
 * 2. Add add(x), deleteMin() and size() methods.
 */
public class SLList {

	public class Node{

		public int value; 
		public Node next; 

		public Node(int v, Node n){ 
			value = v; 
			next = n;
		}
		public Node getNext(){
			return next;			
		}
		public int getValue(){
			return value;
		}
		public void setNext(Node n){
			next = n;				
		}
	}
	

		Node head = null;			
		Node tail = null;		
		public int size = 0;		

		public SLList()
		{

		}
		
		public int size(){			
			return size;
		}
		public boolean add(int x){				//constant time
			Node newest = new Node(x, null);	//constant time
												//2 assignment for the node
						
			if(head == null){					//constant time
				head = newest;					//constant time
			}
			else{
				tail.setNext(newest);
			}
			tail = newest;
			size++;
			return true;
		}
		public Node deleteMin(){
			Node minimum = head;
			Node temp = head;
			Node beforeMin = head;
			//check to see if head is null otherwise there could be issues
			while(temp != null){
				if(temp.next != null && minimum.getValue() >= temp.getNext().getValue()){
					minimum = temp.next;
					beforeMin = temp;
				}
				temp = temp.next;
			}			
			System.out.println("Head: " + head.value + ". Minimum: " + minimum.getValue());
			System.out.println("Before minimum is: " + beforeMin.getValue());
			
			if(head != minimum){
				beforeMin.next = minimum.next;
			}
			else{
				head = head.next;
			}
			System.out.println("Head: " + head.value + ". Minimum: " + minimum.getValue());
			System.out.println("Before minimum is: " + beforeMin.getValue());
			size--;
			return minimum;
		}
		public void printList(){
			Node temp = head;
			
			while(temp!=null){
				System.out.print("Nodes: [" + temp.value + " ]");
				i++;
				temp = temp.next;
			}
		}
}

