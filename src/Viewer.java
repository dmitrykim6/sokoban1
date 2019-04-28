import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Viewer {
    Canvas canvas;
    JFrame frame;
    Controller controller;
    JLabel winMsg;
    JFrame winFrame;

    Viewer(){
        controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        frame = new JFrame("Sokoban");
        frame.setIconImage(canvas.imageHeroDown);
        frame.setSize(900, 720);
        frame.setLocation(200,0 );
        frame.add("Center", canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);


        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        JMenuItem createMenuItemNew = new JMenuItem("New", null);
        createMenuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        createMenuItemNew.addActionListener(controller);
        createMenuItemNew.setActionCommand("New");

        JMenuItem createMenuItemExit = new JMenuItem("Exit", null);
        createMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        createMenuItemExit.addActionListener(controller);
        createMenuItemExit.setActionCommand("Exit");

        jMenuBar.add(menuFile);
        menuFile.add(createMenuItemNew);
        menuFile.add(createMenuItemExit);
        frame.setJMenuBar(jMenuBar);
        frame.setVisible(true);
        frame.addKeyListener(controller);


        winFrame = new JFrame("You Win!");
        winFrame.setSize(300, 150);
        winFrame.setLocationRelativeTo(null);
        winFrame.setLayout(null);

        winMsg = new JLabel("You Win!");
        winMsg.setBounds(115, 0, 100, 40);
        winMsg.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton winOkButton = new JButton("New game");
        winOkButton.setSize(60, 40);
        winOkButton.setBounds(70, 50, 150, 50);
        winOkButton.addActionListener(controller);
        winOkButton.setActionCommand("New");

        winFrame.add(winMsg);
        winFrame.add(winOkButton);
        winFrame.setVisible(false);
        winFrame.setResizable(false);

        winFrame.setIconImage(canvas.imageWin);



    }


    public void update(){
        canvas.repaint();
    }

}
