import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;


public class Controller implements KeyListener, ActionListener {
    private Model model;
    private Sound soundSystem;
    int level;
    Controller(Viewer viewer){
        model = new Model(viewer);
    }

    public Model getModel(){
        return model;
    }

    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        if(command.equals("New")) {
            model.close();
            Viewer viewer = new Viewer();
        }
//        else if(command.equals("Undo")) {
//            model.Undo();
//            model.Modelupdate();
//        }
        else if(command.equals("Exit")) {
            model.close();
        }
        else if(command.equals("levelOne")) {
            model.selectLevel(1);
            model.Modelupdate();
        }
        else if(command.equals("levelTwo")) {
            model.selectLevel(2);
            model.Modelupdate();
        }
        else if(command.equals("levelThree")) {
            model.selectLevel(3);
            model.Modelupdate();
        }
        else if(command.equals("levelFromFile")) {
            model.Modelupdate();
        }
        else if(command.equals("levelFromDB")) {
            model.Modelupdate();
        }
        else if(command.equals("Next")) {
            model.close(1);
            if(model.getLevel() < 3){
                model.selectLevel(model.getLevel() + 1);
            }else model.selectLevel(model.getLevel());

            model.Modelupdate();
        }
        else if(command.equals("SkinOne")) {
            model.setSkin(1);

        }
        else if(command.equals("SkinTwo")) {
            model.setSkin(2);
        }

        // sound system control
        else if(command.equals("Mute")) {
            model.playMusic(0);
        }
        else if(command.equals("PlayClipOne")) {
            model.playMusic(1);
        }
        else if(command.equals("PlayClipTwo")) {
            model.playMusic(2);
        }
    }

    public void keyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        String direction = "";

        switch (keyCode){
            case 37:
                direction = "left";
                break;
            case 38:
                direction = "up";
                break;
            case 39:
                direction = "right";
                break;
            case 40:
                direction = "down";
                break;

        }
        model.move(direction);
    }

    public  void keyReleased(KeyEvent event){

    }

    public void keyTyped(KeyEvent event){

    }
}
