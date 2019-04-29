public class Model {
    private Viewer viewer;
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

    ImportMap importMap = new ImportMap();

    Model(Viewer viewer) {
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

    private void previousStep(){

    }

    private void moveLeft() {
//stay on ground
        if(desktop[indexX][indexY] == 1){
            if (desktop[indexX][indexY-1] == 0){
                copyMap();
                prevPosition = 0;
                desktop[indexX][indexY] = 0;
                indexY = indexY-1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY-1] == 4){
                copyMap();
                desktop[indexX][indexY] = 0;
                indexY = indexY-1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY-1] == 3){
                if(desktop[indexX][indexY-2] == 0) {
                    copyMap();
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    copyMap();
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 6;
                }
            }
            else if (desktop[indexX][indexY-1] == 6){
                if(desktop[indexX][indexY-2] == 0) {
                    copyMap();
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    copyMap();
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
                copyMap();
                desktop[indexX][indexY] = 4;
                indexY = indexY-1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY-1] == 4){
                copyMap();
                desktop[indexX][indexY] = 4;
                indexY = indexY-1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY-1] == 3){
                if(desktop[indexX][indexY-2] == 0) {
                    copyMap();
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    copyMap();
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 6;
                }
            }
            else if (desktop[indexX][indexY-1] == 6){
                if(desktop[indexX][indexY-2] == 0) {
                    copyMap();
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    copyMap();
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
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX-1][indexY] = 6;
                }
            }
            else if (desktop[indexX-1][indexY] == 6){
                if(desktop[indexX-2][indexY] == 0) {
                    desktop[indexX][indexY] = 0;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
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
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 6;
                }
            }
            else if (desktop[indexX-1][indexY] == 6){
                if(desktop[indexX-2][indexY] == 0) {
                    desktop[indexX][indexY] = 4;
                    indexX = indexX-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX-1][indexY] = 3;
                }
                else if(desktop[indexX-2][indexY] == 4) {
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
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY+1] = 6;
                }
            }
            else if (desktop[indexX][indexY+1] == 6){
                if(desktop[indexX][indexY+2] == 0) {
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    desktop[indexX][indexY] = 0;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 6;
                }
            }
        }
        else if(desktop[indexX][indexY] == 5){
            if (desktop[indexX][indexY+1] == 0){
                desktop[indexX][indexY] = 4;
                indexY = indexY+1;
                desktop[indexX][indexY] = 1;
            }
            else if (desktop[indexX][indexY+1] == 4){
                desktop[indexX][indexY] = 4;
                indexY = indexY+1;
                desktop[indexX][indexY] = 5;
            }
            else if (desktop[indexX][indexY+1] == 3){
                if(desktop[indexX][indexY+2] == 0) {
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 6;
                }
            }
            else if (desktop[indexX][indexY+1] == 6){
                if(desktop[indexX][indexY+2] == 0) {
                    desktop[indexX][indexY] = 4;
                    indexY = indexY+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY+1] = 3;
                }
                else if(desktop[indexX][indexY+2] == 4) {
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
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX+1][indexY] = 6;
                }
            }
            else if (desktop[indexX+1][indexY] == 6){
                if(desktop[indexX+2][indexY] == 0) {
                    desktop[indexX][indexY] = 0;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
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
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 6;
                }
            }
            else if (desktop[indexX+1][indexY] == 6){
                if(desktop[indexX+2][indexY] == 0) {
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 3;
                }
                else if(desktop[indexX+2][indexY] == 4) {
                    desktop[indexX][indexY] = 4;
                    indexX = indexX+1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX+1][indexY] = 6;
                }
            }
        }
        heroMove = 4;
    }

    void checkForWin(int freeGoalZone, int boxes){
        System.out.println("Goals cell: "+  freeGoalZone);
        System.out.println("Boxes: " + boxes);

        if (freeGoalZone != boxes){
            System.out.println("Check counts of boxes or Goals Zones!");
        }

        if (freeGoalZone == 0 && boxes == 0){
            System.out.println("YOU WIN!");
            viewer.winFrame.setVisible(true);
        }
    }

    void Modelupdate(){
        viewer.update();
    }

    void close(){
        viewer.selSkins.dispose();
        viewer.winFrame.dispose();
        viewer.frame.dispose();
    }

    void close(int warning){
        viewer.winFrame.dispose();
    }

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

    private void copyMap(){
        copyDesktop = new int [desktop.length][desktop[0].length];
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                copyDesktop[i][j] = desktop[i][j];
            }
        }
    }

    void Undo(){
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                desktop[i][j] = copyDesktop[i][j];
            }
        }
        System.out.println("UNDO");
        Modelupdate();
    }

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

}
