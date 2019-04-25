import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller implements KeyListener {
    private Model model;

    Controller(Viewer viewer){
        model = new Model(viewer);
    }

    public Model getModel(){
        return model;
    }

    public void keyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        System.out.println(keyCode);
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
