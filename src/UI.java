import java.awt.*;
import javax.swing.*;

public class UI extends JFrame{
    UI(){
        panel = new uiPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    uiPanel panel;




}
