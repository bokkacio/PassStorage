package ru.android.uiapp.passwordstorage.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ru.android.uiapp.passwordstorage.R;
import ru.android.uiapp.passwordstorage.uilogic.SourceManager;

/**
 * User: maslyanko
 * Date: 02.09.14
 * Time: 11:41
 */
public class RemoveElement extends Activity implements View.OnClickListener{
    private TextView _lblInfo;
    private Button _btnElementRemove;
    private Button _btnElementRefuseRemove;

    private Resources _source = getResources();
    private long _groupId;
    private long _elementId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        initUiElements();

        _lblInfo.setText(SourceManager.getSourceString(_source, R.string.remove_confirmation));

        Intent intent = getIntent();
        _groupId = intent.getLongExtra(ActivityVariable.GROUP_ID, ActivityVariable.DEFAULT_ID);
        _elementId = intent.getLongExtra(ActivityVariable.ELEMENT_ID, ActivityVariable.DEFAULT_ID);
    }

    private void initUiElements(){
        _lblInfo = (TextView) findViewById(R.id.lblDialogText);
        _btnElementRemove = (Button) findViewById(R.id.btnRemove);
        _btnElementRefuseRemove = (Button) findViewById(R.id.btnRefuseRemove);

        _btnElementRemove.setOnClickListener(this);
        _btnElementRefuseRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnRemove:
            {
                Intent intent = new Intent();
                intent.putExtra(ActivityVariable.GROUP_ID, _groupId);
                intent.putExtra(ActivityVariable.ELEMENT_ID, _elementId);
                intent.putExtra(ActivityVariable.IS_REMOVE, true);
                setResult(RESULT_OK, intent);
                finish();
                break;
            }
            case R.id.btnRefuseRemove:
            {
                Intent intent = new Intent();
                intent.putExtra(ActivityVariable.GROUP_ID, _groupId);
                intent.putExtra(ActivityVariable.ELEMENT_ID, _elementId);
                intent.putExtra(ActivityVariable.IS_REMOVE, false);
                setResult(RESULT_CANCELED, intent);
                finish();
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, EventCodes.CLOSE_APP, 0, SourceManager.getSourceString(_source, R.string.menu_exit));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case EventCodes.CLOSE_APP:
                setResult(EventCodes.CLOSE_APP);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}