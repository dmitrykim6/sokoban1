import javax.swing.*;

public class Viewer {
    Canvas canvas;
    Viewer(){
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        JFrame frame = new JFrame("Sokoban");
        frame.setSize(590, 610);
        frame.setLocation(200,0 );
        frame.add("Center", canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

    public void update(){
        canvas.repaint();
    }

}
