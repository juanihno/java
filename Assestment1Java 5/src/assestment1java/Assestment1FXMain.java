
package assestment1java;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author juan
 */
public class Assestment1FXMain extends Application  {
    
    private BorderPane borderPane;
    private int currentScreen;
    Account currentAccount;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    //creating the starting page and displaying it
    public void start(Stage primaryStage) throws Exception {
        currentScreen=Constants.LOGIN_SCREEN;
        borderPane = new BorderPane();
        
        displayScreen(currentScreen);
        
        
        Scene scene= new Scene( borderPane, 600, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Assestment1FXMain.class.getResource("login.css").toExternalForm());
        primaryStage.setTitle("AIT Bank");
        primaryStage.show();
        
    }
    
    
    //Create constants for every screen we are gonna manipulate and a switch case to implement a UI metthod for each one
    private void displayScreen(int currentScreen) {
        switch (currentScreen){
            case Constants.LOGIN_SCREEN:
                setUpLogInScreen();
                break;
            case Constants.SELECT_ACCOUNT_SCREEN:
                setUpSelectAccountScreen();
                break;
            case Constants.SELECT_OPERATION_SCREEN:
                setUpSelectOperationScreen();
                break;
            case Constants.WITHDRAW_SCREEN:
                setUpWithdrawScreen();
                break;
             case Constants.DEPOSIT_SCREEN:
                setUpDepositScreen();
             break;
             case Constants.CALCULATE_INTEREST_SCREEN:
                setUpCalculateInterestScreen();
             break;
             case Constants.GET_BALANCE_SCREEN:
                setUpDisplayBalanceScreen();
             break;
             case Constants.CHANGE_WITHDRAW_LIMIT_SCREEN:
                setUpChangeWithdrawLimitScreen();
             break;
                
        }
        
        
        
    }
    
    
    //seting log in screen
    
    private void setUpLogInScreen() {
        GridPane gridPane=new GridPane();
        Label welcomeLabel=new Label("Welcome to AIT ");
        welcomeLabel.setId("welcome-text");
        gridPane.add(welcomeLabel, 0, 0,2,1);
        Label pinLabel=new Label("PIN:");
        gridPane.add(pinLabel, 0, 2);
        TextField pinTextField= new TextField();
        pinTextField.editableProperty().set(false);
        gridPane.add(pinTextField, 1, 2);
        
        GridPane numPadGridPane=new GridPane();
        
        Button one=new Button("1");
        Button two=new Button("2");
        Button three=new Button("3");
        Button four=new Button("4");
        Button five=new Button("5");
        Button six=new Button("6");
        Button seven=new Button("7");
        Button eight=new Button("8");
        Button nine=new Button("9");
        Button zero=new Button("0");
        Button clear=new Button("  clear  ");
        
        
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(one.getText());            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(two.getText());            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(three.getText());            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(four.getText());            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(five.getText());            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(six.getText());            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(seven.getText());            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(eight.getText());            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(nine.getText());            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.appendText(zero.getText());            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pinTextField.clear();            }
        });
        numPadGridPane.add(one, 0, 0);
        numPadGridPane.add(two, 1, 0);
        numPadGridPane.add(three, 2, 0);
        
        numPadGridPane.add(four, 0, 1);
        numPadGridPane.add(five, 1, 1);
        numPadGridPane.add(six, 2, 1);
        
        numPadGridPane.add(seven, 0, 2);
        numPadGridPane.add(eight, 1, 2);
        numPadGridPane.add(nine, 2, 2);
        
        numPadGridPane.add(zero, 0, 3);
        numPadGridPane.add(clear, 1, 3,2,1);
        numPadGridPane.setHgap(10); 
        numPadGridPane.setVgap(10); 
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        
        Button enter= new Button("Enter");
        HBox hBox=new HBox(enter);
        hBox.setAlignment(Pos.CENTER);
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen=Constants.SELECT_ACCOUNT_SCREEN;
                displayScreen(currentScreen);
            }
        });
        gridPane.setAlignment(Pos.CENTER);
        numPadGridPane.setAlignment(Pos.CENTER);
        VBox vBox= new VBox(gridPane,numPadGridPane,hBox);
        vBox.setSpacing(10);
        
        borderPane.setCenter(vBox);
        
        
    }
    
    //seting selectaccount screen to choose which type of account are we gonna use. Everytime we choose a type we create a new object of this account this way we can use its methods
    
    private void setUpSelectAccountScreen() {
        Button savingsButton= new Button("Savings");
        Button chequeButton= new Button("Cheque");
        Button netSaverButton= new Button("Net Saver");
        Button fixedButton= new Button("Fixed");
        
        savingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentAccount = new SavingsAccount();
                SavingsAccount savings = (SavingsAccount) currentAccount;
                savings.setLimit(1400);
                savings.setBalance(2000);
                currentScreen= Constants.SELECT_OPERATION_SCREEN;
                displayScreen(currentScreen);
                
            }
        });
        chequeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                currentAccount = new ChequeAccountClass();
                ChequeAccountClass cheque = (ChequeAccountClass) currentAccount;
                cheque.setBalance(1000);
                currentScreen= Constants.SELECT_OPERATION_SCREEN;
                displayScreen(currentScreen);
            }
        });
        netSaverButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                currentAccount = new NetSaverAccount();
                NetSaverAccount netSaver = (NetSaverAccount) currentAccount;
                netSaver.setBalance(2300);
                currentScreen= Constants.SELECT_OPERATION_SCREEN;
                displayScreen(currentScreen);
            }
        });
        
        fixedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                currentAccount = new FixedAccountClass();
                FixedAccountClass fixed = (FixedAccountClass) currentAccount;
                fixed.setBalance(8000);
                currentScreen= Constants.SELECT_OPERATION_SCREEN;
                displayScreen(currentScreen);
            }
        });
        VBox vBox=new VBox(savingsButton,chequeButton,netSaverButton,fixedButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        
        Button logOutButton= new Button("Log Out");
        Button backButton= new Button("Go Back");
        HBox hBox= new HBox(backButton, logOutButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentScreen== Constants.SELECT_ACCOUNT_SCREEN){
                currentScreen=currentScreen-1;
                displayScreen(currentScreen);
            }
                else if (currentScreen== Constants.SELECT_OPERATION_SCREEN){
                currentScreen=currentScreen-1;
                displayScreen(currentScreen);
            } 
                else if ((currentScreen==Constants.WITHDRAW_SCREEN )||(currentScreen==Constants.DEPOSIT_SCREEN)||(currentScreen==Constants.CALCULATE_INTEREST_SCREEN)||(currentScreen==Constants.GET_BALANCE_SCREEN)||(currentScreen==Constants.CHANGE_WITHDRAW_LIMIT_SCREEN) ){
                    currentScreen=Constants.SELECT_OPERATION_SCREEN;
                                    displayScreen(currentScreen);

                }
            }
        });
        
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen= Constants.LOGIN_SCREEN;
                displayScreen(currentScreen);
            }
        });
        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);
        
        
        
        
    }
    
    //seting select operation screen to choose which operation are we gonna do inside of each type of account

    private void setUpSelectOperationScreen() {
        Button withdrawButton= new Button("Withdraw");
        Button depositButton= new Button("Deposit");
        Button calculateInterestButton= new Button("Calculate Interest");

        Button showBalanceButton= new Button("Show Balance");
        Button changeWithDrawLimitButton= new Button("Change Withdraw Limit");
                
        
        
        withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen=Constants.WITHDRAW_SCREEN;
                displayScreen(currentScreen);
            }
        });
        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen=Constants.DEPOSIT_SCREEN;
                displayScreen(currentScreen);
            }
        });
    calculateInterestButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen=Constants.CALCULATE_INTEREST_SCREEN;
                displayScreen(currentScreen);
            }
        });
    showBalanceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen=Constants.GET_BALANCE_SCREEN;
                displayScreen(currentScreen);
            }
        });
    changeWithDrawLimitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentScreen=Constants.CHANGE_WITHDRAW_LIMIT_SCREEN;
                displayScreen(currentScreen);
            }
        });
    //only savings acc can change limit so we create an if stament and if the currentaccount is an instance of savings we display the option change limit otherwise no
    if (currentAccount instanceof SavingsAccount){

        VBox vBox=new VBox(withdrawButton,depositButton,calculateInterestButton,showBalanceButton, changeWithDrawLimitButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        borderPane.setCenter(vBox);
        
    }
    else{
        VBox vBox=new VBox(withdrawButton,depositButton,calculateInterestButton,showBalanceButton);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        borderPane.setCenter(vBox);
    }
    }
    
    // seting withdraw screen 
    
    private void setUpWithdrawScreen() {

        GridPane gridPane=new GridPane();
        Label withdrawLabel=new Label("Withdraw ");
        withdrawLabel.setId("welcome-text");
        gridPane.add(withdrawLabel, 0, 0,2,1);
        Label pinLabel=new Label("Enter amount:");
        gridPane.add(pinLabel, 0, 2);
        TextField amountTextField= new TextField();
        amountTextField.editableProperty().set(false);
        gridPane.add(amountTextField, 1, 2);
        
        GridPane numPadGridPane=new GridPane();
        
        Button one=new Button("1");
        Button two=new Button("2");
        Button three=new Button("3");
        Button four=new Button("4");
        Button five=new Button("5");
        Button six=new Button("6");
        Button seven=new Button("7");
        Button eight=new Button("8");
        Button nine=new Button("9");
        Button zero=new Button("0");
        Button clear=new Button("  clear  ");
        
        
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(one.getText());            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(two.getText());            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(three.getText());            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(four.getText());            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(five.getText());            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(six.getText());            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(seven.getText());            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(eight.getText());            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(nine.getText());            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(zero.getText());            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.clear();            }
        });
        numPadGridPane.add(one, 0, 0);
        numPadGridPane.add(two, 1, 0);
        numPadGridPane.add(three, 2, 0);
        
        numPadGridPane.add(four, 0, 1);
        numPadGridPane.add(five, 1, 1);
        numPadGridPane.add(six, 2, 1);
        
        numPadGridPane.add(seven, 0, 2);
        numPadGridPane.add(eight, 1, 2);
        numPadGridPane.add(nine, 2, 2);
        
        numPadGridPane.add(zero, 0, 3);
        numPadGridPane.add(clear, 1, 3,2,1);
        numPadGridPane.setHgap(10); 
        numPadGridPane.setVgap(10); 
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        Label displayTransaction=new Label(currentAccount.toString());
        Label showException=new Label();
        VBox vBoxDisplayMessages=new VBox(displayTransaction,showException);
        vBoxDisplayMessages.setAlignment(Pos.CENTER);
        Button enter= new Button("Enter");
        HBox hBox=new HBox(enter);
        hBox.setAlignment(Pos.CENTER);
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String amount=amountTextField.getText();
                Double withdrawAmount=Double.parseDouble(amount);
                try {
                   currentAccount.makeAccountWithdraw(withdrawAmount);
                } catch (AccException ex) {
                    showException.setText(ex.getMessage());                }
                displayTransaction.setText(currentAccount.toString());
                amountTextField.clear();
            }
        });
        gridPane.setAlignment(Pos.CENTER);
        numPadGridPane.setAlignment(Pos.CENTER);
        VBox vBox= new VBox(gridPane,numPadGridPane,hBox,vBoxDisplayMessages);
        vBox.setSpacing(10);
        
        borderPane.setCenter(vBox);
        
        
    }
    
    //setting deposit screen

    private void setUpDepositScreen() {

GridPane gridPane=new GridPane();
        Label depositLabel=new Label("Deposit ");
        depositLabel.setId("welcome-text");
        gridPane.add(depositLabel, 0, 0,2,1);
        Label amountLabel=new Label("Enter amount:");
        gridPane.add(amountLabel, 0, 2);
        TextField amountTextField= new TextField();
        amountTextField.editableProperty().set(false);
        gridPane.add(amountTextField, 1, 2);
        
        GridPane numPadGridPane=new GridPane();
        
        Button one=new Button("1");
        Button two=new Button("2");
        Button three=new Button("3");
        Button four=new Button("4");
        Button five=new Button("5");
        Button six=new Button("6");
        Button seven=new Button("7");
        Button eight=new Button("8");
        Button nine=new Button("9");
        Button zero=new Button("0");
        Button clear=new Button("  clear  ");
        
        
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(one.getText());            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(two.getText());            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(three.getText());            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(four.getText());            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(five.getText());            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(six.getText());            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(seven.getText());            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(eight.getText());            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(nine.getText());            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(zero.getText());            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.clear();            }
        });
        numPadGridPane.add(one, 0, 0);
        numPadGridPane.add(two, 1, 0);
        numPadGridPane.add(three, 2, 0);
        
        numPadGridPane.add(four, 0, 1);
        numPadGridPane.add(five, 1, 1);
        numPadGridPane.add(six, 2, 1);
        
        numPadGridPane.add(seven, 0, 2);
        numPadGridPane.add(eight, 1, 2);
        numPadGridPane.add(nine, 2, 2);
        
        numPadGridPane.add(zero, 0, 3);
        numPadGridPane.add(clear, 1, 3,2,1);
        numPadGridPane.setHgap(10); 
        numPadGridPane.setVgap(10); 
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        Label displayTransaction=new Label(currentAccount.toString());
        Label showDeposit=new Label();
        VBox vBoxDisplayMessages=new VBox(displayTransaction,showDeposit);
        vBoxDisplayMessages.setAlignment(Pos.CENTER);
        Button enter= new Button("Enter");
        HBox hBox=new HBox(enter);
        hBox.setAlignment(Pos.CENTER);
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String amount=amountTextField.getText();
                Double depositAmount=Double.parseDouble(amount);
                
                    showDeposit.setText(currentAccount.makeAccountDeposit(depositAmount));                
                displayTransaction.setText(currentAccount.toString());
                amountTextField.clear();
            }
        });
        gridPane.setAlignment(Pos.CENTER);
        numPadGridPane.setAlignment(Pos.CENTER);
        VBox vBox= new VBox(gridPane,numPadGridPane,hBox,vBoxDisplayMessages);
        vBox.setSpacing(10);
        
        borderPane.setCenter(vBox);
        
        
    }
    
    //Seting calculate interest
    
    private void setUpCalculateInterestScreen() {
        
        currentAccount.setInterestRate();
        currentAccount.calculateInterest();
        String interest=Double.toString(currentAccount.interestRate);
        Label interestRateLabel=new Label("Interest aplied to this account is: "+interest);
        Label accBalanceWithInterestRate=new Label(currentAccount.toString());
        VBox vBox=new VBox(interestRateLabel,accBalanceWithInterestRate);
        vBox.setAlignment(Pos.CENTER);

        borderPane.setCenter(vBox);

    }
    
    //Seting calculate interest

    private void setUpDisplayBalanceScreen() {
        currentAccount.getBalance();
        String showBalance=Double.toString(currentAccount.balance);
        Label showBalanceLabel=new Label("Your balance in this account is this : "+showBalance);
        VBox vBox=new VBox(showBalanceLabel);
        vBox.setAlignment(Pos.CENTER);


        borderPane.setCenter(vBox);
        //borderPane.setBottom(hBox);

    }
    
    //seting change limit for savings account

    private void setUpChangeWithdrawLimitScreen() {
        
        


        GridPane gridPane=new GridPane();
        Label changeLimitLabel=new Label("Change withdrawal limit ");
        changeLimitLabel.setId("welcome-text");
        gridPane.add(changeLimitLabel, 0, 0,2,1);
        Label amountLabel=new Label("Set the new limit:");
        gridPane.add(amountLabel, 0, 2);
        TextField amountTextField= new TextField();
        amountTextField.editableProperty().set(false);
        gridPane.add(amountTextField, 1, 2);
        
        GridPane numPadGridPane=new GridPane();
        
        Button one=new Button("1");
        Button two=new Button("2");
        Button three=new Button("3");
        Button four=new Button("4");
        Button five=new Button("5");
        Button six=new Button("6");
        Button seven=new Button("7");
        Button eight=new Button("8");
        Button nine=new Button("9");
        Button zero=new Button("0");
        Button clear=new Button("  clear  ");
        
        
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(one.getText());            }
        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(two.getText());            }
        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(three.getText());            }
        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(four.getText());            }
        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(five.getText());            }
        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(six.getText());            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(seven.getText());            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(eight.getText());            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(nine.getText());            }
        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.appendText(zero.getText());            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amountTextField.clear();            }
        });
        numPadGridPane.add(one, 0, 0);
        numPadGridPane.add(two, 1, 0);
        numPadGridPane.add(three, 2, 0);
        
        numPadGridPane.add(four, 0, 1);
        numPadGridPane.add(five, 1, 1);
        numPadGridPane.add(six, 2, 1);
        
        numPadGridPane.add(seven, 0, 2);
        numPadGridPane.add(eight, 1, 2);
        numPadGridPane.add(nine, 2, 2);
        
        numPadGridPane.add(zero, 0, 3);
        numPadGridPane.add(clear, 1, 3,2,1);
        numPadGridPane.setHgap(10); 
        numPadGridPane.setVgap(10); 
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        Label displayTransaction=new Label(currentAccount.toString());
        displayTransaction.setAlignment(Pos.CENTER);
        Label confirmationLabel=new Label();
        confirmationLabel.setAlignment(Pos.CENTER);
        
        Button enter= new Button("Enter");
        HBox hBox=new HBox(enter);
        hBox.setAlignment(Pos.CENTER);
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SavingsAccount savings=(SavingsAccount)currentAccount;
                String limit=amountTextField.getText();
                Double changeLimit=Double.parseDouble(limit);
                savings.setLimit(changeLimit);
                amountTextField.clear();
                confirmationLabel.setText("Thanks your limit "+changeLimit+" has succesfully being changed");
                
            }
        });
        gridPane.setAlignment(Pos.CENTER);
        numPadGridPane.setAlignment(Pos.CENTER);
        VBox vBox= new VBox(gridPane,numPadGridPane,hBox,displayTransaction,confirmationLabel);
        vBox.setSpacing(10);
        
        borderPane.setCenter(vBox);
        
    }

    
}

    