import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class ImportMap {
    int[][] desktop;
    JFileChooser fileChooser = new JFileChooser();
    File file;


    ImportMap(){
/*      0 - Empty
        1 - Hero
        2 - Wall
        3 - Box
        4 - GoalsZone
        6 - Box on GoalsZone
*/
    }
    int[][] selLevel(int level){
        if (level == 1) {

            desktop = new int[][]{
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
                    {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
                    {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 1, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };
        } else if (level == 2) {
            desktop = new int[][]{
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 4, 3, 0, 3, 4, 0, 0, 2},
                    {2, 0, 4, 3, 0, 3, 4, 0, 0, 2},
                    {2, 0, 4, 3, 1, 3, 4, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };
        } else if (level == 3) {
            desktop = new int[][]{
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                    {2, 2, 0, 0, 0, 0, 0, 1, 2, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 4, 0, 3, 0, 3, 0, 6, 4, 2},
                    {2, 4, 0, 3, 0, 3, 0, 6, 4, 2},
                    {2, 4, 0, 3, 0, 3, 0, 6, 4, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                    {2, 2, 0, 0, 0, 0, 0, 0, 2, 2},
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };
        }else if (level == 4) {

            desktop = openFile();
        }
        return desktop;
    }

    public int[][] openFile(){

        String text = "";
        String[]desktopStringY;
        String[]desktopStringX;

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Sokoban files only", "sok");
        fileChooser.setFileFilter(filter);
        int ret = fileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {

            file = fileChooser.getSelectedFile();
            FileReader inF;

            try{
                int words;
                inF = new FileReader(file);

                while ((words = inF.read()) != -1){
                    text = text + (char)words;
                }

                desktopStringX = text.split("\n");

                for (int i = 0; i < desktopStringX.length; i++){

                }

                for(int a = 0; a < 10; a++){
                    for(int b = 0; b< 10; b++){
                        System.out.print(desktop[a][b]);
                    }
                    System.out.println();
                }
                System.out.println();


//                System.out.println(desktop.length);
//                System.out.println(desktop[0].length);
            }catch(IOException e){
                System.out.println("Error");
            }
        }
        return desktop;
    }

}



