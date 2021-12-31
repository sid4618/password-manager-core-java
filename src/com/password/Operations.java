package com.password;

import java.io.IOException;
import java.util.Scanner;

import static com.password.passwordOperations.*;

class Operations {
    static void userOperations(String userName) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Show All Passwords");
        System.out.println("2. Add Password");
        System.out.println("3. Delete Password");
        System.out.println("4. Update Password");
        System.out.println("5. Logout Password");

        int select = in.nextInt();
        switch (select){
            case 1-> showPasswords(userName);
            case 2-> addPassword(userName);
            case 3-> deletePassword(userName);
            case 4-> updatePassword(userName);
            case 5-> logout();
            default -> System.out.println("Enter valid case");
        }
    }
}
