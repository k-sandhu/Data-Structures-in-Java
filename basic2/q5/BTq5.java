/**
 * 
 */
package q5;

/**
 * Program to assign postOrder, pre-order and in-order numbers to the nodes of a 
 * binary tree
 * @author Kamal Sandhu
 *
 */
public class BTq5 {

	/**
	 * 
	 * @author sandh
	 *
	 */
	public class BTn{

		/**
		 * Pointer to the left child of a node
		 */
		public BTn left = null;

		/**
		 * Pointer to the right child of a node
		 */
		public BTn right = null;

		/**
		 * Pointer to the parent of a node
		 */
		public BTn parent = null;

		/**
		 * Pointer to the value of a node
		 */
		public int value;

		/**
		 * Tracks the number of the node in a pre-order traversal
		 */
		public int preOrderNumber = 0;

		/**
		 * Tracks the number of the node in a post-order traversal
		 */
		public int postOrderNumber = 0;

		/**
		 * Tracks the number of the node in a in-order traversal
		 */
		public int inOrderNumber = 0;



		/**
		 * Default constructor. Creates an empty node
		 */
		public BTn(){

		}

		/**
		 * Alternate constructor. Initializes a node with a value
		 */
		public BTn(int value){
			this.value = value;
		}

		/**
		 * Returns the parent of the node
		 * @return
		 */
		public BTn getParent(){
			return parent;
		}

		/**
		 * Returns the value of the node
		 * @param n
		 * @return
		 */
		public int getValue(BTn n){
			return value;
		}

		/**
		 * Returns the left child of the node
		 * @param left
		 * @return
		 */
		public BTn getLeft(BTn left){
			return this.left;
		}

		/**
		 * Returns the right child of the node
		 * @param right
		 * @return
		 */
		public BTn getRight(BTn right){
			return this.right;
		}
	}

	/**
	 * Pointer to the root of the tree
	 */
	public BTn root;

	/**
	 * Tracks the number of elements in the tree
	 */
	public int size = 0; 

	/**
	 * A placeholder. Will be used in add(x) method
	 */
	BTn u = new BTn();

	/**
	 * Default constructor. Initializes a tree with null root
	 */
	public BTq5() {
		root = null;
	}



	/**
	 * Add method for a binary tree			(1)
	 * <p>
	 * Standard add method for binary tree. Iterates through the tree to	(2)
	 * find location (u) where the new node is to be added considering binary
	 * search tree property. New node is added to the left of u if the value
	 * of new node is smaller than u or is added to the right if the value of
	 * the new node is greater than u. This implementation does not add duplicate
	 * values. If new value to be added already exists in the tree, it is not
	 * added and false is returned. I implemented it with integer x (value) as a 
	 * parameter. It can be easily implemented using generic data type or
	 * a node as a parameter. Size is incremented after every successful addition.
	 * 
	 * @param x new value to be added to the binary tree		(3)
	 * @return true if the addition was successful
	 */
	public boolean add(int x){
		/**
		 * Will be used to temporarily store the current value. Is initialized 
		 * with the value x. This step is not needed if the method is implemented using
		 * a node as a parameter
		 */
		BTn y = new BTn(x);

		/**
		 * Check to see if the root is null. If it is, new value is added to 
		 * the root. Size is incremented, message is provided to the user and
		 * true is returned.
		 */
		if(root == null){
			root = y;
			size++;
			System.out.println("Just added root: " + root.value +". Size is: " + size);
			return true;
		}

		/**
		 * Skips the first step if the tree is not empty
		 */
		else {

			/**
			 * Invokes the find(int x) method to find a suitable position where
			 * the new value will be added preserving the binary tree search 
			 * property
			 */
			u = find(x);

			/**
			 * Checks to make sure that u is not equal to null and that value of
			 * u is not equal to x. This step is skipped if the value of u is equal
			 * to x as our tree doesnt take duplicate values.
			 */
			if(u != null && u.value != x){

				/**
				 * New node y is added as a left child of u if x is less than u.
				 * Size is incremented, message is provided to the user and
				 * true is returned.
				 */
				if(x < u.value){
					size++;
					System.out.println(x + " will be added after " + u.value + " to the left" + ". Size is: " + size);
					if(u.left != null) u.left.parent = y;
					u.left = y;
					y.parent = u;
					return true;
				}

				/**
				 * New node y is added as a right child of u if x is greater than u.
				 * Size is incremented, message is provided to the user and
				 * true is returned.
				 */
				else if(x > u.value){
					size++;
					System.out.println(x + " will be added after " + u.value + " to the right" + ". Size is: " + size);
					if(u.right != null) u.right.parent = y;
					u.right = y;
					y.parent = u;
					return true;
				}
			}
			/**
			 * Method jumps to this position if u is returned as null or if value x
			 * already exists in the binary tree
			 */
			return false;
		}
	}

	/**
	 * Standard find(int x) method for binary search trees		(1)
	 * <p>
	 * find(int x) traverses the tree to find a location where a new node 		(2)
	 * with value x would fit in a binary search tree. This can be easily
	 * implemented with a generic or a node parameter. This method can also
	 * be implemented using recursion.
	 * @param x new value to be added to the binary search tree
	 * @return m node after which the value x fits 
	 */
	public BTn find(int x){

		/**
		 * Temporary node used to store current value as the while loop traverses 
		 * through the tree.
		 */
		BTn m = root;

		/**
		 * While loops keeps on traversing the tree as long as next value encountered
		 * is not null
		 */
		while(m != null){

			/**
			 * While loop goes left when value of m is greater than x.
			 * This step is skipped is left child is null
			 */
			if(m.value > x && m.left != null){
				m = m.left;
			}

			/**
			 * While loop goes right when value of m is smaller than x.
			 * This step is skipped is right child is null
			 */
			else if(m.value < x && m.right != null){
				m = m.right;
			}

			/**
			 * m is returned when we get to place in a tree where x fits but that
			 * child is null or when loop reached the end of the tree
			 */
			else {
				return m;
			}
		}
		/**
		 * Reaches here if the root is null and null is returned.
		 */
		return m;
	}

	/**
	 * Assigns the preorder numbers to the nodes using recursion
	 * @param x node from where assignment starts
	 * @param i used to aid in recursion
	 * @return
	 */
	public int preOrder(BTn x, int i){
		if(x == null){
			return i;
		}
		assignPre(x);
		System.out.println(x.value + " has a preOrder value of " + x.preOrderNumber);
		preOrder(x.left, i);
		return preOrder(x.right, i);
	}

	/**
	 * Assigns the postorder numbers to the nodes using recursion
	 * @param x node from where assignment starts
	 * @param i used to aid in recursion
	 * @return
	 */
	public int postOrder(BTn x, int i){
		if(x == null){
			return i;
		}
		postOrder(x.right, i);
		postOrder(x.left, i);
		return assignPost(x, i);
	}

	/**
	 * Assigns the inorder numbers to the nodes using recursion
	 * @param x node from where assignment starts
	 * @param i used to aid in recursion
	 * @return
	 */
	public int inOrder(BTn x, int i){
		if(x == null){
			return i;
		}
		inOrder(x.left, i);
		assignIn(x);
		System.out.println(x.value + " has a inOrder value of " + x.inOrderNumber);
		return inOrder(x.right, i);
	}
	
	/**
	 * Used these three global integers to track the values
	 */
	int assignPre = 1;
	int assignPost = 1;
	int assignIn = 1;
	
	/**
	 * Method to assign the preOrder number and keep track of the current index
	 * @param x node to which the number is to be assigned
	 */
	public void assignPre(BTn x){
		if(x.preOrderNumber == 0)
			x.preOrderNumber = assignPre++;
		else return;
	}
	
	/**
	 * Method to assign the postOrder number and keep track of the current index
	 * @param x node to which the number is to be assigned
	 */
	public int assignPost(BTn x, int i){
		if(x.postOrderNumber == 0){
			x.postOrderNumber = assignPost++;
			System.out.println(x.value + " has a postOrder value of " + x.postOrderNumber);
			return i;
		}
		else return 0;
	}
	
	/**
	 * Method to assign the inOrder number and keep track of the current index
	 * @param x node to which the number is to be assigned
	 */
	public void assignIn(BTn x){
		if(x.inOrderNumber == 0)
			x.inOrderNumber = assignIn++;
		else return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTq5 bt = new BTq5();
		bt.add(16);
		bt.add(12);
		bt.add(8);
		bt.add(4);
		bt.add(13);
		bt.add(11);
		bt.add(10);
		bt.add(6);
		bt.add(17);
		bt.add(20);
		bt.add(22);
		bt.add(34);
		bt.add(40);
		bt.add(35);
		bt.add(25);
		bt.add(19);
		bt.add(20);

		System.out.println("");
		bt.inOrder(bt.root, 0);
		System.out.println("");
		bt.preOrder(bt.root, 0);
		System.out.println("");
		bt.postOrder(bt.root, 0);
		
	}
}
