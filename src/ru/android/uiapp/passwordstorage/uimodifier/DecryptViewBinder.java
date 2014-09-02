package ru.android.uiapp.passwordstorage.uimodifier;

import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;
import ru.android.uiapp.passwordstorage.encryption.IScrambler;
import ru.android.uiapp.passwordstorage.encryption.Scrambler;

/**
 * User: maslyanko
 * Date: 22.08.14
 * Time: 10:03
 */
public class DecryptViewBinder implements SimpleCursorTreeAdapter.ViewBinder {
    private IScrambler _scrambler = null;

    public DecryptViewBinder(String password)
    {
        _scrambler = new Scrambler(password);
    }

    public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
        if(view instanceof TextView) {
            TextView tv = (TextView) view;
            String encryptedText = cursor.getString(columnIndex);
            tv.setText(_scrambler.decrypt(encryptedText));
            return true;
        }
        return false;
    }
}
