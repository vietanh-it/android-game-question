/*
 * Copyright (c) 2014. <a href="http://facebook.com/vietanh.sgu">Viet Anh</a>.
 */

package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String dbName = "QuestionGame";
    static final int dbVersion = 1;
    static final String tableUser = "Users";
    static final String colUserID = "UserID";
    static final String colUserName = "UserName";

    static final String tableScore = "Scores";
    static final String colScore = "Score";

    public DatabaseHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableUser + "(" + colUserID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colUserName + " TEXT");

        db.execSQL("CREATE TABLE " + tableScore + "(" + colUserID + " INTEGER PRIMARY KEY, " +
                colScore + " INTEGER");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableScore);
        db.execSQL("DROP TABLE IF EXISTS " + tableUser);

        onCreate(db);
    }
}
