/** Represents a standard foundation for creating more specific types of bank accounts(checking accounts, savings accounts)
* A class that has deposit, withdraw, getBalance, and getAccountNumber
*@author Jovan George
*/
public abstract class BankAccount
{
  protected double balance;
  protected String accountNumber;

  /** Creates a bank account with the specificed accountNumber and initial balance
  *@param accountNum The account number of the bank account
  *@param initialBalance The initial balance of the bank account
  */
  public BankAccount(String accountNum, double initialBalance)
  {
    accountNumber = accountNum;
    balance = initialBalance;

  }

  /**
  * deposit, This method adds the specified amount to the balance of the bank account
  *@param amount The amount to be deposited
  */
  public abstract void deposit(double amount);


  /**
  * withdraw, This method removes the specified amount from the balance of the bank account
  *@param amount The amount to be withdrawn
  *@return true if the withdrawal was successful, false otherwise
  */
  public abstract boolean withdraw(double amount);

  /**
  * getBalance, This method returns the balance of the bank account
  *@return balance, the amount of money in the bank account
  */
  public double getBalance()
  {
    return balance;
  }

  /**
  * getAccountNumber, This method returns the account number of the bank account
  *@return accountNumber, the unique identification number associated with a bank account
  */
  public String getAccountNumber()
  {
    return accountNumber;
  }






}
