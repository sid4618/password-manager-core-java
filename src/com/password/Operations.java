package com.password;

import java.util.Scanner;

class Operations {
    static void userOperations(String userName){
        Scanner in = new Scanner(System.in);

        System.out.println("1. Show All Passwords");
        System.out.println("2. Add Password");
        System.out.println("3. Delete Password");
        System.out.println("4. Update Password");

        int select = in.nextInt();
        switch (select){
            case 1-> System.out.println("show");
            case 2-> System.out.println("add");
            case 3-> System.out.println("delete");
            case 4-> System.out.println("update");
            default -> System.out.println("Enter valid case");
        }
    }
}
