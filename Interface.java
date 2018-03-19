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
	private JButton completeTiles[][] = new JButton[rows][cols];
	private JButton Test = new JButton();

//bonus things

	JLabel Score = new JLabel("Score: ");
	private int trackX = 0, trackY = 0; // needed for the tracking of the hole
	private ImageIcon empty; // used for storing the bart0.jpg

	private int count = 0; // neede for the counter of how many times
	private JTextField textCount = new JTextField(count); //text counter of moves  ++ set to not editable

//Highscore
	
	private String Name; // name in Highscore
	private String allRecord;	// for the highscore table
	//private File newFile = new File("/home/lancs/boychev/hdrive/CourseWork110/records.txt");
	private File newFile = new File("records.txt");
	private JTextField scoreName = new JTextField(10);
	private JTextField scoreWinnerN[] = new JTextField[10]; // add to panel
	private JTextField scoreWinner[] = new JTextField[10];		
	private JButton addScore = new JButton("Add to highscore list!");
	private JFrame scoreFrame = new JFrame("High Scores");
	private JPanel scorePanel = new JPanel();
	public Scanner scan; // scanner


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
		//shuffle();
		drawPanel();
		openScores();
		//readScore();
		//scoresRead();
		drawScorePanel();

		empty = new ImageIcon(tiles[0][0].getIcon().toString());
		panel2.add(Score);
		textCount.setEditable(false);
		panel2.add(textCount);
		frame.setVisible(true); // set to true
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
				completeTiles[i][j] = tile;
				counter++;
			}
			
		}
		//Test = tiles[1][0];
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
			//	trackX=i;
				//trackY=j;		
				return true;

	
		}
		else if(j==trackY && (trackX == i+1 || trackX == i-1) ) {
			//	tracknewFileX=i;
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
		
		if(e.getSource() == addScore){
			JTextField temp = new JTextField(15);
			JTextField temp2 = new JTextField(5);
			int a = count;
			String n = scoreName.getText();
			System.out.println("HERE: " + n);
			temp.setText(n);
			scoreWinnerN[1] = temp;
			temp2.setText(Integer.toString(count));
			scoreWinner[1] = temp2;
			scoresWrite();
			scorePanel.repaint();
		}
			

	 }// end of ActionPerformed


	public void scoresWrite(){ // does not work ->deletes all previous records -> it doesnt write it in the array

		//scoreFrame.setVisible(true);

			Name = ("");
			Name = scoreName.getText(); //.trim();
			//allRecord = ("Name: " +Name);
			allRecord = (Name + " ");
			try{
			FileWriter fileW = new FileWriter(newFile, true);
			BufferedWriter buffW = new BufferedWriter(fileW);//make it write "count" too
			buffW.newLine();
			buffW.write(allRecord);
			buffW.write(Integer.toString(count));
			buffW.newLine();
			buffW.close();
			
			}
			catch(Exception E){
				System.out.println("Problem");
			}
			
		


	}
	
/*	public void scoresRead(){//just for reading from the file, comparing - other method
		// make it view with a button
		int i = 0;
		String s;
		int s2;

		String n = "none";
		int zer = 0;
		/*for (int a=0; a<10; a++) {
				scoreWinnerN[a].setText(n);
				scoreWinner[a].setText(Integer.toString(zer));
		}

		try{
		 Scanner scan = new Scanner(newFile);
		 
	
			do{
		
				String b = scan.next();
				scoreWinnerN[i].setText(b);
				//s2 = scan.nextInt();
				//scoreWinner[i].setText(Integer.toString(s2));
				scorePanel.add(scoreWinnerN[i]);// problem not here
				scorePanel.add(scoreWinner[i]);// problem not here
				i++;
			}
			while(scan.hasNext() || scan.hasNextInt() ); // and or or || scan.hasNextInt()
			//while(i==10);
		scan.close();
		}catch (Exception E) {
			System.out.println("Problem here");
		    }

		/*for (int j=0; j<10; j++) {
				scorePanel.add(scoreWinnerN[j]);
				scorePanel.add(scoreWinner[j]);
		}
		

		scorePanel.repaint();
	}*/

	public void openScores(){

		try{
		 scan = new Scanner(newFile);
		
		 }catch (FileNotFoundException ex) {
			System.out.println("Problem here");
		    }
	}
	
	public void readScore(){
	int i = 0;
		//while(scan.hasNextInt()){
		do{
				String b = scan.next();
				//scoreWinnerN[i].setText(b);
				int s2 = scan.nextInt();
				//scoreWinner[i].setText(Integer.toString(s2));
				//String fff = scoreWinnerN[i].getText();
				//System.out.println("PLS DO WORK:"+fff);
				i++;
				
		}while(i<10);
			//scorePanel.repaint();
	}

	public void drawScorePanel(){
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

		/*for (int i=0; i<10; i++) {
				scorePanel.add(scoreWinnerN[i]);
				scorePanel.add(scoreWinner[i]);
		}*/
		

		scorePanel.repaint();
	}
	public boolean isComplete(){
		
		int counter = 0;
		boolean temp = false;
	//a.getIcon().toString().equals(b.getIcon().toString())
		for (int a=0; a<rows; a++) {
			for (int b=0; b<cols; b++) {
				//if (tiles[a][b].getIcon().equals(completeTiles[a][b].getIcon())){
				//if (tiles[a][b].getIcon().toString().equals(completeTiles[a][b].getIcon().toString())){
/*String desc = ((ImageIcon)button.getIcon()).getDescription();
if(desc.equals(image1.getDescription())
*/			
				if(  ((ImageIcon)tiles[a][b].getIcon()).getDescription().compareTo("bart" +counter+ ".jpg") == 0){
					counter++;
					//System.out.println("Something");
					temp = true;
				
				}
				else {
					//System.out.println("Nothing");
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
		

	}
	public void shuffle(){
	//for(int j = 0;j<6; j++){
		for (int a=0; a<rows; a++) {	
			for (int b=0; b<cols; b++) {
				if (distance(a,b) == true){
						tiles[trackX][trackY].setIcon(tiles[a][b].getIcon());
						tiles[a][b].setIcon(empty);
						trackX = a;
						trackY = b;
				

				}
			}
		}
	// }//end of j for

	}
	

}
