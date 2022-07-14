
package assestment1java;

/**
 *
 * @author juan
 */
public class NetSaverAccount extends Account{

    private double limit= 150;

    @Override
        public void makeAccountWithdraw(double withdrawAmount) throws AccException {
        if (withdrawAmount <= 0) {
            throw new AccException("Invalid withdraw amount.");
        } else if (withdrawAmount > balance) {
            throw new AccException("Insufucuent founds.");
        } else if (withdrawAmount > limit ) {
            throw new AccException("You have exceded your daily limit. You can only withdraw "+ limit+ " dollars more today");
        }
        else if(((withdrawAmount - 50) % 20 == 0 && withdrawAmount > 50) || (withdrawAmount % 50) == 0 || (withdrawAmount % 20) == 0){
            balance = balance - withdrawAmount;
            limit=limit-withdrawAmount;
            throw new AccException("Thanks, you have succesfully withdrawn "+withdrawAmount+" Dollars, and your daily limit now is;"+limit);
            
        } else {
            throw new AccException("We cant deliver this notes.");
            
        }
    }

    

    @Override
    public void setInterestRate() {
        interestRate=20;
    }

    @Override
    public void calculateInterest() {
        balance+=interestRate;    }
    }

    
    

