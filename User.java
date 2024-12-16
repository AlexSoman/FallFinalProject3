/** Represents a user of the Bountiful Banking System
* A class that has getUsername, getPassword, checkInfo, addAccount, getAccounts, and getAccount
*@author Alex Soman
*@author Jovan George
*/
import java.util.*;

public class User
{
   private String username;
   private String password;
   private List<BankAccount> accounts;

    /** Creates a user with the specificed username and password
      *@param username The unique log-in credential element of a user
      *@param password The hidden and unique log-in credential element of a user
      */
   public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<BankAccount>();
    }

    /**
      * getUsername, This method returns the unique username created by a user
      *@return username, the name of the user
      */
    public String getUsername()
    {
        return username;
    }

    /**
      * getPassword, This method returns the unique password created by a user
      *@return password, the secret phrase of the user
      */
    public String getPassword()
    {
        return password;
    }
    /**
      * checkInfo, This method validates that the username and passsword entered by a user are correct(when logging in)
      *@param username, the name created by the user
      *@param password, the secret phrase created by the user
      *@return true if the username and password are correct, false otherwise
      */
    public boolean checkInfo(String username, String password)
    {
        return this.username.equals(username) &&         this.password.equals(password);
    }

    /**
      * addAccount, This method adds a bank account to the user's list of accounts
      *@param account, the account that needs to be added to the list
      */
    public void addAccount(BankAccount account)
    {
        accounts.add(account);
    }

    
    /**
      * getAccounts, This method finds all of a particular user's bank accounts
      *@return accounts, the list of all accounts associated with a particular user
      */
    public List<BankAccount> getAccounts()
    {
        return accounts;
    }

    /**
      * getAccount, This method finds a user's specified bank account
      *@param index, the position of the bank account specified by the user within the full list of accounts
      *@return account, the bank account specified by the user
      */
    public BankAccount getAccount(int index)
    {
        if(index >=0 && index < accounts.size())
        {
            return accounts.get(index);
        }
        return null;
    }

}
