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
    private Image imageHeroLeftGoal;
    private Image imageHeroUpGoal;
    private Image imageHeroRightGoal;
    private Image imageHeroDownGoal;
    private Image imageWall;
    private Image imageBox;
    private Image imageBoxGoal;
    private Image imageGround;
    private Image imageGroundFinish;


    Canvas(Model model){
        this.model = model;
        setBackground(Color.gray);
        setOpaque(true);

        File fileNameHeroLeftGoal = new File("src/img/skin1/hero_left_goal.png");
        File fileNameHeroUpGoal = new File("src/img/skin1/hero_up_goal.png");
        File fileNameHeroRightGoal = new File("src/img/skin1/hero_right_goal.png");
        File fileNameHeroDownGoal = new File("src/img/skin1/hero_down_goal.png");
        File fileNameHeroLeft = new File("src/img/skin1/hero_left.png");
        File fileNameHeroUp = new File("src/img/skin1/hero_up.png");
        File fileNameHeroRight = new File("src/img/skin1/hero_right.png");
        File fileNameHeroDown = new File("src/img/skin1/hero_down.png");
        File fileNameWall = new File("src/img/skin1/wall.png");
        File fileNameBoxGoal = new File("src/img/skin1/box_goal.png");
        File fileNameBox = new File("src/img/skin1/box.png");
        File fileNameGround = new File("src/img/skin1/ground.png");
        File fileNameGroundFinish = new File("src/img/skin1/ground_goal.png");

        try{
            imageHeroLeftGoal = ImageIO.read(fileNameHeroLeftGoal);
            imageHeroUpGoal = ImageIO.read(fileNameHeroUpGoal);
            imageHeroRightGoal = ImageIO.read(fileNameHeroRightGoal);
            imageHeroDownGoal = ImageIO.read(fileNameHeroDownGoal);
            imageHeroLeft = ImageIO.read(fileNameHeroLeft);
            imageHeroUp = ImageIO.read(fileNameHeroUp);
            imageHeroRight = ImageIO.read(fileNameHeroRight);
            imageHeroDown = ImageIO.read(fileNameHeroDown);
            imageWall = ImageIO.read(fileNameWall);
            imageBox = ImageIO.read(fileNameBox);
            imageBoxGoal = ImageIO.read(fileNameBoxGoal);
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
                }else if (model.desktop[i][j] == 5){
                    if (model.heroMove == 1){
                        pen.drawImage(imageHeroLeftGoal, x, y, null);
                    }else if (model.heroMove == 2){
                        pen.drawImage(imageHeroUpGoal, x, y, null);
                    }else if (model.heroMove == 3){
                        pen.drawImage(imageHeroRightGoal, x, y, null);
                    }else if (model.heroMove == 4) {
                        pen.drawImage(imageHeroDownGoal, x, y, null);
                    }
                }else if(model.desktop[i][j] == 6){
                    pen.drawImage(imageBoxGoal, x, y, null);
                }

                x = x + height + offset;
            }

            x = start;
            y = y + width + offset;

        }
    }

}
