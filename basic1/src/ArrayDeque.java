
public class ArrayDeque {
	public int length;
	public int n = 0;
	public int[] data;
	public int[] temp;
	
	public ArrayDeque(int length){
		data = new int[length];
		this.length = length;
	}
	
	public void push(int x){
		
		if(n+1 > length && length < 100){
			resize();
		}
		
		data[n] = x;
		n++;
	}
	
	public int pop(){
		int x = data[n];
		data[n] = 0;
		n--;
		return x;
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
