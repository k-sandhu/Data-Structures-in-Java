/*
 * 
 * Stack methods push() and pop() using 2 queues
 * 
 * Stack is LIFO and add(x) and remove() are renamed push(x) and pop()
 * 
 * 
 * Array Stack
 * variables
 * int size
 * int add to position
 * array
 * 
 * Constructors
 * default
 * with parameters(value,
 * 
 * Methods
 * 
 * 
 * 
 * 
 * 
 */


public class ArrayStack {
	
	public int length = 1;			     	//array size at the start
	private int[] data;						//generic array that will be used
	private int n = 0;						//initial size of the array is 0
	private int[] temp;
	
	public ArrayStack(){
		 data = new int[length];
	}
	
	public void push(int x){
		if((n+1) > length && length < 100){
			resize();
		}
		for(int j = n; j > 0; j--){
			data[j] = data[j-1];
		}
		data[0] = x;
		n++;
		System.out.println(" n = " + n + "; length: " + length);
	}
	
	public int pop(){
		int a = data[0];
		for(int j = 0; j < n; j++){
			data[j] = data[j+1];
		}
		n--;
		System.out.println(" n = " + n + "; length: " + length);
		return a;
	}
	
	public int capacity(){
		return length;  					//returns the current size of the array
	}
	
	public int size(){
		return n;
	}
	
	public void resize(){
		length = length*2;
		temp = new int[length];
		for(int i = 0; i < n; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	
	public void print(){
		for(int i = 0; i < n; i++){
			System.out.print(data[i] +" ");
		}
	}
}
