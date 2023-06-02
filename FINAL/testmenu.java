import java.util.Iterator;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.swing.JOptionPane;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.FileWriter;
import java.io.*; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
*Represents the whole system itself.
*/
public class testmenu {
    
    /** Asks the user to input their choice*/
    static int choice;

    /** Name of the user */
    static String tempname;

    public static void main(String[] args) {

        /**A menu for the system */
        testmenu menu = new testmenu();
        menu.main_menu();

    }

    /**This method is the main menu for the system. */
    public void main_menu() {

        /**This design is to execute and ask the user to type in the input  */
        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|             Hello, welcome to our COVID-19                    |");
            System.out.println("|             contact tracing program.                          |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("0. Exit program");

            Scanner input = new Scanner(System.in);

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    customer_menu();
                    break;
                case 2:
                    admin_menu();
                    break;
                case 0:
                    System.out.println("Thank you for choosing our application!");
                    break;
                default:
                    System.out.println("Unknown error has occured");
                    System.out.println();
                    System.out.println("Please input the right choice: ");
                    break;
            }
            input.close();
        } while (choice < 0 || choice > 2);

    }

    /**This method is for the customer to either register or log in to their account*/
    public void customer_menu() { 

        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                           Customer                            |");
            System.out.println("|                             menu                              |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. Register an account");
            System.out.println("2. Log in to an existing account");
            System.out.println("0. Back to main menu");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    customer_register();
                    break;
                case 2:
                    customer_login();
                    break;
                case 0:
                    main_menu();
                    break;
                default:
                    System.out.println("Please input the right choice number:");
                    break;
            }
            input.close();
        } while (choice < 0 || choice > 2);
    }

    /**This method is to mention the customer that their account has been created. */
    public void AccountCreated_menu() { 
        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                           Account                             |");
            System.out.println("|                           Created!                            |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. Proceed to login to account");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    customer_menu();
                    break;
                default:
                    System.out.println("Please input the right choice: ");
                    break;
            }
            input.close();
        } while (choice < 0 || choice > 1);
    }

    /**This method is to allow the admin to sign in the system */
    public void admin_menu() { 
        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                           Admin                               |");
            System.out.println("|                           menu                                |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. Login to an admin account");
            System.out.println("0. Exit to main menu");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    admin_login();
                    break;
                case 0:
                    main_menu();
                    break;
                default:
                    System.out.println("Please input the right choice: ");
                    break;
            }
            input.close();

        } while (choice < 0 || choice > 1);
    }

    /**
     * This method is for customer to check their status history and to check in a shop.
     */
    public void welcome_customer_menu() {
        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                           Welcome                             |");
            System.out.println("|                           Customer                            |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. Check in a shop");
            System.out.println("2. Check status");
            System.out.println("0. Logout and exit to the main menu");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkin_shop();
                    break;
                case 2:
                    cust_checkStatus();
                    break;
                case 0:
                    main_menu();
                    break;
            }
            input.close();            
        } while (choice < 0 || choice > 2);       
    }

    /**
     * This method is for admin to view data, flag customers and add 30 random visits.
     */
    public void welcome_admin_menu() {
        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                           Welcome                             |");
            System.out.println("|                           Admin                               |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. View data");
            System.out.println("2. Flag customer");
            System.out.println("3. Add 30 random visits");
            System.out.println("0. Logout and exit to the main menu");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    view_data_menu();
                    break;
                case 2:
                    System.out.println("Flag customer method");
                    break;
                case 3:
                    ask_30_rand();;
                    break;
                case 0:
                    main_menu();
                    break;
            }
            input.close();
        } while (choice < 0 || choice > 3);
    }

    /**
     * This method is for admin to view master visit history, shop and customer details.
     */
    public void view_data_menu() {
        do {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                         View                                  |");
            System.out.println("|                         Data                                  |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.println("Please input");
            System.out.println("1. Shop detail");
            System.out.println("2. Customer detail");
            System.out.println("3. Master visit history");
            System.out.println("0. Back");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    shopDetail();
                    break;
                case 2:
                    view_cust_detail();
                    break;
                case 3:
                    view_masterHist();
                    break;
                case 0:
                    main_menu();
                    break;
            }
            input.close();
        } while (choice < 0 || choice > 3);

    }

    /**
     * This method is for the customer to register their account.
     */
    public void customer_register() {

        String name = "";
        String password = "";
        String Cnumber = "";
        String filename = "Login.txt";
        /**represents the customer's username, password and phone number */

        Scanner inputname = new Scanner(System.in);
        Scanner inputpassword = new Scanner(System.in);
        Scanner inputCnum = new Scanner(System.in);

        System.out.print("Name: ");
        name = inputname.nextLine();
        System.out.println();
        System.out.print("password: ");
        password = inputpassword.nextLine();
        System.out.println();
        System.out.print("Tel. number: ");
        Cnumber = inputCnum.nextLine();
        System.out.println();

        String status = "Normal";

        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw); // give access to syntax

            pw.println(name + "," + password + "," + Cnumber + "," + status);
            pw.flush();
            pw.close();

            AccountCreated_menu();
            inputCnum.close();
            inputname.close();
            inputpassword.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong username or password");
        }

    }

    /**
     * This method is to accept the customer's input.
     */
    public void customer_login() {

        /**
         * Customer's password
         */
        String password;
        String filepath = "Login.txt";

        System.out.print("Username: ");
        Scanner inputusername = new Scanner(System.in);
        tempname = inputusername.nextLine();

        System.out.print("Password: ");
        Scanner inputpassword = new Scanner(System.in);
        password = inputpassword.nextLine();

        check_cust_login(tempname, password, filepath);
        inputpassword.close();
        inputusername.close();
    }

    private static Scanner x;

    /**
    * This method is for customer to login to the system from the given input. 
    */
    public void check_cust_login(String tempname, String password, String filepath) {

        boolean found = false;
        String tempUsername;
        String tempPassword;

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(tempname.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            x.close();
            System.out.println(found);
            if (found == false)
                System.out.println("Please try again");
        } catch (Exception e) {
            System.out.println("your username or password is incorrect");
        }
        if(found==true)
            welcome_customer_menu();
    }

    /**
    *This method is to admin's input.  
    */
    public void admin_login() {
        String username;
        String password;
        String filepath = "AdminInformation.txt";

        System.out.print("Username: ");
        Scanner inputusername = new Scanner(System.in);
        username = inputusername.nextLine();

        System.out.print("Password: ");
        Scanner inputpassword = new Scanner(System.in);
        password = inputpassword.nextLine();

        check_admin_login(username, password, filepath);

        inputpassword.close();
        inputusername.close();
    }

    private static Scanner y;

    /**
    * This method is for admin to login to the system from the given input.
    */
    public void check_admin_login(String username, String password, String filepath) {
        
        boolean found = false;

        String tempUsername;
        String tempPassword;

        try {
            y = new Scanner(new File(filepath));
            y.useDelimiter("[,\n]");

            while (y.hasNext() && !found) {
                tempUsername = y.next();
                tempPassword = y.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            y.close();
            System.out.println(found);
            if (found == false)
                System.out.println("Please try again");
        } catch (Exception e) {
            System.out.println("your username or password is incorrect");
        }
        if(found==true)
           welcome_admin_menu();
    }

    /**
    * This method is for admin to read shop details.
    */
    public void shopDetail() // read shop details from .txt file
    {
        String filename = "shopDetail.txt";
        String line = ""; // declare line to read whatever in the txt file

        System.out.println("+-------------------------+");
        System.out.println("|          Shop           |");
        System.out.println("|          Details        |");
        System.out.println("+-------------------------+");

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out
                        .println(values[0] + "\t" + values[1] + "\t" + values[2] + "\t" + values[3] + "\t" + values[4]);

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();

        do{      
            System.out.println("Please input");
            System.out.println();
            System.out.println("1.Back to view data menu");
            Scanner input = new Scanner(System.in);

        choice = input.nextInt();

            switch(choice){
                case 1: view_data_menu(); break;
                default:System.out.println("Please try again"); break;

            }
            input.close();
        }while(choice<1 || choice >1);
    }

    /**
    * This method is for admin to view master visit history.
    */
    public void view_masterHist(){
        String filename = "mastervisit.txt";
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
                System.out.println(num+"\t"+values[0]+"\t"+values[1]+"\t\t"+values[2]+"\t\t"+values[3]);
                num = num+1;
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();           
        } 
        
        do{
            System.out.println();
            System.out.println("Please input");
            System.out.println("0. Back");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch(choice){
                case 0:view_data_menu(); break;
                default: System.out.println("Please input the right number");
            }
            input.close();
        }while(choice<0 || choice>0);        
    } 

    /**
    * This method is for shops to check in the system.
    */
    public void checkin_shop() {

        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM-dd-YY,hh:mma");
      

        String shopname = "";
        String filename = "mastervisit.txt";

        Scanner input_shopname = new Scanner(System.in);

        System.out.print("Please enter shop name: ");
        shopname = input_shopname.nextLine();

        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String status = "Normal";
            pw.println(date.format(localDate) + "," + tempname + "," + shopname + ","
                    + status);
            pw.flush();
            pw.close();

            menu2();
                      
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
        input_shopname.close();

        
        
    }

    /**
     * This method is to display a message that lets the customer know that they have checkin in to the shop successfully.
     */
    public void menu2(){
        do{
            System.out.println();
            System.out.println("Checked in to shop Successfully. Have fun!");
            System.out.println("Please input");
            System.out.println("1. Go back to menu");
            System.out.println();

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch(choice)
            {
                case 1: welcome_customer_menu();
                default: System.out.println("Please try again");
            }
            input.close();
        }while(choice<1 || choice >1);
    }

    /**
     * This method is for customer to view their details.
     */
    public void view_cust_detail(){
        String filename = "Login.txt";
        String line = ""; //declare line to read whatever in the txt file

        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                System.out.println(values[0]+"\t"+values[2]+"\t"+values[3]);
                
            }br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        do{
            System.out.println("0. Back");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch(choice){
                case 0:view_data_menu(); break;
                default: System.out.println("Please input the right number");
            }
            input.close();
        }while(choice<0 || choice>0);
    }   
    
    /**
     * This method asks the admin whether they to add 30 random visits to the master visit history
     */
    public void ask_30_rand(){
        do{
            System.out.println("Add 30 random visit to master visit history?");
            System.out.println("Please input: ");
            System.out.println("1.Yes");
            System.out.println("0.Go back");
            
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch(choice){
                case 1: add_30_rand(); break;
                case 0: welcome_admin_menu(); break;
                default: System.out.println("Please input the right choice"); break;
            }
            input.close();
        }while(choice <1 || choice > 1);
    }
    
    /**This method adds 30 random visits to the master visit history.  */
    public void add_30_rand(){

        
        String[] names = {"Kamal","Taylor","David","James","Abdul"};
        String[] shops = {"Mydin","CZone","Speedmart","Tamarind"};

        String filename = "mastervisit.txt";

        Random rand = new Random();

        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-YY,hh:mma");
    

        int count = 0;
        int k = 123456789;

        while(count != 30){
            for(int i = 0; i < names.length; i++){
                int randomIndex = rand.nextInt(names.length);
                String temp = names[randomIndex];
                names[randomIndex] = names[i];
                names[i] = temp;
            }

            int randomnum = rand.nextInt(k);
            LocalDateTime d2 = localDate.minus(Duration.ofMillis(randomnum));
            
            
            for(int i=0;i<shops.length;i++){
                int randomIndex2 = rand.nextInt(shops.length);
                String temp1 = shops[randomIndex2];
                shops[i] = temp1;
            }
            
            try{
                FileWriter fw = new FileWriter(filename,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                String status = "Normal";
                pw.println(date.format(d2)+","+names[1]+","+shops[1]+","+status);
                pw.flush();
                pw.close();
            }catch(Exception e)
            {
                System.out.println("Something wrong..");
            }
            count++;
        }

        System.out.println();
        System.out.println();
        System.out.println("30 random visits added to master visit history");
        
        do{
            System.out.println();
            System.out.println("Please input: ");
            System.out.println("1. Go to master visit history");
            System.out.println("0. Back to admin menu");
            
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch(choice){
                case 1: view_masterHist(); break;
                case 0: welcome_admin_menu(); break;
                default: System.out.println("Please input the right choice"); break;
            }
            input.close();
        }while(choice <1 || choice > 1);
    }

    /** This method is for customer to check on their status.  */
    public void cust_checkStatus(){

        int MAXROWS = 1000;
        String filename = "mastervisit.txt";
        String line = "";
        String[] arrayData = new String[MAXROWS];
        String[] arrayDate  = new String[MAXROWS];
        String[] arrayName = new String[MAXROWS];
        String[] arrayShop = new String[MAXROWS];
        String[] arrayStatus = new String[MAXROWS];

        
        int num = 0;

        System.out.println("+--------------------------+");
        System.out.println("|          CHECK           |");
        System.out.println("|          CUSTOMER        |");
        System.out.println("|          STATUS          |");
        System.out.println("+--------------------------+");

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                arrayData = line.split(",");
                arrayDate[num] = arrayData[0];
                arrayName[num] = arrayData[2];
                arrayShop[num] = arrayData[3];
                arrayStatus[num] = arrayData[4];
                num++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean jumpa = false;
        for(int i=0;i<num;i++){
            if(!jumpa){
                if(arrayData[2].equals(tempname)){
                    jumpa = true;
                }else 
                    jumpa = false;
            }else 
                break;

            if(jumpa=true){
                System.out.println(arrayStatus[i]);
            }
        
        do{
            System.out.println("0. Back");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch(choice){
                case 0:welcome_customer_menu(); break;
                default: System.out.println("Please input the right number");
            }
            input.close();
        }while(choice<0 || choice>0);
    }
    }
}

