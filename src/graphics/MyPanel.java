package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

class MyPanel extends JPanel {
    Image image;

    public MyPanel(){
        image = Toolkit.getDefaultToolkit().getImage("sample.jpg");
    }

    public void paintComponent(Graphics g){
        if (image != null){
            g.drawImage(image, 0, 0, this);
        }
    }
}