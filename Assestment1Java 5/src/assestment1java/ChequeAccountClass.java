
package assestment1java;

/**
 *
 * @author juan
 */
public class ChequeAccountClass extends Account {

    @Override
public void makeAccountWithdraw(double withdrawAmount) throws AccException {
        if (withdrawAmount <= 0) {
            throw new AccException("Invalid withdraw amount.");
        } else if (withdrawAmount > balance) {
            throw new AccException("Insufucuent founds.");
        } 
        else if(((withdrawAmount - 50) % 20 == 0 && withdrawAmount > 50) || (withdrawAmount % 50) == 0 || (withdrawAmount % 20) == 0){
            balance = balance - withdrawAmount;
            throw new AccException("Thanks, you have succesfully withdrawn "+withdrawAmount+" Dollars");
            } else {
            throw new AccException("We cant deliver this notes.");
            
        }
    }    

    @Override
    public void setInterestRate() {
        interestRate=0;
    }

    @Override
    public void calculateInterest() {
    balance+=interestRate;    }

       }

    

    
    
    

    
