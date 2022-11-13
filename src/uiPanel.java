import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class uiPanel extends JPanel {
    uiPanel(EPK epk){
        this.setPreferredSize(new Dimension(1280,800));
        this.epk = epk.getEpkList();
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        for(int i = 0; i < epk.size(); i++)
        {
            if(i == 0)
            {
                setHeight(100*(countLines(((Event) epk.get(i)).getEventText())));
                System.out.println("height: " + getHeight());
                setWidth(10*(((Event) epk.get(i)).getEventText().length()));
                System.out.println("width: " + getWidth());
                setEventXY();
                System.out.println("xPoints: " + Arrays.toString(xPoints) + " , ypoints " + Arrays.toString(yPoints));
                g2D.drawPolygon(xPoints, yPoints, 6);
                g2D.drawString(((Event) epk.get(i)).getEventText(), (getWidth()/3 - ((Event) epk.get(i)).getEventText().length()),getHeight()/2);
            }
            drawLine(g2D);

//            if(epk.get(i) instanceof Event)
//            {
//                setHeight(5*(countLines(((Event) epk.get(i)).getEventText())));
//                setWidth(5*(((Event) epk.get(i)).getEventText().length()));
//            }
        }
//        g2D.draw3DRect(20, 0, 200, 100, true);
//        g2D.drawString("Function", 175,25);
//        g2D.drawLine(50,50,50,200);
//        g2D.drawRoundRect(150,0,100,50,15,15);
//
//        g2D.drawArc(50,250,50,50,0,350);
    }

    private int height = 25;
    private int width = 25;
    private int[] xPoints;
    private int[] yPoints;
    private List<Object> epk;

    public void drawLine(Graphics2D g2D)
    {
        g2D.drawLine(getWidth()/2,getHeight(),getWidth()/2,getHeight()+25);
    }

    public void setEventXY()
    {
        xPoints = new int[6];
        yPoints = new int[6];
        xPoints[0] = xPoints[2] = 15;
        xPoints[1] = 0; xPoints[4] = getWidth();
        xPoints[3] = xPoints[5] = getWidth() - 15;
        yPoints[0] = yPoints[5] = 0;
        yPoints[1] = yPoints[4] = (getHeight()/2);
        yPoints[2] = yPoints[3] = getHeight();
        yPoints.forEach


        setxPoints(xPoints);
        setyPoints(yPoints);
    }

    public static int countLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return  lines.length;
    }

    public int[] getxPoints() {
        return xPoints;
    }

    public void setxPoints(int[] xPoints) {
        this.xPoints = xPoints;
    }

    public int[] getyPoints() {
        return yPoints;
    }

    public void setyPoints(int[] yPoints) {
        this.yPoints = yPoints;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
