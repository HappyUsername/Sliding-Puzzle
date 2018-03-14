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
	
	
	
	private int trackX = 0, trackY = 0; // needed for the tracking of the hole
	private ImageIcon empty;
	//ImageIcon empty = new ImageIcon("bart0.jpg");
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
		empty = new ImageIcon(tiles[0][0].getIcon().toString());
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
	
	

	public void drawPanel(){
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				panel.add(tiles[i][j]);
			}
		}
		panel.repaint();
	}
	
	public boolean distance(int i, int j) {

		if(i==trackX && (trackY == j+1 || trackY == j-1) ){
			//	trackX=i;
				//trackY=j;		
				return true;

	
		}
		else if(j==trackY && (trackX == i+1 || trackX == i-1) ) {
			//	trackX=i;
				//trackY=j;		
				return true;
		}

		else return false;		


		/*if(tiles[i-1][j].getIcon() == empty){
			trackX = i-1;
			trackY = j;
			return true;
		}
		  else if(tiles[i+1][j].getIcon() == empty){
			trackX = i+1;
			trackY = j;
			return true;
		}
		 else if(tiles[i][j-1].getIcon() == empty){
			trackX = i;
			trackY = j-1;
			return true;
		}
		 else if(tiles[i][j-1].getIcon() == empty ){
			trackX = i;
			trackY = j-1;
			return true;
		}

		else return false;*/
	}

	public void actionPerformed(ActionEvent e){  

	int count = 0;

	for (int a=0; a<rows; a++) {
		for (int b=0; b<cols; b++) {
			if (e.getSource() == tiles[a][b]){
				if (distance(a,b) == true){
			
					tiles[trackX][trackY].setIcon(tiles[a][b].getIcon());
					tiles[a][b].setIcon(empty);
					trackX = a;
					trackY = b;
					count++;
					//break;
				}
	
		
			}
		}
	}

	 }// end of ActionPerformed

	

}
