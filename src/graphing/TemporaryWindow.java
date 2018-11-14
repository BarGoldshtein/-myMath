package graphing;

import myMath.Polynom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class TemporaryWindow extends JFrame{
    String chat;
    double xmin, xmax, ymin, ymax;
    Image img;
    Polynom polynom;
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }
    public void display(Polynom poly, double xmin,double xmax, double ymin, double ymax){
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        GraphingManager graphingManager = new GraphingManager();
        this.polynom = poly;
        this.img = graphingManager.plotFunction(poly, xmin,xmax,ymin,ymax);
        this.setVisible(true);
        this.repaint();

    }
    
    public void initialize(){
        this.setUndecorated(true);
        this.setSize(1000, 600);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void close(){
        this.dispose();
    }
}
