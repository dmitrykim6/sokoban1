public class Model {
    private Viewer viewer;
    private Sound sound;
    private int indexX;
    private int indexY;
    private int level = 1;
    int heroMove = 3;
    int[][] desktop;
    int[][] copyDesktop;
    int prevPosition;
    int levelLoaded = 1;
    private int heroStartPositionX;
    private int heroStartPositionY;
    boolean isMute = true;

    ImportMap importMap = new ImportMap();

    Model(Viewer viewer) {
        sound = new Sound();
        this.viewer = viewer;
        selectLevel(level);
    }


    void selectLevel(int level){
        desktop = importMap.selLevel(level);
        levelLoaded = level;

//      Hero start position
        wereMyHero();

        indexX = heroStartPositionX;
        indexY = heroStartPositionY;
    }

    int getLevel(){
        return levelLoaded;
    }

    void move(String direction) {
        if (direction.equals("left")) {
            moveLeft();
        } else if (direction.equals("up")) {
            moveUp();
        } else if (direction.equals("right")) {
            moveRight();
        } else if (direction.equals("down")) {
            moveDown();
        }
        viewer.update();
    }

    private void moveLeft() {
//stay on ground
        if(desktop[indexX][indexY] == 1){
            if (desktop[indexX][indexY-1] == 0){
                prevPosition = 0;
                desktop[indexX][indexY] = 0;
                indexY = indexY-1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY-1] == 4){
                desktop[indexX][indexY] = 0;
                indexY = indexY-1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY-1] == 3){
                if(desktop[indexX][indexY-2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 6;
                }
            }
            else if (desktop[indexX][indexY-1] == 6){
                if(desktop[indexX][indexY-2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 6;
                }
            }
        }
// stay on Goal Zone
        else if(desktop[indexX][indexY] == 5){
            if (desktop[indexX][indexY-1] == 0){
                desktop[indexX][indexY] = 4;
                indexY = indexY-1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY-1] == 4){
                desktop[indexX][indexY] = 4;
                indexY = indexY-1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY-1] == 3){
                if(desktop[indexX][indexY-2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 6;
                }
            }
            else if (desktop[indexX][indexY-1] == 6){
                if(desktop[indexX][indexY-2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 6;
                }
            }
        }

        heroMove = 1;

    }

    private void moveUp() {
        if(desktop[indexX][indexY] == 1){
            if (desktop[indexX-1][indexY] == 0){
                desktop[indexX][indexY] = 0;
                indexX = indexX-1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX-1][indexY] == 4){
                desktop[indexX][indexY] = 0;
                indexX = indexX-1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX-1][indexY] == 3){
                if(desktop[indexX-2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX-1][indexY] = 6;
                }
            }
            else if (desktop[indexX-1][indexY] == 6){
                if(desktop[indexX-2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 6;
                }
            }
        }
        else if(desktop[indexX][indexY] == 5){
            if (desktop[indexX-1][indexY] == 0){
                desktop[indexX][indexY] = 4;
                indexX = indexX-1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX-1][indexY] == 4){
                desktop[indexX][indexY] = 4;
                indexX = indexX-1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX-1][indexY] == 3){
                if(desktop[indexX-2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 6;
                }
            }
            else if (desktop[indexX-1][indexY] == 6){
                if(desktop[indexX-2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 6;
                }
            }
        }

        heroMove = 2;
    }

    private void moveRight() {
        if(desktop[indexX][indexY] == 1){
            if (desktop[indexX][indexY+1] == 0){
                desktop[indexX][indexY] = 0;
                indexY = indexY+1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY+1] == 4){
                desktop[indexX][indexY] = 0;
                indexY = indexY+1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY+1] == 3){
                if(desktop[indexX][indexY+2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY+1] = 6;
                }
            }
            else if (desktop[indexX][indexY+1] == 6){
                if(desktop[indexX][indexY+2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 6;
                }
            }
        }
        else if(desktop[indexX][indexY] == 5){
            if (desktop[indexX][indexY+1] == 0){
                playMusic(5);
                desktop[indexX][indexY] = 4;
                indexY = indexY+1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY+1] == 4){
                playMusic(4);
                desktop[indexX][indexY] = 4;
                indexY = indexY+1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY+1] == 3){
                if(desktop[indexX][indexY+2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 6;
                }
            }
            else if (desktop[indexX][indexY+1] == 6){
                if(desktop[indexX][indexY+2] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 6;
                }
            }
        }
        heroMove = 3;
    }

    private void moveDown() {
        if(desktop[indexX][indexY] == 1){
            if (desktop[indexX+1][indexY] == 0){
                desktop[indexX][indexY] = 0;
                indexX = indexX+1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX+1][indexY] == 4){
                desktop[indexX][indexY] = 0;
                indexX = indexX+1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX+1][indexY] == 3){
                if(desktop[indexX+2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX+1][indexY] = 6;
                }
            }
            else if (desktop[indexX+1][indexY] == 6){
                if(desktop[indexX+2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 6;
                }
            }
        }
        else if(desktop[indexX][indexY] == 5){
            if (desktop[indexX+1][indexY] == 0){
                desktop[indexX][indexY] = 4;
                indexX = indexX+1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX+1][indexY] == 4){
                desktop[indexX][indexY] = 4;
                indexX = indexX+1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX+1][indexY] == 3){
                if(desktop[indexX+2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 6;
                }
            }
            else if (desktop[indexX+1][indexY] == 6){
                if(desktop[indexX+2][indexY] == 0) {
                    playMusic(5);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    playMusic(4);
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 6;
                }
            }
        }
        heroMove = 4;
    }

    // check when player is win
    void checkForWin(int freeGoalZone, int boxes){
//        System.out.println("Goals cell: "+  freeGoalZone);
//        System.out.println("Boxes: " + boxes);

        // check desktop for equals boxes and goal zones
        if (freeGoalZone != boxes){
            System.out.println("Check counts of boxes or Goals Zones!");
        }

        if (freeGoalZone == 0 && boxes == 0){
            playMusic(3);
            System.out.println("YOU WIN!");
            viewer.winFrame.setVisible(true);
        }
    }

    // repaint canvas
    void Modelupdate(){
        viewer.update();
    }
    // Close game frames
    void close(){
        viewer.selSkins.dispose();
        viewer.winFrame.dispose();
        viewer.frame.dispose();
    }

    // Close only frame "You Win"
    void close(int warning){
        viewer.winFrame.dispose();
    }

    // define were is my hero
    private void wereMyHero(){
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 1){
                    heroStartPositionX = i;
                    heroStartPositionY = j;
                };
            }
        }
    }

    // select skin
    void setSkin(int noSkin){
        viewer.selSkins.setVisible(false);
        if(noSkin == 1){
            viewer.canvas.setSkin = 1;
        }
        else{
            viewer.canvas.setSkin = 2;
        }
        viewer.frame.setVisible(true);
    }

    // select music
    void playMusic(int selectedClip){

        if (selectedClip == 0) {
            sound.stopPlay();
        }
        else if (selectedClip == 1) {
            sound.stopPlay();
            sound.playSound("src/sound/clip_mario.wav", 1);
        }
        else if (selectedClip == 2) {
            sound.stopPlay();
            sound.playSound("src/sound/clip_kalambur.wav", 1);
        }
        else if (selectedClip == 3){
            if(!isMute) {
                sound.playSound("src/sound/clip_wow.wav", 0);
            }
        }
        else if (selectedClip == 4){
            if(!isMute) {
                sound.playSound("src/sound/clip_coin.wav", 0);
            }
        }
        else if (selectedClip == 5){
            if(!isMute) {
                sound.playSound("src/sound/clip_kick.wav", 0);
            }
        }

    }

}
