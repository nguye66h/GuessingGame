/**
* 	DefaultBinarySearchTree implements BinarySearchTree
*	@author Haimi Nguyen
*	@date 04/19/17
*/
public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinarySearchTree<T>{
   
   BinaryTree<T> binaryTree = new DefaultBinaryTree<T>();

   /**
   * Insert the data into the tree, maintaining the
   * search tree invariant.
   * @param data data to insert
   */  
  public void insert( T data ){
  	insert(binaryTree.getRoot(), data);
  }

  /**
   * Insert the data into the tree, maintaining the
   * search tree invariant.
   * @param node node to insert into
   * @param data to insert
   */  
  private void insert( BinaryTreeNode<T> node, T data ){
	  
	  if (node == null){
		  node = new DefaultBinaryTreeNode<T>();
		  node.setData(data);
		  binaryTree.setRoot(node);
	  }
	  else if (search(data) == null){
	      if (node.getRightChild() == null && data.compareTo(node.getData()) > 0){
	        BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
	        newNode.setData(data);
	        node.setRightChild(newNode);
	      }
	
	      else if (node.getLeftChild() == null & data.compareTo(node.getData()) < 0){
	        BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
	        newNode.setData(data);
	        node.setLeftChild(newNode); 
	      }
	      else if (data.compareTo(node.getData()) > 0){
	        insert(node.getRightChild(), data);
	      }
	      else{
	        insert(node.getLeftChild(), data);
	      }
	  }
  	
  }

  /**
   * Search for data in the tree, finding the node
   * containing it, or null if the data is not present
   * in the tree.
   * @return the node containing data or null if none exists.
   * @param data data to search for
   */
  public BinaryTreeNode<T> search( T data ){
  	return search(binaryTree.getRoot(), data);
  }

  /**
   * Insert the data into the tree, maintaining the
   * search tree invariant.
   * @param node node to look for
   * @param data to look for
   * @return the node otherwise null
   */  
  private BinaryTreeNode<T> search( BinaryTreeNode<T> node, T data ){
	if (node == null){
		return null;
	}
	else if (node.getRightChild() == null && data.compareTo(node.getData()) > 0){
  		return null;
  	}

  	else if (node.getLeftChild() == null & data.compareTo(node.getData()) < 0){
  		return null;
  	}
  	else if (data.equals(node.getData())){
  		return node;
  	}
  	else if (data.compareTo(node.getData()) > 0){
  		return search(node.getRightChild(), data);
  	}
  	else{
  		return search(node.getLeftChild(), data);
  	}
  }
  
  /**
   * Find the minimum element in the tree.
   * @return data of min element
   */
  public T minElement(){
  	BinaryTreeNode<T> newNode = binaryTree.getRoot();
  	while (newNode.getLeftChild() != null){
  		newNode = newNode.getLeftChild();
  	}
  	return newNode.getData();
  }

  /**
   * Find the maximum element in the tree.
   * @return data of max element
   */
  public T maxElement(){
  	BinaryTreeNode<T> newNode = binaryTree.getRoot();
  	while (newNode.getRightChild() != null){
  		newNode = newNode.getRightChild();
  	}
  	return newNode.getData();
  }
  
}