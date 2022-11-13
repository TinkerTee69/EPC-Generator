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
            if(epk.get(i) instanceof Event)
            {
                setEpk_Height(100*(countLines(((Event) epk.get(i)).getEventText())));
                System.out.println("height: " + getEpk_Height());
                setEpk_Width(10*(((Event) epk.get(i)).getEventText().length()));
                System.out.println("width: " + getEpk_Width());
                setEventXY(i);
                System.out.println("xPoints: " + Arrays.toString(xPoints) + " , ypoints " + Arrays.toString(yPoints));

                g2D.drawPolygon(xPoints, yPoints, 6);
                g2D.drawString(((Event) epk.get(i)).getEventText(), (getEpk_Width()/3 - ((Event) epk.get(i)).getEventText().length()),getEpk_Height()/2 + i * (25 + getEpk_Height()));
                drawLine(g2D, i);
            }


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

    private int epk_height = 25;
    private int epk_width = 25;
    private int[] xPoints;
    private int[] yPoints;
    private List<Object> epk;

    public void drawLine(Graphics2D g2D, int i)
    {
        g2D.drawLine(getEpk_Width()/2,getEpk_Height() + i * getEpk_Height() + i * 25,getEpk_Width()/2,i * getEpk_Height() + getEpk_Height()+25 + i * 25);
    }

    public void setEventXY(int i)
    {
        xPoints = new int[6];
        yPoints = new int[6];
        xPoints[0] = xPoints[2] = 15;
        xPoints[1] = 0; xPoints[4] = getEpk_Width();
        xPoints[3] = xPoints[5] = getEpk_Width() - 15;
        yPoints[0] = yPoints[5] = i * getEpk_Height() + i * 25;
        yPoints[1] = yPoints[4] = i* getEpk_Height() + (getEpk_Height()/2) + i * 25;
        yPoints[2] = yPoints[3] = i * getEpk_Height() + getEpk_Height() + i * 25;

//        for(int i = 0; i < yPoints.length; i++)
//        {
//            yPoints[i] = yPoints[i] + 15;
//        }



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

    public int getEpk_Height() {
        return epk_height;
    }

    public void setEpk_Height(int epk_height) {
        this.epk_height = epk_height;
    }

    public int getEpk_Width() {
        return epk_width;
    }

    public void setEpk_Width(int epk_width) {
        this.epk_width = epk_width;
    }


}
