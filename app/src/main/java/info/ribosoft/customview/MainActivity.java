package info.ribosoft.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonNewBank, buttonListBank, buttonBalanceBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNewBank = (Button) findViewById(R.id.buttonNewBank);
        buttonNewBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewBankAccount.class);
                startActivity(intent);
            }
        });

        buttonListBank = (Button) findViewById(R.id.buttonListBank);
        buttonListBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ListBankActivity.class);
                startActivity(intent);
            }
        });

        buttonBalanceBank = (Button) findViewById(R.id.buttonBalanceBank);
        buttonBalanceBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BalanceBankActivity.class);
                startActivity(intent);
            }
        });
    }
}