import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;


public class AppPanel extends JPanel {
    BufferedImage bufferImage;
    Timer timer;
    int xAxis= 0;
    int yAxis= 0;
    int a =0;
    int b = 0;
    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.GREEN);
        showBg();
        loopPaint();
       
    }

    void showBg() {
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("k.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bufferImage, xAxis,yAxis,100,100, null);

    }


    void loopPaint(){
      timer = new Timer(120, (abcd)->{
        xAxis = xAxis + 5;
        yAxis = yAxis + 18;
        if (b<=410) {
            yAxis = yAxis + 12;
            b=b+12;
        }
        else if(b<=500){
            yAxis = yAxis - 12;
            b=b+12;
        }
        if(a<=410){
            xAxis = xAxis + 5;
            a=a+5;
        }
        else if(a<=500){
            xAxis = xAxis - 5;
            a=a+5;
        }
        if (a>=500) {
            a=0;
            
        }
        if (b>=500){
            b=0;
        }
       repaint();
      });  
      timer.start();
    }
}