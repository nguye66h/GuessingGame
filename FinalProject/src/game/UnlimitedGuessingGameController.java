import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.JCheckBox;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
/**
 * Unlimited Guessing game controller class
 * @author Haimi Nguyen
 * @date 04/28/17
 * */
public class UnlimitedGuessingGameController extends JPanel {
	
	private JButton yesButton, noButton;
	private QuestionFileReader reader = new QuestionFileReader();
	private BinaryTree<String> binaryTree;
	private static BinaryTreeNode<String> curNode, curNodeAdded;
	private static JPanel panel2;
	private JLabel label;
	
	/**
	 * constructor of class. Add multiple JPanels
	 * */
	public UnlimitedGuessingGameController(){
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
		panelFirst.add(new JLabel(pic));
		panelFirst.add(labelFirst);
		panelFirst.add(button);
		add(panelFirst, BorderLayout.CENTER);
		label = new JLabel();
		panel2 = new JPanel();
		JPanel panel2A = new JPanel();
		panel2A.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
		curNode = binaryTree.getRoot();
		label.setText(binaryTree.getRoot().getData());
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
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(6,1));
		JLabel animalLabel = new JLabel("What animal are you thinking of?");
		JTextField animalInput = new JTextField();
		JLabel questionLabel = new JLabel("What question would distinguish the two animals?");
		JTextField questionInput = new JTextField();
		JCheckBox answerInput = new JCheckBox("Check if your new animal gives the answer yes to the question above");
		JButton submit = new JButton("Submit");
		panel3.add(animalLabel);
		panel3.add(animalInput);
		panel3.add(questionLabel);
		panel3.add(questionInput);
		panel3.add(answerInput);
		panel3.add(submit);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
		JLabel label4 = new JLabel();
		JButton restartButton = new JButton("Restart the game");
		label4.setText("New animal has been added.");
		panel4.add(label4);
		panel4.add(restartButton);
		yesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!curNode.isLeaf()){
					label.setText(curNode.getRightChild().getData());
					curNode = curNode.getRightChild();
				}
				else{
					label.setText("That's great!");
					yesButton.setEnabled(false);
					noButton.setEnabled(false);
				}
			}
		});
		noButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!curNode.isLeaf()){
					label.setText(curNode.getLeftChild().getData());
					curNode = curNode.getLeftChild();
				}
				else{
					remove(panel2);
					add(panel3, BorderLayout.CENTER);
					repaint();
					revalidate();
				}
			}
		});
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BinaryTreeNode<String> newAnimalNode = new DefaultBinaryTreeNode<String>();
				BinaryTreeNode<String> oldAnimalNode = new DefaultBinaryTreeNode<String>();
				newAnimalNode.setData(animalInput.getText());
				oldAnimalNode.setData(curNode.getData());
				curNode.setData(questionInput.getText());
				if  (answerInput.isSelected()){
					curNode.setRightChild(newAnimalNode);
					curNode.setLeftChild(oldAnimalNode);
				
				}
				else{
					curNode.setLeftChild(newAnimalNode);
					curNode.setRightChild(oldAnimalNode);
					
				}
				curNode = binaryTree.getRoot();
				label.setText(curNode.getData());
				remove(panel3);
				add(panel4, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		restartButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(panel4);
				add(panelFirst);
				remove(panelFirst);
				add(panel2, BorderLayout.CENTER);
				System.out.println(curNode.getData());
				revalidate();
				repaint();
			}
		});
		System.out.println(binaryTree.inorderTraversal().toString());
		System.out.println(curNode.getData());
	}
}
