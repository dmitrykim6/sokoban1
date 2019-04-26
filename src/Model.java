public class Model {
    private Viewer viewer;
    int [][]desktop;
    int indexX;
    int indexY;
    int heroMove = 3;
    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 1, 0, 2, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 0, 2, 0, 0, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 4, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 3, 0, 2},
                {2, 0, 2, 0, 3, 4, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        indexX = 1;
        indexY = 2;


    }

    public void move(String direction){
        if(direction.equals("left")){
            moveLeft();
        }else if(direction.equals("up")){
            moveUp();
        }else if(direction.equals("right")){
            moveRight();
        }else if(direction.equals("down")){
            moveDown();
        }
        printDesktop();
        viewer.update();
    }

    private void moveLeft(){
        if(desktop[indexX][indexY - 1] == 3){
            if(desktop[indexX][indexY - 2] == 0) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }
        if(desktop[indexX][indexY - 1] == 0){
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }

        heroMove = 1;

    }
    private void moveUp(){
        if(desktop[indexX - 1][indexY] == 3){
            if(desktop[indexX - 2][indexY] == 0) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }
        if(desktop[indexX - 1][indexY] == 0){
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }

        heroMove = 2;
    }
    private void moveRight(){
        if(desktop[indexX][indexY + 1] == 3){
            if(desktop[indexX][indexY + 2] == 0) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }
        if(desktop[indexX][indexY + 1] == 0){
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
        heroMove = 3;
    }
    private void moveDown(){
        if(desktop[indexX + 1][indexY] == 3){
            if(desktop[indexX + 2][indexY] == 0) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }
        if(desktop[indexX + 1][indexY] == 0){
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
        heroMove = 4;
    }

    private void printDesktop(){
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
//                System.out.println(desktop[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();
//        System.out.println();
    }

}
