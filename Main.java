/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.main;

/**
 *
 * @author HP
 */



import java.util.*;

class Main {
    // Class to represent a donor
    static class Donor {
        String name;
        String bloodGroup;
        String contact;
        String city;

        Donor(String name, String bloodGroup, String contact, String city) {
            this.name = name;
            this.bloodGroup = bloodGroup;
            this.contact = contact;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Blood Group: " + bloodGroup + ", Contact: " + contact + ", City: " + city;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Donor> donors = new ArrayList<>();
        System.out.println("<..............Welcome to Amrai Agamir Blood Donation Foundation..............>");
        while (true) {
            System.out.println("\nBlood Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. Search Donor by Blood Group");
            System.out.println("3. Display All Donors");
            System.out.println("4. Delete a Donor");
            System.out.println("5. Update Donor Information");
            System.out.println("6. Count Donors by Blood Group");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Donor
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    donors.add(new Donor(name, bloodGroup, contact, city));
                    System.out.println("Donor added successfully!");
                    break;

                case 2: // Search Donor by Blood Group
                    System.out.print("Enter Blood Group to Search: ");
                    String searchGroup = scanner.nextLine();
                    boolean found = false;
                    for (Donor donor : donors) {
                        if (donor.bloodGroup.equalsIgnoreCase(searchGroup)) {
                            System.out.println(donor);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No donors found with blood group " + searchGroup);
                    }
                    break;

                case 3: // Display All Donors
                    if (donors.isEmpty()) {
                        System.out.println("No donors available.");
                    } else {
                        System.out.println("List of Donors:");
                        for (Donor donor : donors) {
                            System.out.println(donor);
                        }
                    }
                    break;

                case 4: // Delete a Donor
                    System.out.print("Enter Name of Donor to Delete: ");
                    String deleteName = scanner.nextLine();
                    Iterator<Donor> iterator = donors.iterator();
                    boolean deleted = false;
                    while (iterator.hasNext()) {
                        Donor donor = iterator.next();
                        if (donor.name.equalsIgnoreCase(deleteName)) {
                            iterator.remove();
                            System.out.println("Donor deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Donor with name " + deleteName + " not found.");
                    }
                    break;

                case 5: // Update Donor Information
                    System.out.print("Enter Name of Donor to Update: ");
                    String updateName = scanner.nextLine();
                    boolean updated = false;
                    for (Donor donor : donors) {
                        if (donor.name.equalsIgnoreCase(updateName)) {
                            System.out.print("Enter New Blood Group: ");
                            donor.bloodGroup = scanner.nextLine();
                            System.out.print("Enter New Contact: ");
                            donor.contact = scanner.nextLine();
                            System.out.print("Enter New City: ");
                            donor.city = scanner.nextLine();
                            System.out.println("Donor information updated successfully!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Donor with name " + updateName + " not found.");
                    }
                    break;

                case 6: // Count Donors by Blood Group
                    System.out.print("Enter Blood Group to Count: ");
                    String countGroup = scanner.nextLine();
                    int count = 0;
                    for (Donor donor : donors) {
                        if (donor.bloodGroup.equalsIgnoreCase(countGroup)) {
                            count++;
                        }
                    }
                    System.out.println("Number of donors with blood group " + countGroup + ": " + count);
                    break;

                case 7: // Exit
                    System.out.println("Exiting Blood Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
