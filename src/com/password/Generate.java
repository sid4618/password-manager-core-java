package com.password;

import java.util.Random;
import java.util.Scanner;

public class Generate {

   public static String generatePassword() {
      Scanner in = new Scanner(System.in);

      String capitalCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String lowerCase = "abcdefghijklmnopqrstuvwxyz";
      String special = "!@#$!@#$$%^&*()_+|}{[]:";
      String numbers = "1234567890";
      String combinedChars = capitalCase + lowerCase + special + numbers;
      Random random = new Random();
      int length = in.nextInt();
      char[] password = new char[length];

      password[0] = lowerCase.charAt(random.nextInt(lowerCase.length()));
      password[1] = capitalCase.charAt(random.nextInt(capitalCase.length()));
      password[2] = special.charAt(random.nextInt(special.length()));
      password[3] = numbers.charAt(random.nextInt(numbers.length()));
   
      for(int i = 4; i< length ; i++) {
         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
      }
      return String.valueOf(password);
   }
}