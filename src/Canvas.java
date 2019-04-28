import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Canvas extends JPanel {

    private Model model;
    private Image imageHeroLeft;
    private Image imageHeroUp;
    private Image imageHeroRight;
    private Image imageHeroDown;
    private Image imageWall;
    private Image imageBox;
    private Image imageGround;
    private Image imageGroundFinish;


    Canvas(Model model){
        this.model = model;
        setBackground(Color.gray);
        setOpaque(true);

        File fileNameHeroLeft = new File("img/skin1/hero_left.png");
        File fileNameHeroUp = new File("img/skin1/hero_up.png");
        File fileNameHeroRight = new File("img/skin1/hero_right.png");
        File fileNameHeroDown = new File("img/skin1/hero_down.png");
        File fileNameWall = new File("img/skin1/wall.png");
        File fileNameBox = new File("img/skin1/box.png");
        File fileNameGround = new File("img/skin1/ground.png");
        File fileNameGroundFinish = new File("img/skin1/ground_goal.png");

        try{
            imageHeroLeft = ImageIO.read(fileNameHeroLeft);
            imageHeroUp = ImageIO.read(fileNameHeroUp);
            imageHeroRight = ImageIO.read(fileNameHeroRight);
            imageHeroDown = ImageIO.read(fileNameHeroDown);
            imageWall = ImageIO.read(fileNameWall);
            imageBox = ImageIO.read(fileNameBox);
            imageGround = ImageIO.read(fileNameGround);
            imageGroundFinish = ImageIO.read(fileNameGroundFinish);
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public void paint(Graphics pen){
        super.paint(pen);
        int start = 25;
        int x = start;
        int y = start;
        int width = 64;
        int height = 64;
        int offset = 0 ;

        for (int i = 0; i < model.desktop.length; i++){
            for(int j = 0; j < model.desktop[i].length; j++){
                if (model.desktop[i][j] == 1){

                    if (model.heroMove == 1){
                        pen.drawImage(imageHeroLeft, x, y, null);
                    }else if (model.heroMove == 2){
                        pen.drawImage(imageHeroUp, x, y, null);
                    }else if (model.heroMove == 3){
                        pen.drawImage(imageHeroRight, x, y, null);
                    }else if (model.heroMove == 4) {
                        pen.drawImage(imageHeroDown, x, y, null);
                    }

                }else if(model.desktop[i][j] == 2){
                    pen.drawImage(imageWall, x, y, null);
                }else if(model.desktop[i][j] == 3){
                    pen.drawImage(imageBox, x, y, null);
                }else if(model.desktop[i][j] == 0){
                    pen.drawImage(imageGround, x, y, null);
                }else if(model.desktop[i][j] == 4){
                    pen.drawImage(imageGroundFinish, x, y, null);
                }

                x = x + height + offset;
            }

            x = start;
            y = y + width + offset;

        }
    }
}
