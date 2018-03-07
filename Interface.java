import javax.swing.*;
import java.awt.*;

public class Interface{
	public Interface(){
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	frame.setContentPane(panel);
	frame.setSize(448,360);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	GridLayout layout = new GridLayout(3,4);
	panel.setLayout(layout);

	ImageIcon i0 = new ImageIcon("bart0.jpg");
	JButton b0 = new JButton(i0);
	ImageIcon i1 = new ImageIcon("bart1.jpg");
	JButton b1 = new JButton(i1);
	ImageIcon i2 = new ImageIcon("bart2.jpg");
	JButton b2 = new JButton(i2);
	ImageIcon i3 = new ImageIcon("bart3.jpg");
	JButton b3 = new JButton(i3);
	ImageIcon i4 = new ImageIcon("bart4.jpg");
	JButton b4 = new JButton(i4);	
	ImageIcon i5 = new ImageIcon("bart5.jpg");
	JButton b5 = new JButton(i5);
	ImageIcon i6 = new ImageIcon("bart6.jpg");
	JButton b6 = new JButton(i6);
	ImageIcon i7 = new ImageIcon("bart7.jpg");
	JButton b7 = new JButton(i7);
	ImageIcon i8 = new ImageIcon("bart8.jpg");
	JButton b8 = new JButton(i8);
	ImageIcon i9 = new ImageIcon("bart9.jpg");
	JButton b9 = new JButton(i9);
	ImageIcon i10 = new ImageIcon("bart10.jpg");
	JButton b10 = new JButton(i10);	
	ImageIcon i11 = new ImageIcon("bart11.jpg");
	JButton b11 = new JButton(i11);

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
	}
}
