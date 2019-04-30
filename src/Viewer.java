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

        // Frame select music and skins
        selSkins = new JFrame("Select Skin");
        selSkins.setSize(300, 150);
        selSkins.setLocationRelativeTo(null);
        selSkins.setLayout(null);
        selSkins.setResizable(false);
        selSkins.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Radio buttons - Select music
        ButtonGroup soundControl = new ButtonGroup();

        JRadioButton soundOff = new JRadioButton("Sound off", true);
        soundOff.setBounds(20, 0, 80, 50);
        soundOff.addActionListener(controller);
        soundOff.setActionCommand("Mute");

        JRadioButton soundOnClip1 = new JRadioButton("Mario", false);
        soundOnClip1.setBounds(120, 0, 80, 50);
        soundOnClip1.addActionListener(controller);
        soundOnClip1.setActionCommand("PlayClipOne");

        JRadioButton soundOnClip2 = new JRadioButton("Funy", false);
        soundOnClip2.setBounds(200, 0, 80, 50);
        soundOnClip2.addActionListener(controller);
        soundOnClip2.setActionCommand("PlayClipTwo");

        soundControl.add(soundOff);
        soundControl.add(soundOnClip1);
        soundControl.add(soundOnClip2);

        // Buttons - Select skin
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

        // soundControl
        selSkins.add(soundOff);
        selSkins.add(soundOnClip1);
        selSkins.add(soundOnClip2);
        //Skin buttons
        selSkins.add(skinOneButton);
        selSkins.add(skinTwoButton);
        selSkins.setVisible(true);

        canvas = new Canvas(model);

        // Game frame
        frame = new JFrame("Sokoban");
        frame.setIconImage(canvas.imageHeroDown);
        frame.setSize(750, 750);
        frame.setLocation(200,0 );
        frame.add("Center", canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Main menu
        JMenuBar jMenuBar = new JMenuBar();

        //Menu - File
        JMenu menuFile = new JMenu("File");

        JMenuItem createMenuItemNew = new JMenuItem("New", null);
        createMenuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        createMenuItemNew.addActionListener(controller);
        createMenuItemNew.setActionCommand("New");

        JMenuItem createMenuItemExit = new JMenuItem("Exit", null);
        createMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        createMenuItemExit.addActionListener(controller);
        createMenuItemExit.setActionCommand("Exit");

        // Menu - Level
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

        menuFile.add(createMenuItemNew);
        menuFile.add(createMenuItemExit);

        menuLevel.add(levelOne);
        menuLevel.add(levelTwo);
        menuLevel.add(levelThree);
        menuLevel.add(fromFile);
        menuLevel.add(fromDB);

        //Menu - Sound
        JMenu menuSound = new JMenu("Sound");

        JMenuItem marioSound = new JMenuItem("Mario theme", null);
        marioSound.addActionListener(controller);
        marioSound.setActionCommand("PlayClipOne");

        JMenuItem funySound = new JMenuItem("Funny theme", null);
        funySound.addActionListener(controller);
        funySound.setActionCommand("PlayClipTwo");

        JMenuItem muteSound = new JMenuItem("Sound off", null);
        muteSound.addActionListener(controller);
        muteSound.setActionCommand("Mute");

        menuSound.add(marioSound);
        menuSound.add(funySound);
        menuSound.add(muteSound);

        // Add menu items on frame
        jMenuBar.add(menuFile);
        jMenuBar.add(menuLevel);
        jMenuBar.add(menuSound);

        frame.setJMenuBar(jMenuBar);
        frame.setVisible(false);
        frame.addKeyListener(controller);

        // Frame - you win
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
