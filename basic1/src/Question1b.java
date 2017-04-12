
public class Question1b {

	public static void main(String[] args) {
		ArrayStack arrayQueue = new ArrayStack();
		//ArrayDeque circularQueue = new ArrayDeque();

		for(int i = 0; i < 5; i++){
			arrayQueue.push((int)(Math.random()*10));
			arrayQueue.print();	
		}
		for(int i = 0; i < 5; i++){
			arrayQueue.pop();
			arrayQueue.print();	
		}
		
		for(int i = 0; i < 100; i++){
			//circularQueue.push((int)(Math.random()*10));
			//circularQueue.print();
		}														
	}
}
