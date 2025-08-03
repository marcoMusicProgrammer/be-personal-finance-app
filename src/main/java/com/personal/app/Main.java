package com.personal.app;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Scanner;

import com.personal.app.controller.ControllerManager;
import com.personal.app.controller.GenericController;
import com.personal.app.models.entities.Expense;
import com.personal.app.models.entities.Income;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ControllerManager cm = new ControllerManager("expense");

    // Lists
    // public static List<Expense> expenses = new ArrayList();

    public static void main(String[] args) {


        boolean quitProgram = false;
        String userCmd;

        do {
            System.out.println("Current controller type: "+cm.getCurrentType() + "\n");
            System.out.println("Welcome, insert a command: \n");
            help();
            userCmd = sc.nextLine();

            switch (userCmd) {
                case "1":
                    help();
                    break;
                case "2":
                    getList();
                    break;
                case "3":
                    add();
                    break;
                case "4":
                    switchCurrentController();
                    break;
                case "5":
                    quitProgram = true;
                    break;
                default:
                    System.out.println("Invalid command.");
            }

        } while (!quitProgram);
        //controller.saveExpense("Spesa della domenica",29.89);

        System.out.println("Bye Bye!");
        sc.close();
    }

    public static void help() {
        String res = """
        List of program commands:
        -1 : Command Lists;
        -2 : Get Expense List;
        -3 : Add Expense;
        -4 : Change status on income;
        -5 : Quit program;
        """;

        System.out.println(res);
    }

    public static void getList() {
        System.out.println(cm.getController().getList());
    }

    public static void add() {

        switch(cm.getCurrentType()) {
            case "expense":
                Expense expense = new Expense();
                setExpenseProperties(expense,"description");
                setExpenseProperties(expense,"amount");
        
                castAndAdd(expense);
                break;
            case "income":
                Income income = new Income();
                setIncomeProperties(income, "description");
                setIncomeProperties(income, "amount");
                setIncomeProperties(income, "date");

                castAndAdd(income);
                break;
            default:
                throw new IllegalArgumentException("No match for Controller: "+ cm.getCurrentType());
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void castAndAdd(Object object) {
        GenericController controller = cm.getController();
        controller.add(object);
    }



    public static void setExpenseProperties(Expense expense, String property) {
        boolean validProperty = false;
        System.out.println("Add "+property+": ");

        do {
            try {
                switch(property) {
                    case "description":
                        expense.setDescription(sc.nextLine());
                        break;
                    case "amount": 
                        expense.setAmount(Double.parseDouble(sc.nextLine()));
                        break;
                    default:
                        throw new InvalidParameterException("property is not a valid parameter: "+property);
                }
                validProperty = true;

            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while(!validProperty);
    }

    public static void setIncomeProperties(Income income, String property) {
        boolean validProperty = false;
        System.out.println("Add "+property+": ");

        do {
            try {
                switch(property) {
                    case "description":
                        income.setDescription(sc.nextLine());
                        break;
                    case "amount":
                        income.setAmount(Double.parseDouble(sc.nextLine()));
                        break;
                    case "date":
                        String date = sc.nextLine();
                        LocalDate parseDate = LocalDate.parse(date);
                        income.setDate(parseDate);
                        break;
                    default:
                        throw new IllegalArgumentException("No properties with name: "+property);
                }
                validProperty = true;

            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (!validProperty);
    }

    public static void switchCurrentController() {
        if(cm.getCurrentType() == "expense") {
            cm.setController("income");
        } else {
            cm.setController("expense");
        }

        System.out.println("Controller is actually on: "+cm.getCurrentType());
    }
    
}
