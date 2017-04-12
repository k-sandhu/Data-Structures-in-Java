package q1;

public class BT {
	public class BTn{

		/**
		 * Pointer to the left child of a node
		 */
		public BTn left;

		/**
		 * Pointer to the right child of a node
		 */
		public BTn right;

		/**
		 * Pointer to the parent of a node
		 */
		public BTn parent;

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
	 * Finds and returns the node with value x		(1)
	 * <p>
	 * find(int x) traverses the tree to find a node with value equal to x 		(2)
	 * This can be easily implemented with a generic or a node as parameter. 
	 * This method can also be implemented using recursion.
	 * 
	 * @param x new value to be added to the binary search tree
	 * @return m node after which the value x fits 
	 */
	public BTn findNode(int x){

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
			 * m is returned as soon as it is found
			 */
			if(m.value == x) {
				return m;
			}
			/**
			 * While loop goes left when value of m is greater than x.
			 * This step is skipped is left child is null
			 */
			else if(m.value > x){
				m = m.left;
			}

			/**
			 * While loop goes right when value of m is smaller than x.
			 * This step is skipped is right child is null
			 */
			else if(m.value < x){
				m = m.right;
			}
		}

		/**
		 * Reaches here if m is not returned in the while loop and returns null.
		 */
		return null;
	}

	/**
	 * Returns the node visited after x in a pre-order traversal	(1)
	 * <p>
	 * Pre-order traversal visits nodes starting from the root, visiting 		(2)
	 * the node with lowest key and then making its way there to the highest key.
	 * The next node visited is determined by the how we reached the current node.
	 * If we came to the current node from the parent then the next node is left child.
	 * If left child is null then we go back to the parent.
	 * If we came to the current node from left child then we go to the right child.
	 * If right child is null we go to the parent.
	 * If we came to the current node from the right child, next node is parent.
	 * 
	 * @param x is the current node
	 * @return Node to be visited after x during pre-order traversal 
	 */
	public BTn preorderNext(BTn x){
		/**
		 * Is used to temporarily store the value of the next node to be visited
		 */
		BTn next = null;

		/**
		 * Checks to see if null has been passed to the method
		 */
		if(x == null){
			System.out.println("Root with value " + x + " is not present in the tree");
			return null;
		}
		/**
		 * Checks to see if x.left is null. If it is null algorithm will skip this step,
		 * otherwise it will return x.left as it is the next node that will be visited during
		 * a pre-order traversal 
		 */
		else if(x.left != null) {
			next = x.left;
			System.out.println("We are going to the left child. Pre-order next for " + x.value +" is " + next.value);

		}

		/**
		 * If x.left is null checks to see if x.right is null. If it is null algorithm will skip this step,
		 * otherwise it will return x.right as it is the next node that will be visited during
		 * a pre-order traversal 
		 */
		else if(x.right != null) {
			next = x.right;
			System.out.println("We are going to the right child. Pre-order next for " + x.value +" is " + next.value);
		}

		/**
		 * If x.left is null and x.right is nullvthen x.parent the next node that will be visited during
		 * a pre-order traversal 
		 */
		else {
			next = x.parent;
			System.out.println(x.value + " has no children. We will return to the parent. Pre-order next for " + x.value +" is " + next.value);
		}
		return next;
	}

	
	/**
	 * Returns the next node visited during a post order traversal	(1)
	 * <p>
	 * Post-order traversal visits the children of a node before visiting 
	 * the parent. It starts from the left most part and recursively performs 
	 * this operation till all nodes are traversed. In terms of actual operations, 
	 * if x is the root, we exist and return null as root is the last node 
	 * visited during a post order traversal. 
	 * <p> 
	 * If x is the left child of its parent, we go to the right child of its 
	 * parent and travel to left most node of that subtree. If x is the 
	 * right child of the parent, we keep on going up the tree till we 
	 * find a node that is a left child of its parent. When we find such a 
	 * node, we go to the right sibling of this root and then go to the left 
	 * most node of this subtree. If we get to the root while doing this, we 
	 * go to the left most node of the right subtree of the root. Also, while 
	 * going up the tree, if we get to a node that is right child of the root, 
	 * we return the root and it will be the next node visited.
	 * @param x next node to be visited during a post order traversal.
	 * @return
	 */
	public BTn postorderNext(BTn x){
		if(x == null){
			System.out.println("This value is not in the tree");
			return null;
		}
		if(x == root){
			System.out.println("This is equal to the root so we are returning nada");
			return null;
		}
		else if(x.parent.left == x){
			x = x.parent.right;
			while (x.left != null){
				x = x.left;
			}
			System.out.println("We first went to the right sibling and then all the way down. Next post order is " + x.value);
		}
		else if(x.parent.right == x){
			while(x.left != x || x != root){
				if(x.parent == root && x.parent.right == x){
					System.out.println("Root is the next in post order");
					return root;
				}
				x = x.parent;
			}
			while(x.left != null){
				x = x.left;
			}
			System.out.println("We first went up and then all the way down. Next post order is " + x.value);
		}
		return x;
	}

	/**
	 * Returns the node visited after x in a in-order traversal	(1)
	 * <p>
	 * Returns the node visited after x in a inorder traversal. In-order	(2)
	 * traversal visits nodes starting from the root and traverses its way 
	 * through each node at a depth before going to lower level and 
	 * traversing all the nodes on that level. In order to perform a in-order 
	 * traversal we need to copy all the nodes of a binomial tree into an 
	 * array and then iterate over those nodes to find the node we are
	 * looking for and return the value at the next index of that array. 
	 * In order traversal is a combination of 2 methods (1) that copies 
	 * all the elements of a binomial tree into an array and (2) one that 
	 * searches for that node in the array and returns the next node. 
	 * 
	 * @param x is the current node 									(3)
	 * @return Node to be visited after x during in-order traversal 
	 */
	public BTn inorderNext(BTn x) {

		/**
		 * Check to see if the right child is null. If it is not null, using the
		 * right child we find our way to the node with lowest value that is still
		 * higher than x. This is the node that has no left children and has the
		 * lowest value is subtree at x.right
		 */
		if (x.right != null) {
			x = x.right;
			while (x.left != null)
				x = x.left;
		} 

		/**
		 * If x.right is null, we go to parent of x if x is the left child 
		 * of its parent. If x is the right child, we go up the tree towards the
		 * root till we either get to the root or get to a node that is a left
		 * child of its parent. This will be our next node in the inorder traversal
		 */
		else {
			while (x.parent != null && x.parent.left != x)
				x = x.parent;
			x = x.parent;
		}
		System.out.println("In order next is " + x.value);
		return x;
	}




	public static void main(String[] args) {
		BT bt = new BT();
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
		bt.preorderNext(bt.findNode(6));
		System.out.println("");
		bt.preorderNext(bt.findNode(13));
		System.out.println("");
		bt.preorderNext(bt.findNode(17));
		System.out.println("");
		bt.preorderNext(bt.findNode(8));
		System.out.println("");
		bt.preorderNext(bt.findNode(22));
		System.out.println("");
		
		
		bt.inorderNext(bt.findNode(17));
		System.out.println("");
		bt.inorderNext(bt.findNode(8));
		System.out.println("");
		bt.inorderNext(bt.findNode(22));
		System.out.println("");
		bt.inorderNext(bt.findNode(10));
		System.out.println("");
		
		bt.postorderNext(bt.findNode(17));
		System.out.println("");
		bt.postorderNext(bt.findNode(8));
		System.out.println("");
		bt.postorderNext(bt.findNode(22));
		System.out.println("");	
	}
}

