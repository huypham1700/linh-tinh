package validation;

import android.content.Context;
import android.text.TextUtils;

import com.example.practiceapp.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.User;
import sqlite.Database;

public class Validation {
    private static Pattern pattern;
    private static Matcher matcher;


    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    public static Boolean isValidUsername(String username){
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher=pattern.matcher(username);
        return (!TextUtils.isEmpty(username) && matcher.matches());
    }
    public static Boolean existedUser(String username, String password, Context context){
        Database db = new Database(context);
        User u = db.getLoggedUser(username,password);
        if (u!=null){
            return true;
        }
        return false;
    }
}
