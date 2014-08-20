package ru.android.uiapp.passwordstorage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * User: maslyanko
 * Date: 20.08.14
 * Time: 15:00
 */
public class SecureCryptStorage implements IDatabaseHelper{

    private static final String DB_NAME = "dbSafe";
    private static final int DB_VERSION = 1;
    //private Scrambler _scrambler = null;

    private static final String ID_COLUMN_NAME = "_id";

    //Groups
    private static final String GROUP_TABLE_TITLE = "group";
    public static final String GROUP_COLUMN_NAME = "group_title";
    private static final String GROUP_TABLE_SQL = "create table "
            + GROUP_TABLE_TITLE + "(" + ID_COLUMN_NAME
            + " integer primary key autoincrement, " + GROUP_COLUMN_NAME + " text" + ");";

    //Elements
    private static final String ELEMENT_TABLE_TITLE = "element";
    public static final String ELEMENT_COLUMN_VALUE= "element_value";
    public static final String ELEMENT_COLUMN_GROUP = "group_id";
    private static final String ELEMENT_TABLE_SQL = "create table "
            + ELEMENT_TABLE_TITLE + " ( " + ID_COLUMN_NAME
            + " integer primary key autoincrement, " + ELEMENT_COLUMN_VALUE +  " text, " + ELEMENT_COLUMN_GROUP + " integer" + ");";

    private final Context _activityContext;
    private ContextSqlLiteHelper _sqlLiteHelper;
    private SQLiteDatabase _db;

    public SecureCryptStorage(Context context){
        _activityContext = context;
    }

    public void open() {
        String[] scripts = {GROUP_TABLE_SQL, ELEMENT_TABLE_SQL};
        _sqlLiteHelper = new ContextSqlLiteHelper(_activityContext, DB_NAME, DB_VERSION, scripts);
        _db = _sqlLiteHelper.getWritableDatabase();
    }

    public void close(){
        if (_sqlLiteHelper != null)
            _sqlLiteHelper.close();
    }
}
