import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       Scanner in = new Scanner(System.in);
        System.out.printf("Введите имя файла: ");
        String fileName = in.nextLine();
        try{
            File fileOne = new File(fileName);
            fileOne.createNewFile();
            System.out.printf("Файл создан\n");
            System.out.printf("Полный путь к файлу: " + fileOne.getAbsolutePath() + "\n");
            System.out.printf("Введите колличество строк для записи в файл: ");
            int n = in.nextInt();
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(fileOne));
            in.nextLine();
            for(int i = 0; i < n; i++){
                System.out.printf("Введите строку: ");
                String s = in.nextLine();
                dOut.writeUTF(s + "\n");
            }
            dOut.flush();
            dOut.close();
            //Записал файл UTF8
            DataInputStream dIn = new DataInputStream(new FileInputStream(fileOne));
            while(true){
                System.out.printf(dIn.readUTF());
            }
        }catch(Exception e){
            System.out.printf("" + e);
        }
    }
}