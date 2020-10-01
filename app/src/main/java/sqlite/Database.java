package sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import model.User;
import model.UserEntry;

public class Database {
    public static String TAG = "Database";
    private Context context;
    private SQLiteDatabase db;
    private DBHelper helper;
    public Database(Context context){
        this.context=context;
        this.helper= new DBHelper(context);
    }
    public void insertUser(String username, String password, String tokenKey){
        this.db = this.helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserEntry.COLUMN_USERNAME,username);
        contentValues.put(UserEntry.COLUMN_PASSWORD,password);
        contentValues.put(UserEntry.COLUMN_TOKEN_KEY,tokenKey);
        db.insert(UserEntry.TABLE_NAME, null,contentValues);
    }
    public User getLoggedUser(String user, String pass){
        SQLiteDatabase db = helper.getReadableDatabase();
        try{
            String[] columns ={UserEntry.COLUMN_USERNAME,UserEntry.COLUMN_PASSWORD,UserEntry.COLUMN_TOKEN_KEY};
            Cursor cursor = db.query(
                    UserEntry.TABLE_NAME,
                    columns,
                    null,null,null,null,null
            );
            while(cursor.moveToNext()){
                String username = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_USERNAME));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_PASSWORD));
                String tokenKey = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_TOKEN_KEY));
                User foundUser = new User(username,password,tokenKey);
                if(foundUser.getUsername().equals(user) && foundUser.getPassword().equals(pass))
                    return foundUser;
            }
            return null;
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

    }
}
