import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.net.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.lang.Boolean;
import java.io.*;
import java.util.Scanner;

public class Interface extends JFrame implements ActionListener{
	private JFrame frame = new JFrame("Puzzle"); // moved the objects out of constructor
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();//2nd panel for the moves number

	private JMenuBar menuB = new JMenuBar();
	private JMenu menu = new JMenu();
	private JButton HighScore = new JButton("HighScore");
	private JButton Random = new JButton("Random");
	private JButton About = new JButton("About");
	//private JMenuItem counting = new JMenuItem("Count: "+ count);

	private final int rows = 3;
	private final int cols = 4;
	private JButton tiles[][] = new JButton[rows][cols];

//bonus things

	JLabel Score = new JLabel("Score: ");
	
	private int trackX = 0, trackY = 0; // needed for the tracking of the hole
	private ImageIcon empty; // used for storing the bart0.jpg

	private int count = 0; // neede for the counter of how many times
	private JTextField textCount = new JTextField(count); //text counter of moves

//Highscore
	
	private String Name; // name in Highscore
	private String allRecord;	// for the highscore table
	private File newFile = new File("records.txt");
	private JTextField scoreName = new JTextField(10);
	private JTextField scoreWinnerN[] = new JTextField[10]; // add to panel
	private JTextField scoreWinner[] = new JTextField[10];		
	private JButton addScore = new JButton("Add to highscore list!");
	private JFrame scoreFrame = new JFrame("High Scores");
	private JPanel scorePanel = new JPanel();
	Scanner scan; // scanner


	public Interface(){

		//frame.setContentPane(panel);
		frame.add(panel,BorderLayout.CENTER);
		frame.add(panel2,BorderLayout.PAGE_END);	
		frame.setSize(458,420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuB);
		menuB.add(HighScore);
		menuB.add(Random);


		GridLayout layout = new GridLayout(3,4);
		panel.setLayout(layout);

		// put in here highscore Things
		addScore.addActionListener(this);
		//scoreFrame.add(panel,BorderLayout.CENTER);
		scoreFrame.setContentPane(scorePanel);
		scoreFrame.setSize(400,400);
		scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreFrame.setVisible(true);
		scorePanel.add(addScore);
		scorePanel.add(scoreName);
		//scorePanel.add(count); 

	 	
		initTiles();
		drawPanel();
		scoresRead();
		drawPanel2();

		empty = new ImageIcon(tiles[0][0].getIcon().toString());
		panel2.add(Score);
		panel2.add(textCount);
		frame.setVisible(false); // set to true
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
						if(isComplete()==true){break;}
					}
	
		
				}
			}
		}
		
		if(e.getSource() == addScore /*&& isComplete()==true*/){
			scoresWrite();
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


	public void scoresWrite(){

		//scoreFrame.setVisible(true);

			Name = ("");
			Name = scoreName.getText(); //.trim();
			allRecord = ("Name: " +Name);
			
			try{
			FileWriter fileW = new FileWriter(newFile);
			BufferedWriter buffW = new BufferedWriter(fileW);//make it write "count" too
			buffW.write(allRecord);
			buffW.write(count);
			buffW.newLine();
			buffW.close();
			
			}
			catch(Exception E){
				System.out.println("Problem");
			}
			
		


	}
	
	public void scoresRead(){//just for reading from the file, comparing - other method
		// make it view with a button
		int i = 0;
		String s;
		int s2;

		try{
		scan = new Scanner(newFile);
		 } catch (Exception E) {
			System.out.println("Problem");
		    }
	
		do{
		
			s = scan.next();
			scoreWinnerN[i].setText(s);
			s2 = scan.nextInt();
			//scoreWinner[i].setText(Integer.toString(s2));
	
			i++;
		}
		while(scan.hasNext()); // and or or || scan.hasNextInt()
	
		scan.close();
	}

	public void drawPanel2(){
		for (int i=0; i<10; i++) {
				scorePanel.add(scoreWinnerN[i]);
				scorePanel.add(scoreWinner[i]);
			}
		

		scorePanel.repaint();
	}
	

}
