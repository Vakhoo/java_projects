import java.io.*;
import java.util.Scanner;

public class FIleUtil {
    public static void createFile() throws IOException {
        File file = new File("vakho.txt");
        if (!file.exists()){
            if (file.createNewFile()){
                System.out.println("FIle created");
            }else {
                System.out.println("not created");
            }
        }
    }

    public static void writeIntoFile(String txt) throws IOException{
        File file = new File("vakho.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write((txt));
        fileWriter.close();
    }

    public static void readFile() throws IOException{
        File file = new File("vakho.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            System.out.println(data);
        }
        scanner.close();
    }

    public static void deletaFile() throws  IOException{
        File file = new File("vakho.txt");
        if(file.exists()){
            if(file.delete()){
                System.out.println("file delete");
            }else {
                System.out.println("no file");
            }
        }
    }
}
