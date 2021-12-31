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
    public static void newUser(String userName,String password) throws Exception {
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
    public static void loginUser(String userName,String password) throws Exception {

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
}
