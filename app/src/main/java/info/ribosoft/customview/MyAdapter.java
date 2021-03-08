package info.ribosoft.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// define the adapter to describe the process of converting the Java object into a view
public class MyAdapter extends ArrayAdapter<ClassBankAccount> {

    public MyAdapter (Context context, ArrayList<ClassBankAccount> classBankAccounts) {
        super(context, 0, classBankAccounts);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        // check if an existing view is being reused, otherwise inflate the view
        if  (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user_bank,
                    parent, false);
        }

        // get the data item for this position
        ClassBankAccount classBankAccount = getItem(position);

        // lookup view for data population
        TextView textViewBankName = (TextView) convertView.findViewById(R.id.textViewBankName);
        TextView textViewInBalance = (TextView) convertView.findViewById(R.id.textViewInBalance);
        TextView textViewOutBalance = (TextView) convertView.findViewById(R.id.textViewOutBalance);

        // populate the data into the template view using the data object
        textViewBankName.setText(classBankAccount.getBankName());
        textViewInBalance.setText(classBankAccount.getInBalance());
        textViewOutBalance.setText(classBankAccount.getOutBalance());

        // return the completed view to render on screen
        return convertView;
    }
}
