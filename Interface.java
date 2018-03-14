import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.net.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.lang.Boolean;

public class Interface extends JFrame implements ActionListener{
	private JFrame frame = new JFrame("Puzzle"); // moved the objects out of constructor
	private JPanel panel = new JPanel();

	private JMenuBar menuB = new JMenuBar();
	private JMenu menu = new JMenu();
	private JMenuItem HighScore = new JMenuItem("HighScore");
	private JMenuItem Random = new JMenuItem("Random");
	private JMenuItem About = new JMenuItem("About");

	private final int rows = 3;
	private final int cols = 4;
	private JButton tiles[][] = new JButton[rows][cols];
	
	private int i,j;
	

	public Interface(){

		frame.setContentPane(panel);
		frame.setSize(448,360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setJMenuBar(menuB);
		//menuB.add(HighScore);
		//menuB.add(Random);
		//menuB.add(About);

		GridLayout layout = new GridLayout(3,4);
		panel.setLayout(layout);
	 	
		
		initTiles();
		drawPanel();
	
		frame.setVisible(true);
	} // end of constructor
	
	public void initTiles(){
		int counter = 0;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				ImageIcon tileIcon = new ImageIcon("bart" + counter + ".jpg");
				JButton tile = new JButton(tileIcon);
				tile.setMargin(new Insets(0, 0, 0, 0));
				tile.addActionListener(this);
				tiles[i][j] = tile;
				counter++;
			}
		}
	}
	
	ImageIcon iTemp = new ImageIcon(tiles[0][0].getIcon().toString());

	public void drawPanel(){
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				panel.add(tiles[i][j]);
			}
		}
		panel.repaint();
	}
	
	public boolean distance(int i, int j) {

		if(tiles[i-1][j].getIcon() == i0 ||
		   tiles[i+1][j].getIcon() == i0 ||
		   tiles[i][j-1].getIcon() == i0 || 
		   tiles[i][j-1].getIcon() == i0 )return true;

		else return false;
	}

	public void actionPerformed(ActionEvent e){  

		int count = 0;
	if (e.getSource() == tiles[0][1]){
		if (distance(0,1) == true){
			//System.out.println("FUCKEN WORKING");
		
		}
	
		
	}	

	 }// end of ActionPerformed

	

}
