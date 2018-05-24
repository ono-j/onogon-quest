package graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Sample extends JFrame{

	public Sample(){
		this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
	}
	public static void main(String[] args){
		new Sample();
	}
}
