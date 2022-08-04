package practiseproblem;

public class BinarySearchTreeProgram {

	/*
	 * Class containing left and right child of current node and key value
	 */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	/*
	 * Defining Root of BST
	 */
	Node root;

	/*
	 * Defining Constructor
	 */
	BinarySearchTreeProgram() {
		root = null;
	}

	BinarySearchTreeProgram(int value) {
		root = new Node(value);
	}

	/*
	 * Defining method insert
	 */
	void insert(int key) {
		root = insertRec(root, key);
	}

	/*
	 * A recursive function to insert a new key in BST
	 */
	Node insertRec(Node root, int key) {

		/*
		 * If the tree is empty, return a new node
		 */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/*
		 * if the root is not empty & next value is less than root then it will added to
		 * left side
		 */
		else if (key < root.key)
			root.left = insertRec(root.left, key);
		/*
		 * if the root is not empty & next value is greater than root then it will added
		 * to right side
		 */
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/*
		 * return the (unchanged) node pointer
		 */
		return root;
	}

	void inorder() {
		inorderRec(root);
	}

	/*
	 * A utility function to do in order traversal of BST
	 */
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	/*
	 * calling main funtion to print the BST
	 */
	public static void main(String[] args) {
		BinarySearchTreeProgram tree = new BinarySearchTreeProgram();

		/*
		 * Let us create following BST 
		 *    56
		 *   / \ 
		 * 30   70
		 * / \  / \
		 *22 40 60 95
		 * \      \
		 *  11     65
		 * / \     / \
		 *3  16   63 67
		 */
		tree.insert(56);
		tree.insert(30);
		tree.insert(22);
		tree.insert(11);
		tree.insert(03);
		tree.insert(16);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(65);
		tree.insert(63);
		tree.insert(67);
		tree.insert(95);

		// print in order traversal of the BST
		tree.inorder();
	}

}
