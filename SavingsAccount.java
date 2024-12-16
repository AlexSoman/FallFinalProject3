/** Represents the specific implementable savings account type for bank accounts, containing a unique interest rate functionality and withdrawal limit/fee functionality
* A class that has deposit, withdraw, applyExcessWithdrawalFee and applyInterest
*@author Jovan George
*/
public class SavingsAccount extends BankAccount
{
  private int withdrawalCount;
  private static final int WITHDRAWAL_LIMIT = 5;
  private static final double EXCESS_WITHDRAWAL_FEE = 5.00;
  private static final double INTEREST_RATE = 0.43;


  /** Creates a savings bank account with the specificed accountNumber and initial balance
    *@param accountNum The account number of the bank account
    *@param initialBalance The initial balance of the bank account
    */
  public SavingsAccount(String accountNum, double initialBalance)
  {
    super(accountNum, initialBalance);
    this.withdrawalCount = 0;
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
      withdrawalCount++;
      System.out.println("Withdrew $" + amount);
      if(withdrawalCount > WITHDRAWAL_LIMIT)
      {
        applyExcessWithdrawalFee();
        this.withdrawalCount = 0;
      }
      return true;
    }
    else
    {
      System.out.println("You have insufficent funds for this withdrawal or entered an invalid amount!");
      return false;

    }
  }

  /**
  * applyExcessWithdrawlFee, This method removes money from the savings bank account based on the withdrawal fee
  */
  private void applyExcessWithdrawalFee()
  {
    balance-= EXCESS_WITHDRAWAL_FEE;
    System.out.println("Excess withdrawal fee of $" + EXCESS_WITHDRAWAL_FEE + "applied");

  }

  /**
  * applyInterest, This method calculuates and adds interest to the balance of the savings bank account
  */
  public void applyInterest()
  {
    double interest = balance * INTEREST_RATE;
    balance+= interest;
    System.out.println("Interest applied: $" + interest);

  }
}