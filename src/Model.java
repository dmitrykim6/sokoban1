public class Model {
    private Viewer viewer;
    int [][]desktop;
    int indexX;
    int indexY;
    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        if(indexY > 0){
            desktop[indexX][indexY] = 0;
            indexY = indexY -1;
            desktop[indexX][indexY] = 1;
            System.out.println(desktop.length);
        }

    }
    private void moveUp(){
        if(indexX > 0) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }
    private void moveRight(){
        if(indexY < desktop[0].length-1) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }
    private void moveDown(){
        if(indexX < desktop.length-1) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
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
