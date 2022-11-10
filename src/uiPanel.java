import javax.swing.*;
import java.awt.*;

public class uiPanel extends JPanel {
    uiPanel(){
        this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        g2D.draw3DRect(20, 0, 200, 100, true);
        g2D.drawString("Function", 50,50);
        g2D.drawLine(50,50,50,200);
        g2D.drawRoundRect(50,250,100,75,5,5);

        g2D.drawArc(50,250,50,50,0,350);
    }
}
