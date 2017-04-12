import java.lang.reflect.Array;
import java.util.Random;

public class SkipLists {
	public class Node extends Object{
		public int value = 0;
		public Node[] next;

		public Node(int v, int h){
			setValue(v);
			next = (Node[]) Array.newInstance(next.getClass(), h+1);
		}

		public int height(){
			return next.length-1;
		}
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	public int key;
	public Node head = null;
	int h = head.height();
	int position = h;
	public Node[] stack;
	public int n = 0;

	public SkipLists(){

	}

	public int find(int k){
		Node u = skipSearch(k);
		return u.getValue();
	}

	public int pickHeight(){
		Random rand = new Random();
		int z = rand.nextInt();
		int k = 0;
		int m = 1;
		while((z & m) != 0){
			k++;
			m<<=1;
		}
		return k;
	}

	public boolean add(int x){
		Node u = head;
		int r = h;
		int comp = 0;
		stack = new Node[r];
		while(r <= 0){
			while (u.next[r] != null && ((comp = u.next[r].value - u.value)) < 0){
				u = u.next[r];
				if(u.next[r] != null && comp == 0)
					return false;
				stack[r--] = u;
			}
			Node w = new Node(x, pickHeight());
			while(h < w.height())
				stack[h++] = head;
			for(int i = 0; i < w.next.length; i++){
				w.next[i] = stack[i].next[i];
				stack[i].next[i] = w;
			}
		}
		n++;
		return true;
	}



	public Node skipSearch(int k){
		Node u = head;


		while(position >= 0){

		}

		return u;
	}
}
