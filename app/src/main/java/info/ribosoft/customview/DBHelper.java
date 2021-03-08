package info.ribosoft.customview;

import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    // definition of the fields of the table
    private static final String DATABASE_NAME = "MyDBconto.db";
    public static final String CONTACTS_TABLE_NAME = "sqlSaldoConti";
    public static final String CONTACTS_COLUMN_ID = "idSaldoConti";
    public static final String CONTACTS_COLUMN_BANK_NAME = "NomeBanca";
    public static final String CONTACTS_COLUMN_OPEN_BALANCE = "SaldoIniziale";
    public static final String CONTACTS__COLUMN_INCOME_BALANCE = "SaldoEntrate";
    public static final String CONTACTS_COLUMN_EXPENCE_BALANSE = "SaldoUscite";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        // if the table does not exist it is created
        sqlDB.execSQL("CREATE TABLE " + CONTACTS_TABLE_NAME + "(" +
                CONTACTS_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                CONTACTS_COLUMN_BANK_NAME + " TEXT, " +
                CONTACTS_COLUMN_OPEN_BALANCE + " TEXT, " +
                CONTACTS__COLUMN_INCOME_BALANCE + " TEXT, " +
                CONTACTS_COLUMN_EXPENCE_BALANSE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int oldVersion, int newVersion) {
        // the necessary operations if the database needs to be updated
    }

    private Cursor openReadTable(SQLiteDatabase sqLiteDatabase, String stringSql) {
        // opens the database for reading
        sqLiteDatabase = this.getReadableDatabase();

        // performs a read sql query
        Cursor cursor = sqLiteDatabase.rawQuery(stringSql, null);

        // move the cursor to the first row
        cursor.moveToFirst();
        return cursor;
    }

    // inserts the name of the banks in the table into an array
    public ArrayList<String> getListBankName() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String stringCursor;

        SQLiteDatabase sqlDBSoldoConti = this.getReadableDatabase();

        // opens the database for reading and move the cursor to the first row
        Cursor cursor = openReadTable(sqlDBSoldoConti, "select * FROM " + CONTACTS_TABLE_NAME + " ORDER BY " + CONTACTS_COLUMN_BANK_NAME + " ASC");

        // returns whether the cursor is pointing to the position after the last row
        while (cursor.isAfterLast() == false) {
            // returns the value of the requested column as a string
            stringCursor = cursor.getString(cursor.getColumnIndex(CONTACTS_COLUMN_BANK_NAME));
            // add the string to the list
            arrayList.add(stringCursor);
            // move the cursor to the next row
            cursor.moveToNext();
        }
        return arrayList;
    }

    public ArrayList<ClassBankAccount> getAllBank() {
        ArrayList<ClassBankAccount> arrayListBankAccount = new ArrayList<ClassBankAccount>();
        String stringBankName, stringIncomeBalance, stringExpenseBalance;

        SQLiteDatabase sqlDBSoldoConti = this.getReadableDatabase();

        // opens the database for reading and move the cursor to the first row
        Cursor cursor = openReadTable(sqlDBSoldoConti, "select * FROM " + CONTACTS_TABLE_NAME + " ORDER BY " + CONTACTS_COLUMN_BANK_NAME + " ASC");

        while (cursor.isAfterLast() == false) {
            // returns the value of the requested column as a string
            stringBankName = cursor.getString(cursor.getColumnIndex(CONTACTS_COLUMN_BANK_NAME));
            stringIncomeBalance = cursor.getString(cursor.getColumnIndex(CONTACTS__COLUMN_INCOME_BALANCE));
            stringExpenseBalance = cursor.getString(cursor.getColumnIndex(CONTACTS_COLUMN_EXPENCE_BALANSE));

            //arrayList.add(stringCursor);

            // add the string to the list
            arrayListBankAccount.add(new ClassBankAccount(stringBankName, stringIncomeBalance, stringExpenseBalance));
            // move the cursor to the next row
            cursor.moveToNext();
        }
        return arrayListBankAccount;
    }

    public boolean insertNewBankAccount(String bankName, String openBalance, String incomeBalance, String expenseBalance) {
        // opens the database for writing
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        // creates an empty set of values using the default initial size
        ContentValues contentValues = new ContentValues();
        // adds a value to the set
        contentValues.put(CONTACTS_COLUMN_BANK_NAME, bankName);
        contentValues.put(CONTACTS_COLUMN_OPEN_BALANCE, openBalance);
        contentValues.put(CONTACTS__COLUMN_INCOME_BALANCE, incomeBalance);
        contentValues.put(CONTACTS_COLUMN_EXPENCE_BALANSE, expenseBalance);
        // insert the data into the database by passing a ContentValues object
        sqlDB.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }
}
