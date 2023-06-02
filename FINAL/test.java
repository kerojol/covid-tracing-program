import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String filename = "testt.txt";
        String line = "";

        System.out.println("+------------------------------------------------------------+");
        System.out.println("|                           MASTER                           |");
        System.out.println("|                           VISIT                            |");
        System.out.println("|                           HISTORY                          |");
        System.out.println("+------------------------------------------------------------+");
        System.out.println();
        System.out.println("No"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"      Customer"+"\t\t"+"Shop"+"\t");

        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));

            int num = 1;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                Arrays.sort(values);
                System.out.println(num+"\t"+values[0]+"\t"+values[1]+"\t\t"+values[2]+"\t\t"+values[3]);
                num = num+1;
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();           
        }
    }
}
