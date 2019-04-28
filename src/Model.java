public class Model {
    private Viewer viewer;
    int [][]desktop;
    int indexX;
    int indexY;
    int heroMove = 3;
    int oldPosition;
    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 3, 4, 0, 2},
                {2, 0, 0, 0, 0, 0, 3, 3, 0, 2},
                {2, 0, 0, 0, 1, 0, 4, 3, 0, 2},
                {2, 0, 0, 0, 0, 3, 4, 4, 0, 2},
                {2, 0, 0, 0, 0, 0, 3, 2, 0, 2},
                {2, 0, 0, 0, 0, 0, 4, 2, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        indexX = 5;
        indexY = 4;


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

        if(desktop[indexX][indexY - 1] == 3){               // Если слева коробка
            if(desktop[indexX][indexY - 2] == 0) {          // Если слева от коробки свободно
                desktop[indexX][indexY - 1] = 0;            //
                desktop[indexX][indexY - 2] = 3;            //
            }
        }
        if(desktop[indexX][indexY - 1] == 4){               // Если слева целевой участок
                desktop[indexX][indexY - 1] = 5;            //
                desktop[indexX][indexY] = 0;

        }


        if(desktop[indexX][indexY - 1] == 0){

            if(desktop[indexX][indexY] == 5){
                indexY = indexY - 1;
                desktop[indexX][indexY-1] = 4;
                desktop[indexX][indexY] = 1;                //
            }else {
                desktop[indexX][indexY] = 0;                    //
                indexY = indexY - 1;                            //
                desktop[indexX][indexY] = 1;                    //
            }
        }

        heroMove = 1;                                       // Направление персонажа - Смотрит влево

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

        //go to empty cell
        if(desktop[indexX][indexY + 1] == 0){
            desktop[indexX][indexY] = oldPosition;
            indexY = indexY + 1;
            oldPosition = desktop[indexX][indexY];
            desktop[indexX][indexY] = 1;
        }

        //go to cell with box
        else if(desktop[indexX][indexY + 1] == 3){
            if(desktop[indexX][indexY + 2] == 0){
                desktop[indexX][indexY] = oldPosition;
                indexY = indexY + 1;
                desktop[indexX][indexY] = 1;
                desktop[indexX][indexY + 1] = 3;
            }else if(desktop[indexX][indexY + 2] == 4){
                desktop[indexX][indexY] = oldPosition;
                indexY = indexY + 1;
                desktop[indexX][indexY] = 1;
                desktop[indexX][indexY + 1] = 6;
            }
        }

        //go to goal cell
        else if(desktop[indexX][indexY + 1] == 4){
            desktop[indexX][indexY] = oldPosition;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 5;
            oldPosition = 4;
        }

        //go to goal cell with box
        else if(desktop[indexX][indexY + 1] == 6){
            if(desktop[indexX][indexY + 2] == 0){
                desktop[indexX][indexY] = oldPosition;
                indexY = indexY + 1;
                desktop[indexX][indexY] = 3;
                oldPosition = 4;
            }else if(desktop[indexX][indexY + 2] == 4){
                desktop[indexX][indexY] = oldPosition;
                indexY = indexY + 1;
                desktop[indexX][indexY] = 5;
                desktop[indexX][indexY + 1] = 6;
                oldPosition = 4;
            }

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
//                System.out.print(desktop[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();
//        System.out.println();
    }

}
