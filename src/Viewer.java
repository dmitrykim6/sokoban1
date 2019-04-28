import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Viewer {
    Canvas canvas;
//    Canvas secondCanvas;

    Viewer(){
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

//        secondCanvas = new Canvas(model);

        JFrame frame = new JFrame("Sokoban");
        frame.setSize(900, 720);
        frame.setLocation(200,0 );
        frame.add("Center", canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        JMenuItem createMenuItem = new JMenuItem("New", null);
        createMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        createMenuItem.addActionListener(controller);
        createMenuItem.setActionCommand("New");

        jMenuBar.add(menuFile);
        menuFile.add(createMenuItem);
        frame.setJMenuBar(jMenuBar);
        frame.setVisible(true);
        frame.addKeyListener(controller);

    }

    public void update(){
        canvas.repaint();
    }

}
