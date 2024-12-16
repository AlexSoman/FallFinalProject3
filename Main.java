/** Represents a simulation of the Bountiful Banking System
* A class that has handleUserMenu, createAccount, viewAccounts, performTransaction, applyInterest
*@author Alex Soman
*@author Jovan George
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to the Bountiful Bank Simulator, where all your financial needs will be met!");
        System.out.println("Enter 'l' to login or 'c' to create a new account!");
        String yes;
        User user;
        HashSet<User> test = new HashSet<User>();
        test.add(new User("y","y"));
        Database data = new Database(test);
        do {
            yes = inp.nextLine();
            if (yes.equals("c")) {
                user = data.signup();
            } else if (yes.equals("l")) {
                user = data.login();
            } else {
                System.out.println("Invalid Entry, please enter 'l' to login or 'c' to create a new account!");
                continue;
            }
            if(user != null)
            {
                handleUserMenu(user,data,inp);
                System.out.println();
                System.out.println("Enter 'l' to login to a new account or 'c' to create a new account!");
            }
        }
        while(true);
    }

    /**
      * handleUserMenu, This method processes the user's requests regarding the actions they want perform within the Bountiful Banking System(creating an account, making transactions, etc.)
      *@param user, the user object that the system is allowing to utilize the bank's features
      *@param data, the database object that contains the user's information for their specific banking actions
      *@param inp, the scanner object that allows the user to input their requests
      */
    private static void handleUserMenu(User user, Database data, Scanner inp)
    {
        System.out.println("Welcome " + user.getUsername() + "!");
        while(true)
        {
            System.out.println("\nEnter a number to select an option.");
            System.out.println("\n1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Make A Transaction");
            System.out.println("4. Logout");
            System.out.print("Please pick an option(enter a number 1-4): ");
            int choice = inp.nextInt();
            inp.nextLine();

            switch(choice)
            {
                case 1:
                    createAccount(user, data, inp);
                    break;

                case 2:
                    viewAccounts(user);
                    break;

                case 3:
                    performTransaction(user, inp);
                    break;

                case 4:
                    System.out.println("You are being logged out... Thank you for using Bountiful Bank Simulator!");
                    return;

                default:
                    System.out.println("You've made an invalid entry! Please enter a number 1-4!");



            }

        }

    }

    /**
      * createAccount, This method processes the user's request to create a new bank account
      *@param user, the user object that the system is allowing to utilize the bank's features
      *@param data, the database object that contains the user's information for their specific banking actions
      *@param inp, the scanner object that allows the user to input their account creation requests
      */
    private static void createAccount(User user, Database data, Scanner inp)
    {
        System.out.println("Enter the type of account you'd like to create (checking/savings): ");
        String accountType = inp.nextLine();
        System.out.println("Enter your initial balance.");
        double initialBalance = inp.nextDouble();
        inp.nextLine();
        if (accountType.equals("checking") || accountType.equals("savings"))
        {
            BankAccount account = data.createAccount(user, accountType, initialBalance);
            System.out.println("Your account was successfully created! ACN: " + account.getAccountNumber());
        }
        else
        {
            System.out.println("You've attempted to make an invalid account! Please try again!");
        }

    }

    /**
      * viewAccounts, This method processes the user's request to view their current bank accounts
      *@param user, the user object that the system is allowing to utilize the bank's viewing feature
      */
    private static void viewAccounts(User user)
    {
        List<BankAccount> accounts = user.getAccounts();
        if(accounts.isEmpty())
        {
            System.out.println("You don't have any accounts!");
        }
        else
        {

            for(int i = 0; i < accounts.size(); i++)
            {
                BankAccount account = accounts.get(i);
                int accountNumber = i + 1;
                String accountType = account.getClass().getSimpleName();
                String accountID = account.getAccountNumber();
                double balance = account.getBalance();
                System.out.println("Account Number: " + accountNumber + ", Account Type: " + accountType + ", Account ID: " + accountID + ", Balance: $" + balance);


            }


        }


    }


    /**
      * performTransaction, This method processes the user's request to make transactions on their bank acounts
      *@param user, the user object that the system is allowing to utilize the bank's transaction features
      *@param inp, the scanner object that allows the user to input their account transaction requests
      */
    private static void performTransaction(User user, Scanner inp)
    {
        System.out.print("Please select the account number linked to the account you'd like to perform a transaction on!");
        int accountIndex = inp.nextInt() - 1;
        inp.nextLine();
        BankAccount specifiedAccount = user.getAccount(accountIndex);
        if(specifiedAccount == null)
        {

            System.out.println("You've attempted to select an invalid account! Please try again!");
            return;
        }
        System.out.println("Please enter a number to select one of the following options.");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Apply Interest");
        System.out.print("Pick an option: ");
        int choice = inp.nextInt();
        inp.nextLine();

        switch(choice)
         {
             case 1:
                 System.out.print("Enter the amount you'ld like to deposit: ");
                 double depositAmt = inp.nextDouble();
                 specifiedAccount.deposit(depositAmt);
                 break;

             case 2:
                 System.out.print("Enter the amount you'd like to withdraw: ");
                 double withdrawalAmt = inp.nextDouble();
                 specifiedAccount.withdraw(withdrawalAmt);
                 break;

             case 3:
                 applyInterest(specifiedAccount);
                 break;

             default:
                 System.out.println("You've attempted to perform an account action unavailable to you!");




         }







    }


    /**
      * applyInterest, This method processes the user's request to add interest to their bank account's balance
      *@param account, the bank account object that the system is allowing the user to add interest to
      */
    private static void applyInterest(BankAccount account)
    {
        if(account instanceof CheckingAccount)
        {
            ((CheckingAccount) account).applyInterest();
        }
        else if( account instanceof SavingsAccount)
        {
            ((SavingsAccount) account).applyInterest();
        }
        else
        {
            System.out.println("You can't apply interest to this account type!");
        }


    }
























}
