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
	private JPanel panel2 = new JPanel();//2nd panel

	private JMenuBar menuB = new JMenuBar();
	private JMenu menu = new JMenu();
	private JButton HighScore = new JButton("HighScore");
	private JButton Random = new JButton("Random");
	private JButton About = new JButton("About");
	//private JMenuItem counting = new JMenuItem("Count: "+ count);

	private final int rows = 3;
	private final int cols = 4;
	private JButton tiles[][] = new JButton[rows][cols];
	
	JLabel Score = new JLabel("Score: ");
	
	private int trackX = 0, trackY = 0; // needed for the tracking of the hole
	private ImageIcon empty;

	private int count = 0; // neede for the counter of how many times
	
	private JTextField textCount = new JTextField(count);

	public Interface(){

		//frame.setContentPane(panel);
		frame.add(panel,BorderLayout.CENTER);
		frame.add(panel2,BorderLayout.PAGE_END);	
		frame.setSize(458,420);
		//frame.setSize(448,560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuB);
		menuB.add(HighScore);
		menuB.add(Random);
		//menuB.add(counting);
		//menuB.add(new JTextField(count));
		//menuB.add(About);

		GridLayout layout = new GridLayout(3,4);
		panel.setLayout(layout);
	 	
		
		initTiles();
		drawPanel();
		empty = new ImageIcon(tiles[0][0].getIcon().toString());
		panel2.add(Score);
		panel2.add(textCount);
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


	}

	public void actionPerformed(ActionEvent e){  



	for (int a=0; a<rows; a++) {
		for (int b=0; b<cols; b++) {
			if (e.getSource() == tiles[a][b]){
				if (distance(a,b) == true){
			
					tiles[trackX][trackY].setIcon(tiles[a][b].getIcon());
					tiles[a][b].setIcon(empty);
					trackX = a;
					trackY = b;
					count++;
					textCount.setText(Integer.toString(count));
					panel2.validate();
					//break;
				}
	
		
			}
		}
	}

	 }// end of ActionPerformed

	public boolean isComplete(){
		boolean temp = false;
		byte counter = 0;
		for (int a=0; a<rows; a++) {
			for (int b=0; b<cols; b++) {
				
				ImageIcon checkI = new ImageIcon("bart" + counter + ".jpg");
				JButton checkButton = new JButton(checkI);
					if (tiles[a][b].getIcon() == checkButton.getIcon()) temp = true;

					else{
						temp = false; break;
					}

					}	
		}
		
		
		if (temp == true) return true;
		
		else return false;

	}

}
