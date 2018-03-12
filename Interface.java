import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.net.*;
import java.awt.Image;

public class Interface extends JFrame implements ActionListener{
	JFrame frame = new JFrame(); // moved the objects out of constructor
	JPanel panel = new JPanel();

	ImageIcon i0 = new ImageIcon("bart0.jpg");	
	ImageIcon i1 = new ImageIcon("bart1.jpg");
	ImageIcon i2 = new ImageIcon("bart2.jpg");
	ImageIcon i3 = new ImageIcon("bart3.jpg");
	ImageIcon i4 = new ImageIcon("bart4.jpg");
	ImageIcon i5 = new ImageIcon("bart5.jpg");
	ImageIcon i6 = new ImageIcon("bart6.jpg");
	ImageIcon i7 = new ImageIcon("bart7.jpg");
	ImageIcon i8 = new ImageIcon("bart8.jpg");	
	ImageIcon i9 = new ImageIcon("bart9.jpg");
	ImageIcon i10 = new ImageIcon("bart10.jpg");
	ImageIcon i11 = new ImageIcon("bart11.jpg");
	
	JButton b0 = new JButton(i0); // probably b0 is not for push???
	
	JButton b1 = new JButton(i1);
	JButton b2 = new JButton(i2);
	JButton b3 = new JButton(i3);
	JButton b4 = new JButton(i4);
	JButton b5 = new JButton(i5);
	JButton b6 = new JButton(i6);
	JButton b7 = new JButton(i7);
	JButton b8 = new JButton(i8);
	JButton b9 = new JButton(i9);
	JButton b10 = new JButton(i10);	
	JButton b11 = new JButton(i11);

	public Interface(){
	b1.addActionListener(this); 
	b2.addActionListener(this);
	b3.addActionListener(this); 
	b4.addActionListener(this); 
	b5.addActionListener(this); 
	b6.addActionListener(this); 
	b7.addActionListener(this);
	b8.addActionListener(this); 
	b9.addActionListener(this); 
	b10.addActionListener(this); 
	b11.addActionListener(this);


	frame.setContentPane(panel);
	frame.setSize(448,360);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	GridLayout layout = new GridLayout(3,4);
	panel.setLayout(layout);
 

	b0.setMargin(new Insets(0, 0, 0, 0));
	b1.setMargin(new Insets(0, 0, 0, 0));
	b2.setMargin(new Insets(0, 0, 0, 0));
	b3.setMargin(new Insets(0, 0, 0, 0));
	b4.setMargin(new Insets(0, 0, 0, 0));
	b5.setMargin(new Insets(0, 0, 0, 0));
	b6.setMargin(new Insets(0, 0, 0, 0));
	b7.setMargin(new Insets(0, 0, 0, 0));
	b8.setMargin(new Insets(0, 0, 0, 0));
	b9.setMargin(new Insets(0, 0, 0, 0));
	b10.setMargin(new Insets(0, 0, 0, 0));
	b11.setMargin(new Insets(0, 0, 0, 0));

	panel.add(b0);
	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	panel.add(b4);
	panel.add(b5);
	panel.add(b6);
	panel.add(b7);
	panel.add(b8);
	panel.add(b9);
	panel.add(b10);
	panel.add(b11);
	frame.setVisible(true);
	} // end of constructor
	
	public void actionPerformed(ActionEvent e){  
	// swap the images here
		
		//ImageIcon iTemp = new ImageIcon();
		if (e.getSource() == b1){
	
			iTemp = i1;
			b1.setIcon(i0);
			b0.setIcon(iTemp);
		}
		if (e.getSource() == b2){
			//ImageIcon iTemp = new ImageIcon();
			//iTemp = i2;
			b2.setIcon(i0);
			b0.setIcon(i2);
		}
		if (e.getSource() == b3){
			b3.setIcon(i0);
			b0.setIcon(i3);
		}
		if (e.getSource() == b4){
			b4.setIcon(i0);
			b0.setIcon(i4);
		}
		if (e.getSource() == b5){
			b5.setIcon(i0);
			b0.setIcon(i5);
		}
		if (e.getSource() == b6){
			b6.setIcon(i0);
			b0.setIcon(i6);
		}
		if (e.getSource() == b7){
			b7.setIcon(i0);
			b0.setIcon(i7);
		}
		if (e.getSource() == b8){
			b8.setIcon(i0);
			b0.setIcon(i8);
		}
		if (e.getSource() == b9){
			b9.setIcon(i0);
			b0.setIcon(i9);
		}
		if (e.getSource() == b10){
			b10.setIcon(i0);
			b0.setIcon(i10);
		}
		if (e.getSource() == b11){
			b11.setIcon(i0);
			b0.setIcon(i11);
		}


	 }// end of ActionPerformed
}
