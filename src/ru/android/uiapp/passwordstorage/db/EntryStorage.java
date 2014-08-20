package ru.android.uiapp.passwordstorage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * User: maslyanko
 * Date: 20.08.14
 * Time: 12:34
 */
public class EntryStorage implements IEntryStorage {

    private static final int ATTEMPTS_TO_ENTRY = 10;
    private static final String DB_NAME = "dbSafeEntry";
    private static final int DB_VERSION = 1;

    private static final String ENTRANCE_TABLE_TITLE = "entrance";
    private static final String ID_COLUMN_NAME = "_id";
    private static final String MD5_COLUMN_NAME = "secret_phrase";
    private static final String ATTEMPT_COLUMN_NAME = "attempt_amount";
    private static final String ENTRANCE_TABLE_SQL = "create table "
            + ENTRANCE_TABLE_TITLE + "(" + ID_COLUMN_NAME
            + " integer primary key autoincrement, " + MD5_COLUMN_NAME + " blob, " + ATTEMPT_COLUMN_NAME + " integer" +  ");";

    private final Context _activityContext;
    private ContextSqlLiteHelper _sqlLiteHelper;
    private SQLiteDatabase _db;

    public EntryStorage(Context context){
        _activityContext = context;
    }

    public void open(){
        String[] scripts = {ENTRANCE_TABLE_SQL};
        _sqlLiteHelper = new ContextSqlLiteHelper(_activityContext, DB_NAME, DB_VERSION, scripts);
        _db = _sqlLiteHelper.getWritableDatabase();
    }

    public void close(){
        if (_sqlLiteHelper != null)
            _sqlLiteHelper.close();
    }

    @Override
    public boolean isFirstTimeEntrance()
    {
        Cursor cr = _db.query(ENTRANCE_TABLE_TITLE, null, null, null, null, null, null);
        return !cr.moveToFirst();
    }

    @Override
    public byte[] getEncryptedPassword()
    {
        Cursor cr = _db.query(ENTRANCE_TABLE_TITLE, null, null, null, null, null, null);
        if(cr.moveToFirst())
            return cr.getBlob(cr.getColumnIndex(MD5_COLUMN_NAME));
        else
            return null;
    }

    @Override
    public int getAttemptsAmount()
    {
        Cursor cr = _db.query(ENTRANCE_TABLE_TITLE, null, null, null, null, null, null);
        if(cr.moveToFirst())
            return cr.getInt(cr.getColumnIndex(ATTEMPT_COLUMN_NAME));
        else
            return 0;
    }

    @Override
    public void updateAttemptsAmount(int attemptsAmount)
    {
        ContentValues cv = new ContentValues();
        cv.put(ATTEMPT_COLUMN_NAME, attemptsAmount);
        _db.update(ENTRANCE_TABLE_TITLE, cv, null, null);
    }

    @Override
    public void freeMd5Password(byte[] funnyNewPassword)
    {
        ContentValues cv = new ContentValues();
        //you can try
        cv.put(ATTEMPT_COLUMN_NAME, 10000);
        cv.put(MD5_COLUMN_NAME, funnyNewPassword);
        _db.update(ENTRANCE_TABLE_TITLE, cv, null, null);
    }

    @Override
    public void restoreAttemptsAmount()
    {
        ContentValues cv = new ContentValues();
        cv.put(ATTEMPT_COLUMN_NAME, ATTEMPTS_TO_ENTRY);
        _db.update(ENTRANCE_TABLE_TITLE, cv, null, null);

    }

    @Override
    public void setPasswordFirstTime(byte[] password)
    {
        ContentValues values = new ContentValues();

        values.put(MD5_COLUMN_NAME, password);
        values.put(ATTEMPT_COLUMN_NAME, ATTEMPTS_TO_ENTRY);
        _db.insert(ENTRANCE_TABLE_TITLE, null, values);
    }
}
