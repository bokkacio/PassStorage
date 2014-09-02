package ru.android.uiapp.passwordstorage.uilogic;

import android.content.res.Resources;

/**
 * User: maslyanko
 * Date: 01.09.14
 * Time: 15:05
 */
public final class SourceManager {
    public static String getSourceString(Resources source, int sourceId){
        return source.getString(sourceId);
    }
}
