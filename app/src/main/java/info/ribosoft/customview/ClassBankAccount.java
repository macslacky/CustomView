package info.ribosoft.customview;

import android.util.Log;

import java.util.ArrayList;

// create the custom class for the adapter
public class ClassBankAccount {
    String stringBankName;
    String stringInBalance;
    String stringOutBalance;

    // set the fields
    public ClassBankAccount (String stringBankName, String stringInBalance, String stringOutBalance) {
        this.stringBankName = stringBankName;
        this.stringInBalance = stringInBalance;
        this.stringOutBalance = stringOutBalance;
    }

    // reads the fiels
    public String getBankName () {return stringBankName;}

    // sets the field
    public void setStringBankName () {this.stringBankName = stringBankName;}

    // reads the fiels
    public String getInBalance () {return stringInBalance;}

    // sets the field
    public void setInBalance () {this.stringInBalance = stringInBalance;}

    // reads the fiels
    public String getOutBalance () {return stringOutBalance;}

    // sets the field
    public void setOutBalance () {this.stringOutBalance = stringOutBalance;}
}
