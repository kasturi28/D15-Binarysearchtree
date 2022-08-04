package practiseproblem;

import java.util.Scanner;

public class BinarySearchTreeProgram {

	/*
	 * Class containing left and right child of current node and key value
	 */
	static class Node {
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
	static Node root;

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
		 * Let us create BST as shown in assignment 
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

		/*
		 * To check the element present in BST or not Taking input from the user by
		 * using scnner Defining key variable
		 */
		System.out.println("Please enter the number to be checked");
		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();

		if (ifNodeExists(root, key)) {
			System.out.println("The node is present in BST");
		} else {
			System.out.println("The node is not present in BST");
		}

	}

	static boolean ifNodeExists(Node node, int key) {
		if (node == null)
			return false;

		if (node.key == key)
			return true;

		/*
		 *  then recur on left subtree /
		 */
		boolean res1 = ifNodeExists(node.left, key);

		/*
		 *  node found, no need to look further
		 */
		if (res1)
			return true;

		/*
		 * node is not found in left,
		 * so recur on right subtree
		 */
		boolean res2 = ifNodeExists(node.right, key);

		return res2;
	}

}
