public class Model {
    private Viewer viewer;
    int[][] desktop;
    int indexX;
    int indexY;
    int heroMove = 3;


    Model(Viewer viewer) {
        this.viewer = viewer;

/*      0 - Empty
        1 - Hero
        2 - Wall
        3 - Box
        4 - GoalsZone
        6 - Box on GoalsZone



*/
        desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
                {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
                {2, 0, 0, 0, 1, 3, 4, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        indexX = 5;
        indexY = 4;


    }

    public void move(String direction) {

//        switch (direction){
//            case "left": moveLeft();
//            case "up": moveUp();
//            case "right": moveRight();
//            case "down": moveDown();
//
//        }


        if (direction.equals("left")) {
            moveLeft();
        } else if (direction.equals("up")) {
            moveUp();
        } else if (direction.equals("right")) {
            moveRight();
        } else if (direction.equals("down")) {
            moveDown();
        }

        printDesktop();
        viewer.update();
    }

    private void moveLeft() {

        if(desktop[indexX][indexY] == 1){
            if (desktop[indexX][indexY-1] == 0){
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
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 6;
                }
            }
            else if (desktop[indexX][indexY-1] == 6){
                if(desktop[indexX][indexY-2] == 0) {
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    desktop[indexX][indexY] = 0;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 6;
                }
            }
        }
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
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 1;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 6;
                }
            }
            else if (desktop[indexX][indexY-1] == 6){
                if(desktop[indexX][indexY-2] == 0) {
                    desktop[indexX][indexY] = 4;
                    indexY = indexY-1;
                    desktop[indexX][indexY] = 5;
                    desktop[indexX][indexY-1] = 3;
                }
                else if(desktop[indexX][indexY-2] == 4) {
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
        }
    }

    private void printDesktop(){
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
//                System.out.print(desktop[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();
//        System.out.println();
    }

}
