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

	private JFrame frame = new JFrame("Sliding Puzzle"); //
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();//2nd panel for the moves number

	private final int rows = 3;
	private final int cols = 4;
	private JButton tiles[][] = new JButton[rows][cols];
	private JButton Test = new JButton();

//other things

	private JLabel Score = new JLabel("Score: ");
	private int trackX = 0, trackY = 0; // needed for the tracking of the hole
	private ImageIcon empty; // used for storing the bart0.jpg

	private int count = 0; // neede for the counter of how many moves
	private JTextField textCount = new JTextField(count); //text counter of moves 

//Highscore
	
	private String Name; // name in Highscore txt file
	private String allRecord;	// for the highscore table in txt file
	private File newFile = new File("records.txt");//new File("/home/lancs/boychev/hdrive/CourseWork110/records.txt");
	private JTextField scoreName = new JTextField(10);// name of player in the Higscore
	private JTextField scoreWinnerN[] = new JTextField[10]; // number of moves of player in the Higscore swing
	private JTextField scoreWinner[] = new JTextField[10];	// number of moves of player in the Higscore swing
	private JButton addScore = new JButton("Add to highscore list!");
	private JFrame scoreFrame = new JFrame("High Scores");
	private JPanel scorePanel = new JPanel();
	private Scanner scan; // scanner


	public Interface(){

		frame.add(panel,BorderLayout.CENTER);// main panel
		frame.add(panel2,BorderLayout.PAGE_END);// panel for moves
		frame.setSize(453,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(3,4);
		panel.setLayout(layout);

		// put in here highscore Things

		addScore.addActionListener(this);
		scoreFrame.setContentPane(scorePanel);
		scoreFrame.setSize(400,400);
		scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreFrame.setVisible(false);//the higscore frame
		scorePanel.add(addScore);
		scorePanel.add(scoreName);
	 	
		initTiles();
		drawPanel();
		openScores();
		//readScore(); // NullPointerException
		drawScorePanel();

		empty = new ImageIcon(tiles[0][0].getIcon().toString());//set the first cordiantes of the hole

		panel2.add(Score);
		textCount.setEditable(false);
		panel2.add(textCount);

		frame.setVisible(true); // the main frame
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
		//switching 3 tiles to test isComplete() 

		Test.setIcon(tiles[1][0].getIcon());// bart 4

		tiles[1][0].setIcon(tiles[1][1].getIcon());
		tiles[1][1].setIcon(tiles[0][1].getIcon());
		tiles[0][1].setIcon(Test.getIcon());
		
	
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
				return true;

	
		}
		else if(j==trackY && (trackX == i+1 || trackX == i-1) ) {	
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
						if(isComplete() == true){
							a=rows;
							b=cols;
							System.out.println("Finished");
							scoreFrame.setVisible(true);
							break;
						}
					}
	
		
				}
			}
		}
		
		if(e.getSource() == addScore){// Add to Highscore Button

			int a = count;
			String n = scoreName.getText();
			//System.out.println("HERE: " + n);
			scoreWinnerN[0].setText(n);
			scoreWinner[0].setText(Integer.toString(count));
			scoresWrite();
			scoreWinnerN[0].repaint();
		}
			

	 }// end of ActionPerformed


	public void scoresWrite(){ // writes the records in a file

			Name = ("");
			Name = scoreName.getText(); //.trim();
			allRecord = (Name + " ");

			try{
				FileWriter fileW = new FileWriter(newFile, true);
				BufferedWriter buffW = new BufferedWriter(fileW);
				buffW.write(allRecord);
				buffW.write(Integer.toString(count));
				buffW.newLine();
				buffW.close();
			
			}
			catch(Exception E){
				System.out.println("Problem with Buffered Writer! ");
			}
			
		


	}
	

	public void openScores(){ // opens the file for the highscores 

		try{
		 scan = new Scanner(newFile);
		
		 }catch (Exception ex) {
			System.out.println("Problem with file! ");
		  }
	}
	
	public void readScore(){ // NullPointerException
	int i = 0;

		do{
				String b = scan.next();
				scoreWinnerN[i].setText(b);
				int s2 = scan.nextInt();
				scoreWinner[i].setText(Integer.toString(s2));
				String temporaryString = scoreWinnerN[i].getText();
				System.out.println("PLS DO WORK:" + temporaryString);
				i++;
				
		}while(scan.hasNextInt());

		scorePanel.repaint();
		scan.close();
	}

	public void drawScorePanel(){ // puts the highscore array on the highscore panel

	String n = "none";
	int zer = 0;

		for (int i=0; i<10; i++) {

				JTextField temp = new JTextField(15);
				temp.setText(n);
				temp.setEditable(false);
				scoreWinnerN[i] = temp;
				JTextField temp2 = new JTextField(5);
				temp2.setText(Integer.toString(zer));
				temp2.setEditable(false);
				scoreWinner[i] = temp2;
				scorePanel.add(scoreWinnerN[i]);
				scorePanel.add(scoreWinner[i]);
		}
		

		scorePanel.repaint();
	}

	public boolean isComplete(){
		
		int counter = 0;
		boolean temp = false;

		for (int a=0; a<rows; a++) {
			for (int b=0; b<cols; b++) {
			
				if(((ImageIcon)tiles[a][b].getIcon()).getDescription().compareTo("bart" +counter+ ".jpg") == 0){
					counter++;
					temp = true;
				
				}
				else {
					a=rows;
					b=cols;
					temp = false;
					return false;
				}			

			}	
		}
		
		
		if (temp == true) {
			return true;
		}
		else return false;
		

	}// end of isComplete

}
