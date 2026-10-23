

package com.mycompany.user;

import java.util.ArrayList;
import java.util.Scanner;


class Information {
    String username;
    String password;

    public Information(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class User {
    public static void main(String[] args) {
        
        ArrayList<Information> Information = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Learning Outcome: Use loops
        while (true) {
            System.out.println("\n--- Student Login and Registration System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            // Learning Outcome: Use conditional statements (if, else)
            if (choice.equals("1")) {
                
                // Learning Outcome: Validate user input
                System.out.print("Enter new username: ");
                String username = scanner.nextLine().trim();
                if (username.isEmpty()) {
                    System.out.println("Username cannot be empty!");
                    continue;
                }
                if (username.length() < 5) {
                    System.out.println("Username must be at least 5 characters!");
                    continue;
                }
                
                boolean exists = false;
                for (Information u : Information) {
                    if (u.username.equals(username)) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("Username already taken!");
                    continue;
                }

                System.out.print("Enter new password: ");
                String password = scanner.nextLine().trim();
                if (password.length() < 8) {
                    System.out.println("Password must be at least 8 characters!");
                    continue;
                }

                // Store user
                Information.add(new Information(username, password));
                System.out.println("Registration successful!");

            } else if (choice.equals("2")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                boolean loggedIn = false;
                for (Information u : Information) {
                    if (u.username.equals(username) && u.password.equals(password)) {
                        loggedIn = true;
                        break;
                    }
                }

                if (loggedIn) {
                    System.out.println("Login successful! Welcome " + username);
                } else {
                    System.out.println("Login failed! Invalid username or password.");
                }

            } else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
