/**
** Class of LinkedList of generic type T
** @author Haimi Nguyen
** @date 03/26/17
**/
public class LinkedList<T>{
	LinkedListNode<T> head;

	/**
	 * Get data stored in head node of list.
	 * @return T data of tail node
	 */
	public T getFirst(){
		if (head == null){
			return null;
		}
		else {
			return head.getData();
		}
	}
	 
	/**
	 * Get the head node of the list.
	 * @return head head node
	 */
	public LinkedListNode<T> getFirstNode(){
		return head;
	}
	 
	/**
	 * Get data stored in last node of list.
	 * @return T data of tail node
	 */
	public T getLast(){
		if (head == null){
			return null;
		}
		else{
			LinkedListNode<T> node = head;
			while (node.getNext() != null){
				node = node.getNext();
			}
			return node.getData();
		}
	}
	 
	/**
	 * Get the tail node of the list.
	 * @return LLNode tail node
	 */
	public LinkedListNode<T> getLastNode(){
		LinkedListNode<T> node = head;
		while (node.getNext() != null){
			node = node.getNext();
		}
		return node;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 * @param data the data to insert into node
	 */
	public void insertFirst( T data ){
		LinkedListNode<T> node = new LinkedListNode<T> ();
		node.setData(data);
		node.setNext(head);
		head = node;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 * @param currentNode the current node
	 * @param data data to insert into current node
	 */
	public void insertAfter( LinkedListNode<T> currentNode, T data ){
		LinkedListNode<T> node = new LinkedListNode<T> ();
		node.setData(data);
		LinkedListNode<T> formerNext = currentNode.getNext();
		currentNode.setNext(node);
		if (formerNext != null){
			node.setNext(formerNext);
		}
	}
	 
	/**
	 * Insert a new node with data at the end of the list.
	 * @param data the data to insert
	 */
	public void insertLast( T data ){
		LinkedListNode<T> node = new LinkedListNode<T> ();
		if (head == null){
			node.setData(data);
			head = node;
		}
		else {
			node.setData(data);
			getLastNode().setNext(node);
			node.setData(data);
		}
		
	}
	 
	/**
	 * Remove the first node
	 */
	public void deleteFirst(){
		if (head != null){
			if (head.getNext() != null){
				LinkedListNode<T> node = getFirstNode().getNext();
				head = node;
			}
			else {
				head = null;
			}
		}
		
	}
	 
	/**
	 * Remove the last node
	 */
	public void deleteLast(){
		if (head != null){
			if (head.getNext() != null){
				LinkedListNode<T> node = head;
				while (node.getNext() != getLast()){
				node = node.getNext();
				}
				node.setNext(null);
			}
			else{
				head = null;
			}
		}
		
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 * @param currentNode the current node
	 */
	public void deleteNext( LinkedListNode<T> currentNode ){
		if (currentNode != getLastNode()){
			currentNode.setNext(currentNode.getNext().getNext());
		}
	}
	 
	/** Return the size of linked list
	 * @return the number of nodes in this list.
	 */
	public int size(){
		int i = 0;
		LinkedListNode<T> node = getFirstNode();
		
		while (node != null){
			i++;
			node = node.getNext();
				
		}
		return i;
			
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty(){
		if (getFirst() == null){
			return true;
		}
		else{
			return false;
		}
	}
	 
	/** return a String representation of the list.
	 * @return a String representation of the list.
	 */
	public String toString(){
		String string = "";
		LinkedListNode<T> node = getFirstNode();
		while (node != null){
			string += node.toString() + " ";
			node = node.getNext();
		}
		return string;
	}
}