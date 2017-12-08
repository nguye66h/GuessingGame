/**
*	DefaultBinaryTreeNode implements BinaryTreeNode
*	@author Haimi Nguyen
*	@date 04/16/17
*/
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>{

	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;

	/**
   * Get the data stored at this node.
   * @return Object data.
   */
  public T getData(){
  	return data;
  }

  /**
   * Set the data stored at this node.
   * @param data the data to be set
   */
  public void setData(T data){
  	this.data = data;
  }

  /**
   * Get the left child.
   * @return BinaryTreeNode that is left child,
   * or null if no child.
   */
  public BinaryTreeNode<T> getLeftChild(){
  	return left;
  }

  /**
   * Get the right child.
   * @return BinaryTreeNode that is right child,
   * or null if no child.
   */
  public BinaryTreeNode<T> getRightChild(){
  	return right;
  }

  /**
   * Set the left child.
   * @param left the left child
   */
  public void setLeftChild( BinaryTreeNode<T> left ){
  	this.left = left;
  }

  /**
   * Set the right child.
   * @param right the right child
   */
  public void setRightChild( BinaryTreeNode<T> right ){
  	this.right = right;
  }

  /**
   * Tests if this node is a leaf (has no children).
   * @return true if leaf node.
   */
  public boolean isLeaf(){
  	if (getLeftChild() == null && getRightChild() == null){
  		return true;
  	}
  	else{
  		return false;
  	}
  }

}