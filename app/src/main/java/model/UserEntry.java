package model;

import android.provider.BaseColumns;

public class UserEntry implements BaseColumns {
    public static String TABLE_NAME         ="tblUser";
    public static String COLUMN_USERNAME       = "username";
    public static String COLUMN_PASSWORD    ="password";
    public static String COLUMN_TOKEN_KEY    ="tokenKey";
}
