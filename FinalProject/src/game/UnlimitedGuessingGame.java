import javax.swing.JFrame;
/**
 * Unlimited guessing game application class
 * @author haiminguyen
 * @date 5/1/17
 * */
public class UnlimitedGuessingGame extends JFrame{
	
	public static void main(String[] args){
		
		JFrame f = new JFrame("Unlimited Guessing Game");
		f.setSize(800, 600);
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.add(new UnlimitedGuessingGameController());
		f.setVisible( true );
	}
}
