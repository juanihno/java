
package assestment1java;

/**
 *
 * @author juan
 */
public abstract class Account {
    
    protected double balance;
    protected double interestRate;

    

    /**
     * Constructor
     */
    public Account() {
    }

    /**
     * Print the Bank Account balance.
     */
    public void showBalance() {
        System.out.println("Account balance...: " + balance);
    }    
    
    /**
     * Make a account withdraw.
     * @param withdrawAmount double
     */
    public abstract void makeAccountWithdraw(double withdrawAmount)throws AccException; 
    


    /**
     * Make a account deposit.
     * @param depositAmount double
     */
    public String makeAccountDeposit(double depositAmount) {
        if (depositAmount <= 0) {
           return "Invalid deposit amount.";
        } 
        else {
            setBalance(balance + depositAmount);
            return "Your "+ depositAmount+ " deposit has succesfully being made, thanks.";
        }
    }
    

   
    /**
     * Get the balance attribute.
     * @return balance double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the balance attribute.
     * @param balance double
     */ 
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public abstract void setInterestRate();
    public abstract void calculateInterest();

    /**
     * Print the Bank Account details.
     * @return 
     */  

    @Override    
    public String toString() {
        return "Account{" + "balance=" + balance + ", interestRate=" + interestRate + '}';
    }
}

    

