package ru.android.uiapp.passwordstorage.db;

/**
 * User: maslyanko
 * Date: 20.08.14
 * Time: 14:52
 */
public interface IEntryStorage extends IDatabaseHelper {
    boolean isFirstTimeEntrance();
    byte[] getEncryptedPassword();
    int getAttemptsAmount();
    void updateAttemptsAmount(int attemptsAmount);
    void freeMd5Password(byte[] funnyNewPassword);
    void restoreAttemptsAmount();
    void setPasswordFirstTime(byte[] password);
}
