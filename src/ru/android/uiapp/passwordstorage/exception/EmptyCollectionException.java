package ru.android.uiapp.passwordstorage.exception;

import android.database.sqlite.SQLiteDatabase;

/**
 * User: maslyanko
 * Date: 20.08.14
 * Time: 11:26
 */
public class EmptyCollectionException extends Exception {
    public  EmptyCollectionException(){
    }

    public  EmptyCollectionException(String message){
        super(message);
    }
}
