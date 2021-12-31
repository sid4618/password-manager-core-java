package com.password;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.password.AES.encrypt;
import static com.password.AES.generateKey;
import static com.password.Operations.userOperations;

public class User {
    public static void newUser() throws Exception {

        Scanner in = new Scanner(System.in);
        String userName = "";
        String password = "";

        System.out.print("Enter Username:");
        userName = in.next();
        System.out.print("Enter Password:");
        password = in.next();

        try {

            String userPath = "E:\\Code\\College\\JavaCode\\Project\\users\\";
            String pwdPath = "E:\\Code\\College\\JavaCode\\Project\\users\\passwords\\";
            File object = new File(userPath + userName+".txt");
            FileWriter objectPwd = new FileWriter(pwdPath + userName+"Pwd"+".txt");

            // create files
            if (object.createNewFile() ) {
                System.out.println("User created: " + object.getName());
            } else {
                System.out.println("User already exists.");
            }

           // store hashes
            objectPwd.write(encrypt(password,generateKey()));

            objectPwd.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void loginUser() throws Exception {

        Scanner in = new Scanner(System.in);
        String userName = "";
        String password = "";

        System.out.print("Enter Username:");
        userName = in.next();
        System.out.print("Enter Password:");
        password = in.next();

        String userPath = "E:\\Code\\College\\JavaCode\\Project\\users\\";
        String pwdPath = "E:\\Code\\College\\JavaCode\\Project\\users\\passwords\\";
        File f = new File(userPath + userName+".txt");
        Path pwdFileName = Path.of(pwdPath + userName+"Pwd"+".txt");


        if (f.exists()){
            String userHash = encrypt(password,generateKey());
            String hash = Files.readString(pwdFileName);
            if(userHash.equals(hash)){

                System.out.println("logged in");
                userOperations(userName);
            }else{
                System.out.println("Invalid Password - Login Failed");
            }


        }
        else
            System.out.println("User does not Exists - Login Failed");

    }
    public static void deleteUser() throws Exception {
        Scanner in = new Scanner(System.in);
        String userName = "";
        String password = "";

        System.out.print("Enter Username:");
        userName = in.next();
        System.out.print("Enter Password:");
        password = in.next();

        String userPath = "E:\\Code\\College\\JavaCode\\Project\\users\\";
        String pwdPath = "E:\\Code\\College\\JavaCode\\Project\\users\\passwords\\";
        File object = new File(userPath + userName+".txt");
        File pwdObject = new File(pwdPath + userName+"Pwd"+".txt");

        if (object.exists() && pwdObject.exists()){

            if(object.delete() && pwdObject.delete())
            {
                System.out.println("User deleted successfully");
            }
            else
            {
                System.out.println("Failed to delete User");
            }
        }
    }
}
