/**
 * @author Bunrith Seng
 * Project 01 
 * due date: 10/10/2017
 * Java binary tree class
 * with different traversal
 * output only inorder or treewalk function
 *
 */
public class BinaryTree{
/**
 * Class containing left and right child
 * and a current node and a parent
 *
 */
	class Node{

		int data;

		Node leftChild;

		Node rightChild;

	}

	Node parent;


/**
 * 
 * @return
 * return the parent of the tree if it is found
 */
	public Node getParent() {

	return parent;

	}
/**
 * creat an empty binary tree--a null parent pointer
 */
	BinaryTree(){
		
	parent = null;
	}
/**
 * 
 * @param data
 * Give a binary search tree a number
 * insert a new node  and searching data
 */
	public void insertNode(int data) {

		Node currentNode = parent;

		while(true) {

			if (currentNode == null) {

				currentNode = new Node();

				currentNode.data = data;

				currentNode.rightChild = null;

				currentNode.leftChild = null;

				parent = currentNode;

				break;

			}

			else if (data < currentNode.data) {

				if (currentNode.leftChild !=null ) {

					currentNode =currentNode.leftChild;

				}

				else if (currentNode.leftChild == null) {

					Node tempNode = new Node();

					tempNode.data=data;

					tempNode.leftChild=null;

					tempNode.rightChild=null;

					currentNode.leftChild = tempNode;

					break;

				}

			}



			else if (data > currentNode.data) {
	
				if (currentNode.rightChild != null) {

					currentNode = currentNode.rightChild;

				}

				else

					if (currentNode.rightChild == null) {

						Node tempNode = new Node();

						tempNode.data = data;

						tempNode.leftChild = null;

						tempNode.rightChild = null;

						currentNode.rightChild = tempNode;

						break;

					}
			}

		}

}
	/**
	 * 
	 * @param node
	 * this function operates a tree walk to 
	 * arrange the node in an increasing order
	 */

	public void treeWalk(Node node) {

		if( node !=null) {

			treeWalk(node.leftChild);

			System.out.print(node.data + " ");

			treeWalk(node.rightChild);

		}

}
	/**
	 * 
	 * @param node
	 * return node in the preorder mode
	 */

	public void preorder(Node node) {

		if(node !=null) {

			System.out.print(node.data + " ");

			preorder(node.leftChild);

			preorder(node.rightChild);

		}

}
	/**
	 * 
	 * @param node
	 * return node in the postorder mode
	 */

	public void postorder(Node node) {

		if(node !=null) {

			postorder(node.leftChild);

			postorder(node.rightChild);

			System.out.print(node.data +" ");

		}

}
	/**
	 * 
	 * @param args
	 * main function to return and output 
	 * the insert numbers in either inorder,
	 * postorder, or preorder
	 */

	public static void main(String args[]) {

		int a[] = {3,201,60,30,45};

		BinaryTree tree = new BinaryTree();

		for(int i=0 ;i< a.length; i++)

			tree.insertNode(a[i]);


		System.out.println("treeWalk in increasing order: \n");

		tree.treeWalk(tree.getParent());


	}

}