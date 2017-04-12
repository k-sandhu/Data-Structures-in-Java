package q2;

/**
 * Recursive linear time algorithm to test if every node in a binary search
 * tree satisfies the search tree order property
 * @author Kamal Sandhu
 *
 */
public class BT {
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
	public BT(){
		root = null;
	}
	boolean property = true;

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
			 * aready exists in the binary tree
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
	 * Checks to see if every node of a binary search tree satisfies the   (1)
	 * search tree property
	 * <p>
	 * This algorithm has been implemented using recursion. If the node		(2)
	 * supplied is null, the method immediately returns true. Else it 
	 * goes on and checks if the property for the tree is true. It also
	 * passes the current node to the method property(x) to check if this
	 * node satisfies the property. If both these are true, recursion 
	 * continues traversing the nodes of the tree. When property becomes
	 * false at any node, recursion stops going deeper into the tree and
	 * successive recursive loops return false to the preceding loop until
	 * recursion stops and property is returned as false. If no node returns
	 * false for property(x), property continues to be true and recursion
	 * reverses when it reached the last node. This process continuously returns
	 * true to the preceding recursive loops which return true.
	 * 
	 * @param node where the search to test the binary search tree property		(3)
	 * starts							
	 * @return true if the search tree property is satisfied and false otherwise
	 */
	public boolean checkBTProperty(BTn x){
		if(x == null){
			return this.property;
		}
		if (this.property && property(x)){
			checkBTProperty(x.left);
			checkBTProperty(x.right);
		}
		return this.property;
	}
	
	/**
	 * To test if binary tree search property is true at this node		(1)
	 * <p>
	 * Method first checks to see if the node is null and the method	(2)
	 * returns false if it is. Then it checks to see if it has children.
	 * Binomial search tree property is tested with both children if it 
	 * has both, with left child if it only has left child and right child 
	 * if it only as right child. This.property is returned without 
	 * changing its value as if the node has no children as it has 
	 * neither validated the property nor ruined it
	 * 
	 * @param node that will be checked for binomial search tree property	(3)
	 * @return true if the node follows the search tree property, false if
	 * it violates it. CUrrent value of this.property is returned if node
	 * has no children
	 */
	public boolean property(BTn node){
		/**
		 * Check to see if value supplied is null and return true. Also stops
		 * the recursive loops when they get to the leaves of the tree and
		 * their children are null
		 */
		if(node == null) {
			System.out.println("Node with value 'why you no know that node will null value has no value' is null");
			return false;
		}
		
		/**
		 * Checks to see if this node has both left and right child
		 */
		else if(node.left != null && node.right != null){
			
			/**
			 * Checks the binomial tree property which states that the value
			 * of a node is larger than the left node and smaller than the
			 * right node. Returns true if the property is not violated
			 */
			if(node.left.value < node.right.value && node.left.value < node.value 
					&& node.right.value  > node.value ) {
				System.out.println("Node with value " + node.value + " satisfies the search tree property");
				return true;
			}
			
			/**
			 * If the property is violated in the last step. This statement sets
			 * the value of this.property equal to false, means that this node and
			 * the binomial tree it is a part of violates the binomial search tree
			 * property
			 */
			else{
				this.property = false;
				System.out.println("Node with value " + node.value + " violates search tree property. Program will stop now.");
				return this.property;
			}
		}
		
		/**
		 * We got here cause one of the nodes was null. Checks to see if this node 
		 * has a right child but no left child
		 */
		else if(node.left == null && node.right != null){
			
			/**
			 * Checks the binomial tree property which states that the value
			 * of a node is larger than the left node and smaller than the
			 * right node. Returns true if the property is not violated. Since
			 * we reached here cause left node was null, property will only be
			 * checked for the right node.
			 */
			if(node.right.value  > node.value ){
				System.out.println("Node with value " + node.value + " satisfies the search tree property");
				return true;
			}
			
			/**
			 * If the property is violated in the last step. This statement sets
			 * the value of this.property equal to false, means that this node and
			 * the binomial tree it is a part of violates the binomial search tree
			 * property
			 */
			else {
				this.property = false;
				System.out.println("Node with value " + node.value + " violates search tree property. Program will stop now.");
				return this.property;
			}
		}
		
		/**
		 * We got here cause one of the nodes was null and that null node was not
		 * left node. We check again to see if this node has a left child but no 
		 * right child
		 */
		else if(node.right == null && node.left != null){
			
			/**
			 * Checks the binomial tree property which states that the value
			 * of a node is larger than the left node and smaller than the
			 * right node. Returns true if the property is not violated. Since
			 * we reached here cause right node was null, property will only be
			 * checked for the left node.
			 */
			if(node.left.value  < node.value ){
				System.out.println("Node with value " + node.value + " satisfies the search tree property");
				return true;
			}
			
			/**
			 * If the property is violated in the last step. This statement sets
			 * the value of this.property equal to false, means that this node and
			 * the binomial tree it is a part of violates the binomial search tree
			 * property
			 */
			else {
				this.property = false;
				System.out.println("Node with value " + node.value + " violates search tree property. Program will stop now.");
				return this.property;
			}
		}
		/**
		 * Method reaches this return statement if the node is not
		 * equal to null or if it has no children. Means this call to 
		 * the method did not change the value of this.property and it
		 * is returned without any change
		 */
		System.out.println("Node with value " + node.value + " has no children");
		return this.property;
	}
	
	public static void main(String[] args) {
		BT bt = new BT();
		System.out.println("Adding the values to the tree. All "
				+ "additions follow the search tree order property");
		bt.add(16);
		bt.add(12);
		bt.add(18);
		bt.add(14);
		bt.add(13);
		bt.add(16);
		bt.add(15);
		bt.add(18);
		bt.add(17);
		
		System.out.println("\nOutput when I check for the search tree property following the additions");
		bt.checkBTProperty(bt.root);
		
		BTn x = bt.new BTn(19);
		bt.find(13).left = x;
		System.out.println("\nOutput after I added node with value 19 as the left child of node with value 13");
		bt.checkBTProperty(bt.root);
	}

}
