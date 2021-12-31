package com.password;

import java.util.Scanner;

import static com.password.Generate.generatePassword;
import static com.password.User.loginUser;
import static com.password.User.newUser;

public class Main {

    public static void main(String[] args) throws Exception {
//        System.out.println("Enter Master Password:");
//
//        System.out.println("1. Generate New Passowrd");
//
//        Scanner in = new Scanner(System.in);
//        int select = in.nextInt();
//        String password = "";
//        switch (select){
//            case 1
//                    -> password = generatePassword();
//
//        }
//        System.out.println(password);
//        newUser("siddo","12345678");
         loginUser("siddo","12345678");
    }
}
