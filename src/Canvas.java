import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Canvas extends JPanel {
    private Model model;

    Canvas(Model model){
        this.model = model;
        setBackground(Color.lightGray);
        setOpaque(true);
    }

    public void paint(Graphics pen){
        super.paint(pen);

        int start = 25;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 5 ;

        for (int i = 0; i < model.desktop.length; i++){
            for(int j = 0; j < model.desktop[i].length; j++){
                if (model.desktop[i][j] == 1){
                    pen.setColor(Color.yellow);
                    pen.fillRect(x,y,width,height);

                }else{
                    pen.setColor(Color.white);
                    pen.fillRect(x,y,width,height);
                }

                x = x + height + offset;
            }

            x = start;
            y = y + width + offset;

        }
    }
}
