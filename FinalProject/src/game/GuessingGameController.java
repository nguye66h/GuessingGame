import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
/**
 * Guessing game controller class
 * @author Haimi Nguyen
 * @date 04/28/17
 * */
public class GuessingGameController extends JPanel {
	
	private JButton yesButton, noButton;
	private QuestionFileReader reader = new QuestionFileReader();
	private BinaryTree<String> binaryTree;
	private BinaryTreeNode<String> curNode;
	
	/**
	 * constructor of class. Add multiple JPanels
	 * */
	public GuessingGameController(){
		super(new BorderLayout());
		reader = new QuestionFileReader();
		try	{
			//Setup XML Document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File( "question.xml" );
			Document document = builder.parse( xmlFile );
			binaryTree = reader.parseQuestionFile(document);
		}
		catch (ParserConfigurationException e)	{
			throw new RuntimeException(e);
		}
		catch (SAXException e)	{
		}
		catch (IOException e)	{
			System.out.println("Error:IOException. ");
		}
		JPanel panelFirst = new JPanel();
		panelFirst.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 10));
		JLabel labelFirst = new JLabel();
		labelFirst.setText("<html>List of animals <br> <br> BAT<br> BEE <br> FROG <br> ELEPHANT <br> COW <br> RABBIT <br> PIG <br> CROCODILE <br> BEAR <br> TIGER <br> CRAB <br> JELLYFISH <br> FISH <br> ANT <br> SNAKE</html>");
		ImageIcon pic = new ImageIcon("question.png");
		JButton button = new JButton("Click to play");
		button.setSize(getPreferredSize());
		labelFirst.setHorizontalAlignment(JLabel.CENTER);
		//labelFirst.setSize(new Dimension(20,30));
		panelFirst.add(new JLabel(pic));
		panelFirst.add(labelFirst);
		panelFirst.add(button);
		add(panelFirst, BorderLayout.CENTER);
		JLabel label = new JLabel();
		JPanel panel2 = new JPanel();
		JPanel panel2A = new JPanel();
		panel2A.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
		binaryTree = reader.nodeTree;
		BinaryTreeNode<String> root = binaryTree.getRoot();
		label.setText(root.getData().toString());
		//label.setText(binaryTree.inorderTraversal().toString());
		curNode = root;
		yesButton = new JButton("YES");
		noButton = new JButton("NO");
		panel2.add(label, BorderLayout.CENTER);
		panel2A.add(yesButton);
		panel2A.add(noButton);
		panel2.add(panel2A, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(panelFirst);
				add(panel2, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
		});
		yesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!curNode.isLeaf()){
					label.setText(curNode.getRightChild().getData());
					curNode = curNode.getRightChild();
				}
			}
		});
		noButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!curNode.isLeaf()){
					label.setText(curNode.getLeftChild().getData());
					curNode = curNode.getLeftChild();
				}
			}
		});
		System.out.println(binaryTree.inorderTraversal().toString());
		
	}
}
