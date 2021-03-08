package info.ribosoft.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BalanceBankActivity extends AppCompatActivity {
    private DBHelper myDBBankAccount;
    private ListView listViewBalanceBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_bank);

        listViewBalanceBank = (ListView) findViewById(R.id.listViewBalanceBank);

        myDBBankAccount = new DBHelper(this);

        ArrayList<ClassBankAccount> arrayListBankAccount = new ArrayList<ClassBankAccount>();

        arrayListBankAccount = myDBBankAccount.getAllBank();

        MyAdapter myAdapter = new MyAdapter(this, arrayListBankAccount);

        listViewBalanceBank.setAdapter(myAdapter);
    }
}