package morsecode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MorseConverter converter = new MorseConverter();

        while (true) {
            System.out.println("\nVälj ett alternativ:");
            System.out.println("1. Omvandla text till morsekod");
            System.out.println("2. Omvandla morsekod till text");
            System.out.println("3. Avsluta");
            System.out.print("Ditt val: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Ange text: ");
                String input = scanner.nextLine();
                try {
                    System.out.println("Morsekod: " + converter.textToMorse(input));
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
            } else if (choice == 2) {
                System.out.print("Ange morsekod: ");
                String input = scanner.nextLine();
                try {
                    System.out.println("Text: " + converter.morseToText(input));
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
            } else if (choice == 3) {
                System.out.println("Programmet avslutas.");
                break;
            } else {
                System.out.println("Felaktigt val, försök igen.");
            }
        }
    }
}