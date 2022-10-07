package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.Account_Industry.*;
import static org.example.Opportunities_product.*;
import static org.example.Opportunities_status.*;

public class Main {
    public static final List<Leads> leads = new ArrayList<>();
    public static final List<Leads> contacs = new ArrayList<>();
    public static final List<Opportunities> opportunities = new ArrayList<>();
    public static final List<Accounts> accounts = new ArrayList<>();
    public static final List<Leads> accountsLeads = new ArrayList<>();
    public static final List<Opportunities> accountsOpportunities = new ArrayList<>();
    public static boolean salir = false;

    public static void mainMenu() {
        String textLeads, textOpportunities, textAccounts;
        if (!leads.isEmpty()) {
            if (leads.size() > 1) textLeads = leads.size() + " leads";
            else textLeads = "1 lead";
        } else {
            textLeads = "0 leads";
        }
        if (!opportunities.isEmpty()) {
            if (opportunities.size() > 1) textOpportunities = opportunities.size() + " oportunities";
            else textOpportunities = "1 oportunity";
        } else {
            textOpportunities = "0 opportunities";
        }
        if (!accounts.isEmpty()) {
            if (accounts.size() > 1) textAccounts = accounts.size() + " accounts";
            else textAccounts = "1 account";
        } else {
            textAccounts = "0 accounts";
        }
        int opcion;
        System.out.println("\n1. New lead");
        System.out.println("2. Show all leads " + "\u001B[36m" + "- Currently " + textLeads + "\u001B[0m");
        System.out.println("3. Lookup Lead id");
        System.out.println("4. Convert lead to opportunity");
        System.out.println("5. Show all opportunities " + "\u001B[32m" + "- Currently " + textOpportunities + "\u001B[0m");
        System.out.println("6. Update an opportunity");
        System.out.println("7. Show all accounts " + "\u001B[34m" + "- Currently " + textAccounts + "\u001B[0m");
        System.out.println("8. Exit");
        Scanner sn = new Scanner(System.in);
        System.out.print("Escribe una de las opciones: ");
        try {
            opcion = sn.nextInt();
            switch (opcion) {
                case 1 -> createLead();
                case 2 -> showLeads();
                case 3 -> findLeads();
                case 4 -> convertLeadtoOpportunity();
                case 5 -> showOpportunities();
                case 6 -> updateOpportunity();
                case 7 -> showAccounts();
                case 8 -> salir = true;
                default -> System.out.println("""
                        \u001B[31m
                        Solo números entre 1 y 7
                        \u001B[0m""");
            }
        } catch (InputMismatchException e) {
            System.out.println("""
                    \u001B[31m
                    Debes insertar un número
                    \u001B[0m""");
            sn.next();
        }
    }

    private static void createLead() {
        String name, phone, email, company;
        Scanner sn = new Scanner(System.in);
        System.out.print("\nPlease enter the name: ");
        name = sn.nextLine();
        System.out.print("Please enter the phone number: ");
        phone = sn.nextLine();
        System.out.print("Please enter the email: ");
        email = sn.nextLine();
        System.out.print("Please enter the company name: ");
        company = sn.nextLine();
        System.out.print("\n");
        leads.add(new Leads(name, phone, email, company));
    }

    private static void showLeads() {
        if (!leads.isEmpty()) System.out.println("\n*******Leads********\n" + leads + "\n*******Leads********\n");
        else System.out.println("\nNo hay leads\n");
    }

    private static void findLeads() {
        int id;
        Scanner sn = new Scanner(System.in);
        System.out.print("\nPlease enter the id: ");
        id = sn.nextInt();
        if (id <= leads.size()) {
            System.out.println(leads.get(id));
        } else {
            System.out.println("\u001B[31m"+"El id está fuera de rango"+"\u001B[0m");
        }
    }

    private static void convertLeadtoOpportunity() {
        int id, quantity, product = 0, employeeCount;
        String city;
        String country;
        Opportunities_product product_type = null;
        Scanner sn = new Scanner(System.in);
        boolean salir2 = false;
        System.out.print("\nPlease enter the id: ");
        id = sn.nextInt();
        try {
            contacs.add(leads.get(id));
            while (!salir2) {
                System.out.print("\nPlease enter the product type (1. HYBRID, 2. FLATBED, 3. BOX): ");
                try {
                    product = Integer.parseInt(sn.next());
                    if (product < 0 || product > 3)
                        throw new InputMismatchException("\u001B[31m"+"El número debe estar entre 1 y 3"+"\u001B[0m");
                    else salir2 = true;
                } catch (InputMismatchException | IllegalArgumentException e) {
                    System.out.println("\u001B[31m"+"Debes insertar un número entre 1 y 3"+"\u001B[0m");
                    sn.nextLine();
                }

            }
            switch (product) {
                case 1 -> product_type = HYBRID;
                case 2 -> product_type = FLATBED;
                case 3 -> product_type = BOX;
                default -> System.out.println("Solo números entre 1 y 3");
            }
            System.out.print("Please enter the quantity: ");
            quantity = Integer.parseInt(sn.next());
            System.out.print("Please enter the number of employees: ");
            employeeCount = Integer.parseInt(sn.next());
            System.out.print("Please enter the city: ");
            city = sn.next();
            System.out.print("Please enter the country: ");
            country = sn.next();
            Opportunities temp = new Opportunities(product_type, quantity, leads.get(id), OPEN);
            opportunities.add(temp);
            accountsLeads.add(leads.get(id));
            accountsOpportunities.add(temp);
            accounts.add(new Accounts(PRODUCE, employeeCount, city, country, accountsLeads, accountsOpportunities));
            leads.remove(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("""
                    \u001B[31m
                    El id está fuera de rango o no existe
                    \u001B[0m""");
        }
    }


    private static void showOpportunities() {
        if (!opportunities.isEmpty())
            System.out.println("\n*******Opportunities********\n" + opportunities + "\n*******Opportunities********\n");
        else System.out.println("\nNo hay opportunities\n");
    }

    private static void updateOpportunity() {
        Scanner sn = new Scanner(System.in);
        System.out.print("\nPlease enter the id: ");
        int id = sn.nextInt();
        if (id <= opportunities.size()) {
            boolean salir2 = false;
            while (!salir2) {
                int opcion;
                System.out.println("1. Lead Closed - Won");
                System.out.println("2. Lead Closed - Lost");
                System.out.println("3. Back to main menu");
                System.out.print("Escribe una de las opciones: ");
                try {
                    opcion = sn.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            opportunities.get(id).setStatus(CLOSED_WON);
                            salir2 = true;
                        }
                        case 2 -> {
                            opportunities.get(id).setStatus(CLOSED_LOST);
                            salir2 = true;
                        }
                        case 3 -> salir2 = true;
                        default -> System.out.println("""
                                \u001B[31m
                                Solo números entre 1 y 3
                                \u001B[0m""");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("""
                            \u001B[31m
                            Debes insertar un número
                            \u001B[0m""");
                    sn.next();
                }
            }
        }
    }

    private static void showAccounts() {
        if (!accounts.isEmpty())
            System.out.println("\n*******Accounts********\n" + accounts + "\n*******Accounts********\n");
        else System.out.println("\nNo hay accounts\n");
    }

    public static void main(String[] args) {
        while (!salir) {
            mainMenu();
        }
    }
}