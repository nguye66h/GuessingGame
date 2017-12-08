/**
*	DefaultBinaryTree of generic type implements BinaryTree of generic type
* 	@author Haimi Nguyen
*	@date 04/19/17
*/
public class DefaultBinaryTree<T> implements BinaryTree<T>{

	private DefaultBinaryTreeNode<T> root;
	private LinkedList<T> traversal = new LinkedList<T>();

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot(){
		return root;
	}

	/**
	 * Set the root node for this tree.
	 * @param root root of tree
	 */
	public void setRoot(BinaryTreeNode<T> root){
		this.root = (DefaultBinaryTreeNode<T>)root;
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty(){
		if (root.getData() == null){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * Public method.
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal(){
		return inorderTraversal(root, traversal);
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * Private method.
	 * @return inorder List.
	 * @param root root of tree
	 * @param traversal linkedlist to save data to
	 */
	private LinkedList<T> inorderTraversal(BinaryTreeNode<T> root, LinkedList<T> traversal){
		if (root == null){
			return traversal;
		}
		else {
			if (root.getLeftChild() != null){
				inorderTraversal(root.getLeftChild(), traversal);
			}
			traversal.insertLast(root.getData());
			if (root.getRightChild() != null){
				inorderTraversal(root.getRightChild(), traversal);
			}
			return traversal;
		}
	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * Public method
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal(){
		return preorderTraversal(root, traversal);
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * Private method.
	 * @return inorder List.
	 * @param root root of tree
	 * @param traversal linkedlist to save data to
	 */
	private LinkedList<T> preorderTraversal(BinaryTreeNode<T> root, LinkedList<T> traversal){
		if (root == null){
			return traversal;
		}
		else{
			traversal.insertLast(root.getData());
			if (root.getLeftChild() != null){
				preorderTraversal(root.getLeftChild(), traversal);
			}
			if (root.getRightChild() != null){
				preorderTraversal(root.getRightChild(), traversal);
			}
			return traversal;
		}
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * Public method
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal(){
		return postorderTraversal(root, traversal);
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * Private method.
	 * @return inorder List.
	 * @param root root of tree
	 * @param traversal linkedlist to save data to
	 */
	private LinkedList<T> postorderTraversal(BinaryTreeNode<T> root, LinkedList<T> traversal){
		if (root == null){
			return traversal;
		}
		else{
			if (root.getLeftChild() != null){
				postorderTraversal(root.getLeftChild(), traversal);
			}
			if (root.getRightChild() != null){
				postorderTraversal(root.getRightChild(), traversal);
			}
			traversal.insertLast(root.getData());
			return traversal;
		}
	}


	/**
	*	main method creates binary tree of 6 dwarfs
	*/
	public static void main(String[] args) {
		DefaultBinaryTree<String> dwarfs = new DefaultBinaryTree<String>();
		DefaultBinaryTreeNode<String> happy = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> doc = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<String>();
		dwarfs.setRoot(happy);
		happy.setLeftChild(doc);
		happy.setRightChild(sleepy);
		doc.setLeftChild(bashful);
		doc.setRightChild(grumpy);
		sleepy.setRightChild(sneezy);
	}
}