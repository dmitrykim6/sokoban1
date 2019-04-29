import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Viewer {
    Canvas canvas;
    JFrame frame;
    Controller controller;
    JLabel winMsg;
    JFrame winFrame;
    JFrame selSkins;

    Viewer(){

        controller = new Controller(this);
        Model model = controller.getModel();

        selSkins = new JFrame("Select Skin");
        selSkins.setSize(300, 150);
        selSkins.setLocationRelativeTo(null);
        selSkins.setLayout(null);
        selSkins.setResizable(false);
        selSkins.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton skinOneButton = new JButton("Skin One");
        skinOneButton.setSize(60, 40);
        skinOneButton.setBounds(20, 50, 110, 50);
        skinOneButton.addActionListener(controller);
        skinOneButton.setActionCommand("SkinOne");

        JButton skinTwoButton = new JButton("Skin Two");
        skinTwoButton.setSize(60, 40);
        skinTwoButton.setBounds(160, 50, 110, 50);
        skinTwoButton.addActionListener(controller);
        skinTwoButton.setActionCommand("SkinTwo");

        selSkins.add(skinOneButton);
        selSkins.add(skinTwoButton);
        selSkins.setVisible(true);

        canvas = new Canvas(model);

        frame = new JFrame("Sokoban");
        frame.setIconImage(canvas.imageHeroDown);
        frame.setSize(750, 750);
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

        JMenuItem createMenuItemUndo = new JMenuItem("Undo", null);
        createMenuItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        createMenuItemUndo.addActionListener(controller);
        createMenuItemUndo.setActionCommand("Undo");

        JMenuItem createMenuItemExit = new JMenuItem("Exit", null);
        createMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        createMenuItemExit.addActionListener(controller);
        createMenuItemExit.setActionCommand("Exit");

        JMenu menuLevel = new JMenu("Level");

        JMenuItem levelOne = new JMenuItem("Level 1", null);
        levelOne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
        levelOne.addActionListener(controller);
        levelOne.setActionCommand("levelOne");

        JMenuItem levelTwo = new JMenuItem("Level 2", null);
        levelTwo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
        levelTwo.addActionListener(controller);
        levelTwo.setActionCommand("levelTwo");

        JMenuItem levelThree = new JMenuItem("Level 3", null);
        levelThree.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
        levelThree.addActionListener(controller);
        levelThree.setActionCommand("levelThree");

        JMenuItem fromFile = new JMenuItem("Load from file", null);
        fromFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
        fromFile.addActionListener(controller);
        fromFile.setActionCommand("levelFromFile");

        JMenuItem fromDB = new JMenuItem("Load from DB", null);
        fromDB.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
        fromDB.addActionListener(controller);
        fromDB.setActionCommand("levelFromDB");

        jMenuBar.add(menuFile);
        jMenuBar.add(menuLevel);


        menuFile.add(createMenuItemNew);
        menuFile.add(createMenuItemUndo);
        menuFile.add(createMenuItemExit);

        menuLevel.add(levelOne);
        menuLevel.add(levelTwo);
        menuLevel.add(levelThree);
        menuLevel.add(fromFile);
        menuLevel.add(fromDB);

        frame.setJMenuBar(jMenuBar);
        frame.setVisible(false);
        frame.addKeyListener(controller);

        winFrame = new JFrame("You Win!");
        winFrame.setSize(300, 150);
        winFrame.setLocationRelativeTo(null);
        winFrame.setLayout(null);

        winMsg = new JLabel("You Win!");
        winMsg.setBounds(115, 0, 100, 40);
        winMsg.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton winOkButton = new JButton("Next level");
        winOkButton.setSize(60, 40);
        winOkButton.setBounds(20, 50, 110, 50);
        winOkButton.addActionListener(controller);
        winOkButton.setActionCommand("Next");

        JButton exitButton = new JButton("Quit");
        exitButton.setSize(60, 40);
        exitButton.setBounds(160, 50, 110, 50);
        exitButton.addActionListener(controller);
        exitButton.setActionCommand("Exit");

        winFrame.add(winMsg);
        winFrame.add(winOkButton);
        winFrame.add(exitButton);
        winFrame.setVisible(false);
        winFrame.setResizable(false);
        winFrame.setIconImage(canvas.imageWin);
    }

    public void update(){
        canvas.repaint();
    }
}
