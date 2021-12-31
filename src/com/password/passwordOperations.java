package com.password;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.password.AES.*;

public class passwordOperations {
    static void showPasswords(String user) throws IOException {
        String userPath = "E:\\Code\\College\\JavaCode\\Project\\users\\";
        Path userFile = Path.of(userPath + user+".txt");
        System.out.println(Files.readString(userFile));
    }
    static void addPassword(String user) throws Exception {
        Scanner in = new Scanner(System.in);
        String userName = "";


        System.out.print("Enter Username:");
        userName = in.next();
        System.out.print("Enter Password:");
        String hash = encrypt(in.next(),generateKey());

//        write data
        String data = userName + " " + hash ;

        String userPath = "E:\\Code\\College\\JavaCode\\Project\\users\\";

        FileWriter userFile = new FileWriter(userPath + user+".txt",true);
        userFile.write(data);
        userFile.write("\n");
        userFile.close();

    }
    static void deletePassword(String user) throws IOException {
        Scanner in = new Scanner(System.in);
        String userName = "";


        System.out.print("Enter Username:");
        userName = in.next();

        String userPath = "E:\\Code\\College\\JavaCode\\Project\\users\\";
        Path userFile = Path.of(userPath + user+".txt");
        String data = Files.readString(userFile);


        String newData = new String();
        newData = data.substring(data.indexOf("fb"),data.indexOf("\n"));
        System.out.println(newData);
        data.replace(newData," ");
        System.out.println("-------");
        System.out.println(data);

    }
    static void getPassword() throws Exception {
        Scanner in = new Scanner(System.in);
        String hash = "";


        System.out.print("Enter Hash:");
        hash = in.next();

        String password = decrypt(hash,generateKey());
        System.out.println("Password for hash is: "+ password);
    }

}
