package ru.android.uiapp.passwordstorage.file;

/**
 * User: maslyanko
 * Date: 22.08.14
 * Time: 14:25
 */
public interface IPermanentStorage {
    String savePasswordsToFile();
    String importPasswordsFromFile();
}
