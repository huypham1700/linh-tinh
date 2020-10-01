package sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import model.UserEntry;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbGames";
    public static final int DATABASE_VERSION = 1;
    public static final String SQL_CREATE_ENTRIES ="CREATE TABLE tblUser("+ UserEntry.COLUMN_USERNAME +" VARCHAR(300),"
            + UserEntry.COLUMN_PASSWORD + " VARCHAR(300),"
            + UserEntry.COLUMN_TOKEN_KEY + " VARCHAR(300))";
    public DBHelper(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context,
                    @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                    int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME , null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(SQL_CREATE_ENTRIES);}
    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
