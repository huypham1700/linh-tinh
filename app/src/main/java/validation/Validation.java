package validation;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sqlite.Database;
import user.User;

public class Validation {
    private static Pattern pattern;
    private static Matcher matcher;
    private static Database db;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    public static Boolean isValidUsername(String username){
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher=pattern.matcher(username);
        return (!TextUtils.isEmpty(username) && matcher.matches());
    }
    public static Boolean existedUser(String username, String password ){
        if (db.getLoggedUser(username,password)!=null){
            return true;
        }
        return false;
    }
}
