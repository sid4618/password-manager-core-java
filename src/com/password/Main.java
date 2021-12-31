package com.password;

import java.util.Scanner;

import static com.password.Generate.generatePassword;
import static com.password.User.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("1. New User");
        System.out.println("2. Login User");
        System.out.println("3. Delete User");

        int select = in.nextInt();

        switch (select){
            case 1 -> newUser();

            case 2 -> loginUser();

            case 3 -> deleteUser();

            default -> System.out.println("Invalid Choice");

        }

    }
}
