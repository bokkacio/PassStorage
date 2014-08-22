package ru.android.uiapp.passwordstorage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import ru.android.uiapp.passwordstorage.R;
import ru.android.uiapp.passwordstorage.db.IEntryStorage;

/**
 * User: maslyanko
 * Date: 22.08.14
 * Time: 14:50
 */
public class Entrance extends Activity implements View.OnClickListener{
    private TextView _lblInfo;
    private TextView _lblAttemptsLeft;
    private Button _btnEntry;
    private EditText _txtPassword;
    private EditText _txtPasswordRepeat;

    private IEntryStorage _db;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enrtance);
    }

    private void initUiElements(){
        _lblInfo = (TextView) findViewById(R.id.lblInfo);
        _lblAttemptsLeft = (TextView) findViewById(R.id.lblAttemptsLeft);
        _txtPassword = (EditText)  findViewById(R.id.txtPassword);
        _txtPasswordRepeat = (EditText)  findViewById(R.id.txtPasswordRepeat);
        _btnEntry = (Button)  findViewById(R.id.btnEntry);

        _btnEntry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}