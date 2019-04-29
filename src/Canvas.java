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
    private Image imageHeroLeftGoal;
    private Image imageHeroUpGoal;
    private Image imageHeroRightGoal;
    private Image imageHeroDownGoal;
    private Image imageWall;
    private Image imageBox;
    private Image imageBoxGoal;
    private Image imageGround;
    private Image imageGroundFinish;
    Image imageWin;
    Image imageHeroDown;

    private Model model2;
    private Image imageHeroLeft2;
    private Image imageHeroUp2;
    private Image imageHeroRight2;
    private Image imageHeroLeftGoal2;
    private Image imageHeroUpGoal2;
    private Image imageHeroRightGoal2;
    private Image imageHeroDownGoal2;
    private Image imageWall2;
    private Image imageBox2;
    private Image imageBoxGoal2;
    private Image imageGround2;
    private Image imageGroundFinish2;
    Image imageWin2;
    Image imageHeroDown2;
    int setSkin = 1;

    Canvas(Model model){

        this.model = model;
        setBackground(Color.gray);
        setOpaque(true);
        //skin1
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
        File fileNameWin = new File("src/img/skin1/win.png");

        //skin1
        File fileNameHeroLeftGoal2 = new File("src/img/skin2/hero_left_goal.png");
        File fileNameHeroUpGoal2 = new File("src/img/skin2/hero_up_goal.png");
        File fileNameHeroRightGoal2 = new File("src/img/skin2/hero_right_goal.png");
        File fileNameHeroDownGoal2 = new File("src/img/skin2/hero_down_goal.png");
        File fileNameHeroLeft2 = new File("src/img/skin2/hero_left.png");
        File fileNameHeroUp2 = new File("src/img/skin2/hero_up.png");
        File fileNameHeroRight2 = new File("src/img/skin2/hero_right.png");
        File fileNameHeroDown2 = new File("src/img/skin2/hero_down.png");
        File fileNameWall2 = new File("src/img/skin2/wall.png");
        File fileNameBoxGoal2 = new File("src/img/skin2/box_goal.png");
        File fileNameBox2 = new File("src/img/skin2/box.png");
        File fileNameGround2 = new File("src/img/skin2/ground.png");
        File fileNameGroundFinish2 = new File("src/img/skin2/ground_goal.png");
        File fileNameWin2 = new File("src/img/skin2/win.png");

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
            imageWin = ImageIO.read(fileNameWin);

            imageHeroLeftGoal2 = ImageIO.read(fileNameHeroLeftGoal2);
            imageHeroUpGoal2 = ImageIO.read(fileNameHeroUpGoal2);
            imageHeroRightGoal2 = ImageIO.read(fileNameHeroRightGoal2);
            imageHeroDownGoal2 = ImageIO.read(fileNameHeroDownGoal2);
            imageHeroLeft2 = ImageIO.read(fileNameHeroLeft2);
            imageHeroUp2 = ImageIO.read(fileNameHeroUp2);
            imageHeroRight2 = ImageIO.read(fileNameHeroRight2);
            imageHeroDown2 = ImageIO.read(fileNameHeroDown2);
            imageWall2 = ImageIO.read(fileNameWall2);
            imageBox2 = ImageIO.read(fileNameBox2);
            imageBoxGoal2 = ImageIO.read(fileNameBoxGoal2);
            imageGround2 = ImageIO.read(fileNameGround2);
            imageGroundFinish2 = ImageIO.read(fileNameGroundFinish2);
            imageWin2 = ImageIO.read(fileNameWin2);
        }catch (IOException e){
            System.out.println("Error: " + e);
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
        int boxes = 0;
        int freeGoalZone = 0;

        if(setSkin == 1) {
            for (int i = 0; i < model.desktop.length; i++) {
                for (int j = 0; j < model.desktop[i].length; j++) {
                    if (model.desktop[i][j] == 1) {
                        if (model.heroMove == 1) {
                            pen.drawImage(imageHeroLeft, x, y, null);
                        } else if (model.heroMove == 2) {
                            pen.drawImage(imageHeroUp, x, y, null);
                        } else if (model.heroMove == 3) {
                            pen.drawImage(imageHeroRight, x, y, null);
                        } else if (model.heroMove == 4) {
                            pen.drawImage(imageHeroDown, x, y, null);
                        }
                    } else if (model.desktop[i][j] == 2) {
                        pen.drawImage(imageWall, x, y, null);
                    } else if (model.desktop[i][j] == 3) {
                        pen.drawImage(imageBox, x, y, null);
                        boxes++;
                    } else if (model.desktop[i][j] == 0) {
                        pen.drawImage(imageGround, x, y, null);
                    } else if (model.desktop[i][j] == 4) {
                        pen.drawImage(imageGroundFinish, x, y, null);
                        freeGoalZone++;
                    } else if (model.desktop[i][j] == 5) {
                        freeGoalZone++;
                        if (model.heroMove == 1) {
                            pen.drawImage(imageHeroLeftGoal, x, y, null);
                        } else if (model.heroMove == 4) {
                            pen.drawImage(imageHeroDownGoal, x, y, null);
                        } else if (model.heroMove == 2) {
                            pen.drawImage(imageHeroUpGoal, x, y, null);
                        } else if (model.heroMove == 3) {
                            pen.drawImage(imageHeroRightGoal, x, y, null);
                        }
                    } else if (model.desktop[i][j] == 6) {
                        pen.drawImage(imageBoxGoal, x, y, null);
                    }
                    x = x + height + offset;
                }
                x = start;
                y = y + width + offset;
            }
        }else {
            for (int i = 0; i < model.desktop.length; i++) {
                for (int j = 0; j < model.desktop[i].length; j++) {
                    if (model.desktop[i][j] == 1) {
                        if (model.heroMove == 1) {
                            pen.drawImage(imageHeroLeft2, x, y, null);
                        } else if (model.heroMove == 2) {
                            pen.drawImage(imageHeroUp2, x, y, null);
                        } else if (model.heroMove == 3) {
                            pen.drawImage(imageHeroRight2, x, y, null);
                        } else if (model.heroMove == 4) {
                            pen.drawImage(imageHeroDown2, x, y, null);
                        }
                    } else if (model.desktop[i][j] == 2) {
                        pen.drawImage(imageWall2, x, y, null);
                    } else if (model.desktop[i][j] == 3) {
                        pen.drawImage(imageBox2, x, y, null);
                        boxes++;
                    } else if (model.desktop[i][j] == 0) {
                        pen.drawImage(imageGround2, x, y, null);
                    } else if (model.desktop[i][j] == 4) {
                        pen.drawImage(imageGroundFinish2, x, y, null);
                        freeGoalZone++;
                    } else if (model.desktop[i][j] == 5) {
                        freeGoalZone++;
                        if (model.heroMove == 1) {
                            pen.drawImage(imageHeroLeftGoal2, x, y, null);
                        } else if (model.heroMove == 4) {
                            pen.drawImage(imageHeroDownGoal2, x, y, null);
                        } else if (model.heroMove == 2) {
                            pen.drawImage(imageHeroUpGoal2, x, y, null);
                        } else if (model.heroMove == 3) {
                            pen.drawImage(imageHeroRightGoal2, x, y, null);
                        }
                    } else if (model.desktop[i][j] == 6) {
                        pen.drawImage(imageBoxGoal2, x, y, null);
                    }
                    x = x + height + offset;
                }
                x = start;
                y = y + width + offset;
            }
        }
            model.checkForWin(freeGoalZone, boxes);
    }


}
