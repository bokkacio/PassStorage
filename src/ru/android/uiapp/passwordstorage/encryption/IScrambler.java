package ru.android.uiapp.passwordstorage.encryption;

/**
 * User: maslyanko
 * Date: 22.08.14
 * Time: 9:34
 */
public interface IScrambler {
    String encrypt(String secretPhrase);
    String decrypt(String encryptedPhrase);
}
