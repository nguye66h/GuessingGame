 import org.w3c.dom.*;

/**
*	QuestionFileReader class displays the data in the questions xml file
*/
public class QuestionFileReader {
	public static BinaryTree<String> nodeTree;
	
	/**
	* Parse info in a file
	*/
	public static BinaryTree<String> parseQuestionFile( Document document )	{
		nodeTree = new DefaultBinaryTree<String> ();
		Node docRoot =  document.getDocumentElement();
		nodeTree.setRoot(parseNode(docRoot));
		return nodeTree;
	}
	
	/**
	*	Parse nodes in a file
	*/
	public static BinaryTreeNode<String> parseNode(Node n)	{
		Element elt = (Element) n;
		String content = elt.getAttribute("text");
		BinaryTreeNode<String> root = new DefaultBinaryTreeNode<String>();
		root.setData(content);
		if (n.hasChildNodes())	{
			NodeList list = n.getChildNodes();
			for (int i = 0; i<list.getLength(); i++)	{
				Node node = list.item(i);
				if( node.getNodeType() == Node.ELEMENT_NODE )	{
					if (node.getNodeName().equals("yes")){
						BinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<String>();
						newNode.setData(node.getTextContent());
						root.setRightChild(newNode);
						NodeList list1 = node.getChildNodes();
						for (int j = 0; j < list1.getLength();j++){
							Node node1 = list1.item(j);
							if (node1 != null 
									&& node1.getNodeName().equals("question")){
								root.setRightChild(parseNode(node1));
							}
						}
						
					}
					else if (node.getNodeName().equals("no")){
						BinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<String>();
						newNode.setData(node.getTextContent());
						root.setLeftChild(newNode);
						NodeList list2 = node.getChildNodes();
						for (int j = 0; j < list2.getLength();j++){
							Node node2 = list2.item(j);
							if (node2 != null && node2.getNodeName().equals("question")){
								root.setLeftChild(parseNode(node2));
							}
						}
					}
				}
			}
		}
		return root;
	}
	
}