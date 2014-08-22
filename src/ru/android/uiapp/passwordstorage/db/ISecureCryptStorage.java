package ru.android.uiapp.passwordstorage.db;

import android.database.Cursor;

/**
 * User: maslyanko
 * Date: 22.08.14
 * Time: 12:23
 */
public interface ISecureCryptStorage extends IDatabaseHelper {
    Cursor getGroupData();

    Cursor getElementData(long groupID);

    void insertElement(Long elementGroupId, String elementTitle, String elementValue);

    void insertGroup(String groupValue);

    long insertGroupResult(String groupValue);

    void deleteGroup(Long groupId);

    void deleteElement(Long elementId);
}
