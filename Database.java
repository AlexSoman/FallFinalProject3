/** Represents the dabase of the Bountiful Banking System
* A class that has updateInfo, signup, login, createAccount, and generateAccountNumber
*@author Alex Soman
*@author Jovan George
*/
import java.util.*;

public class Database {

    Set<User> base;
    Map<String,String> info;
    public Database(Set<User> users) {
        base = new HashSet<User>();
        base.addAll(users);
        info = new HashMap<String,String>();
        updateInfo();
    }
    /**
    * updateInfo, This method updates the info map with the information of all users
    */
    public void updateInfo() {
        for(User i: base) {
            info.put(i.getUsername(),i.getPassword());
        }
    }

    /** Creates a database that stores all users' information
      */
    public Database() {
        base = new HashSet<User>();
        info = new HashMap<String,String>();
    }

    /**
      * signup, This method gets a user's information and adds them to the database
      *@return User, the user object that was created and stored
      */
    public  User signup() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter a username: ");
        String yes = inp.nextLine();
        while (info.containsKey(yes)) {
            System.out.println("That username is taken! Please enter another username!");
            yes = inp.nextLine();
        }
        System.out.println("");
        System.out.println("Please enter a password: ");
        User newUser = new User(yes,inp.nextLine());
        System.out.println("");
        System.out.println("Succesfully signed up! Logging in... ");
        System.out.println("");
        base.add(newUser);
        updateInfo();
        return newUser;
    }

    /**
      * login, This method gets a user's information and checks if they are in the database
      *@return User, the user object that was logged in to the system
      */
    public User login() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter you username");
        String username = inp.nextLine();
        System.out.println("Enter password");
        String password = inp.nextLine();
        while(!info.containsKey(username) || !info.get(username).equals(password)) {
            System.out.println("username or password was incorrect, try again!");
            System.out.println("Enter you username");
            username = inp.nextLine();
            System.out.println("Enter password");
            password = inp.nextLine();
        }
        for(User i: base) {
            if(i.checkInfo(username,password)) {
                System.out.println("Succesfully Logged in");
                return i;
            }
        }
        System.out.println("An Error occured");
        return null;
    }




    /**
      * createAccount, This method gets the user's preferences and creates their specified bank account
      *@param user, the user object that the account is being created for
      *@param accountType, the type of bank account that the user wants to create
      *@param intialBalance, the initial balance of the account
      *@return account, the account object that was created
      */
    public BankAccount createAccount(User user, String accountType, double initialBalance)
    {
        String accountNumber = generateAccountNumber();
        BankAccount account;
      if(accountType.equals("checking") || accountType.equals("Checking"))
      {
          account = new CheckingAccount(accountNumber, initialBalance);
      }
      else if(accountType.equals("savings") || accountType.equals("Savings"))
      {
          account = new SavingsAccount(accountNumber, initialBalance);
      }
      else
      {
          throw new IllegalArgumentException("Invalid account type! Your account type must be either checking or savings!");
      }
      user.addAccount(account);
      return account;
    }

    /**
      * generateAccountNumber, This method creates a random String that's associated with a particular bank account
      *@return a string that represents a bank account's unique account number
      */
    private String generateAccountNumber()
    {
        return "ACN" + (int)(Math.random() * 10000000);
    }





}
