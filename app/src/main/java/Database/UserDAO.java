package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

public class UserDAO {
    private SQLiteDatabase database;
    private Database dbHelper;
    private String[] allColumns = {Database.COLUMN_ID, Database.COLUMN_NAME, Database.COLUMN_SCORE};

    public UserDAO(Context context) {
        dbHelper = new Database(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public UserObject createUser(String name, int score) {
        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_NAME, name);
        values.put(Database.COLUMN_SCORE, score);

        long insertID = database.insert(Database.TABLE_USER, null, values);
        Cursor cursor = database.query(Database.TABLE_USER, allColumns, Database.COLUMN_ID + " = " + insertID, null, null, null, null);
        cursor.moveToFirst();
        UserObject newUser = cursorToUser(cursor);
        cursor.close();
        return newUser;
    }

    private UserObject cursorToUser(Cursor cursor) {
        return null;
    }
}
