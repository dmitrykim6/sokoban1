
class ImportMap {
    int[][] desktop;
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
        }
        return desktop;
    }
}




/*
//import java.io.*;
//import java.util.Scanner;
//import javax.swing.*;
//import javax.swing.filechooser.FileNameExtensionFilter;


//    JFileChooser fileChooser = new JFileChooser();
//    File file;
        openFile();
    public int[][] openFile(){

        int text = 0;
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text files only", "txt");
        fileChooser.setFileFilter(filter);
        int ret = fileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            FileInputStream inF;
            try{

                inF = new FileInputStream(file);
                BufferedReader in = new BufferedReader(new InputStreamReader(inF, "UTF8"));
                int words;
//                while ((words = in.read()) != -1){
//                    text = text + (char)words;
//                }
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        desktop[i][j] = in.read();
                    }
                }

            }catch(IOException e){
                System.out.println("Error");
            }
        }
        return desktop;
    }
*/

