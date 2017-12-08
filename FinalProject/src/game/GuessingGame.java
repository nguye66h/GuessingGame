import javax.swing.JFrame;
/**
 * Guessing Game application class
 * @author haiminguyen
 * @date 5/1/17
 * */
public class GuessingGame extends JFrame{
	
	public static void main(String[] args){
		
		JFrame f = new JFrame("Limited Guessing Game");
		f.setSize(800, 600);
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.add(new GuessingGameController());
		f.setVisible( true );
	}
	
}
