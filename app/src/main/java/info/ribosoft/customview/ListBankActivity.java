package info.ribosoft.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListBankActivity extends AppCompatActivity {
    private DBHelper myDBBankAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bank);

        ListView listViewListBank = (ListView) findViewById(R.id.listViewListBank);

        myDBBankAccount = new DBHelper(this);

        // fills the array with the data read from the table
        ArrayList<String> arrayListBank = myDBBankAccount.getListBankName();

        // initializes the adapter with the data from the array
        ArrayAdapter<String> arrayAdapterBank = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,arrayListBank);

        // associate the adapter with a listview
        listViewListBank.setAdapter(arrayAdapterBank);
    }
}