/**
**	The LinkedListNode class of generic type T.
**  @author Haimi Nguyen
**  @date 03/26/17
**/
public class LinkedListNode<T>{

	T data;
	LinkedListNode<T> next;

	
	/**
	 * Set the data stored at this node.
	 * @param data the data to store in the node
	 */
	public void setData( T data ){
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 * @return T type data
	 */
	public T getData(){
		return data;
	}

	/**
	 * Set the next pointer to passed node.
	 * @param node the next node
	 */
	public void setNext( LinkedListNode<T> node ){
		next = node;
	}

	/**
	 * Get (pointer to) next node.
	 * @return the next node
	 */
	public LinkedListNode<T> getNext(){
		return next;
	}

	/** return a String representation of this node.
	 * @return a String representation of this node.
	 */
	public String toString(){
		return getData().toString();
	}

}

	