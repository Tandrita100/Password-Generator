package com.projects;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of Password:");
        int length = sc.nextInt();

        System.out.println("Do you want to include uppercase letters? (yes/no):");
        boolean includeUppercase = sc.next().equalsIgnoreCase("yes");

        System.out.println("Do you want to include lowercase letters? (yes/no):");
        boolean includeLowercase = sc.next().equalsIgnoreCase("yes");

        System.out.println("Do you want to include numbers? (yes/no):");
        boolean includeNumbers = sc.next().equalsIgnoreCase("yes");

        System.out.println("Do you want to include Special characters? (yes/no):");
        boolean includeSpecialCharacters = sc.next().equalsIgnoreCase("yes");

        String password = generatePassword(length,includeUppercase,includeLowercase,includeNumbers,includeSpecialCharacters);
        System.out.println("Your Generated Password: " + password);

        sc.close();

    }

    //method to generate random password
    public static String generatePassword(int length ,boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialCharacters){

        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String numberCharacters = "1234567890";
        String specialCharacters = "~!@#$%^&*()_+-={}|[];:,.<>/?";

        String allChars = "";

        if(includeUppercase) allChars += uppercaseCharacters;
        if(includeLowercase) allChars += lowercaseCharacters;
        if(includeNumbers) allChars += numberCharacters;
        if(includeSpecialCharacters) allChars += specialCharacters;

        for(int i=0 ; i < length ; i++){
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }

}
