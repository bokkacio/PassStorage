package ru.android.uiapp.passwordstorage.uilogic;

/**
 * User: maslyanko
 * Date: 25.08.14
 * Time: 14:27
 */
public final class ActionResult {
    private final boolean _isValid;
    private final int _resultCode;

    public final static int DEFAULT_RESULT_CODE = -1;

    ActionResult(boolean isValid, int resultCode){
        _isValid = isValid;
        _resultCode = resultCode;
    }

    public boolean isValid(){
        return _isValid;
    }

    public int getResultCode(){
        return _resultCode;
    }
}
