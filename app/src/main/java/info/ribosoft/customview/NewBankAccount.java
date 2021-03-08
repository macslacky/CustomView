package info.ribosoft.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewBankAccount extends AppCompatActivity {
    private DBHelper myDBBankAccount;
    private EditText editTextBankName, editTextOpenBalance, editTextInBalance, editTextOutBalance;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bank_account);

        editTextBankName = (EditText) findViewById(R.id.editTextBankName);
        editTextOpenBalance = (EditText) findViewById(R.id.editTextTextOpenBalance);
        editTextInBalance = (EditText) findViewById(R.id.editTextTextInBalance);
        editTextOutBalance = (EditText) findViewById(R.id.editTextTextOutBalance);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDBBankAccount = new DBHelper(getApplicationContext());
                // insert the data into the database
                myDBBankAccount.insertNewBankAccount(editTextBankName.getText().toString(),
                        editTextOpenBalance.getText().toString(),
                        editTextInBalance.getText().toString(),
                        editTextOutBalance.getText().toString());

                // back to main activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}