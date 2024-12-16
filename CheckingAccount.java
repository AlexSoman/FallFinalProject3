/** Represents the specific implementable checking account type for bank accounts, containing a unique interest rate functionality
* A class that has deposit, withdraw, and applyInterest
*@author Jovan George
*/
public class CheckingAccount extends BankAccount
{
   private static final double INTEREST_RATE = 0.08;

  /** Creates a checking bank account with the specificed accountNumber and initial balance
    *@param accountNum The account number of the bank account
    *@param initialBalance The initial balance of the bank account
    */
  public CheckingAccount(String accountNum, double initialBalance)
  {
    super(accountNum, initialBalance);
  }

  /**
  * deposit, This method adds the specified amount to the balance of the bank account
  *@param amount The amount to be deposited
  */
  public void deposit(double amount)
  {
    if(amount > 0)
    {
      balance+=amount;
      System.out.println("Deposited $" + amount);
    }
    else
    {
      System.out.println("You entered a invalid deposit amount!");

    }
  }

  /**
  * withdraw, This method removes the specified amount from the balance of the checking bank account
  *@param amount The amount to be withdrawn
  *@return true if the withdrawal was successful, false otherwise
  */
  public boolean withdraw(double amount)
  {
    if(amount > 0 && balance >= amount)
    {
      balance-=amount;
      System.out.println("Withdrew $" + amount);
      return true;
    }
    else
    {
      System.out.println("You have insufficent funds for this withdrawal or entered an invalid amount!");
      return false;

    }
  }

  /**
  * applyInterest, This method calculuates and adds interest to the balance of the checking bank account
  */
  public void applyInterest()
  {
    double interest = balance * INTEREST_RATE;
    balance+= interest;
    System.out.println("Interest applied: $" + interest);

  }









}