package in.welldoc.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqliteHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "mvp_data";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SqliteHelper.class.getSimpleName();

    public SqliteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqliteTable.DB_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SqliteTable.DB_USER);
        onCreate(db);
    }

    public boolean insertData(String table, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);
        if (result == -1){
            Log.d(TAG, "failed to save data!");
            return false;
        }else{
            Log.d(TAG, "save data successful");
            return true;
        }
    }


    public int updateData(String table, ContentValues values,
                          String email){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(table, values,
                SqliteTable.COL_USER_EMAIL + " =? ",
                new String[]{email});
    }

    public User getUserDetail(String email){
        User user;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns={
                SqliteTable.COL_USER_ID,
                SqliteTable.COL_USER_FNAME,
                SqliteTable.COL_USER_LNAME,
                SqliteTable.COL_USER_DOB,
                SqliteTable.COL_USER_PHONE,
                SqliteTable.COL_USER_EMAIL,
                SqliteTable.COL_USER_PASSWORD
        };

        String selection = SqliteTable.COL_USER_EMAIL + " =? " ;
        String[] args={email};

        Cursor cursor = db.query(SqliteTable.TABLE_USER, columns,
                selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()){

            user = new User();
            user.setUser_id(cursor.getInt(0));
            user.setUser_fname(cursor.getString(1));
            user.setUser_lname(cursor.getString(2));
            user.setUser_dob(cursor.getString(3));
            user.setUser_phone(cursor.getString(4));
            user.setUser_email(cursor.getString(5));
            user.setUser_password(cursor.getString(6));

            return user;
        }

        return null;
    }


    public boolean  checkUser(String email, String pass){

        //columns to fetch
        String[] columns = {
                SqliteTable.COL_USER_ID
        };

        SQLiteDatabase db = this.getReadableDatabase();
        // validation
        String selection = SqliteTable.COL_USER_EMAIL + " =? " + " AND " +
                SqliteTable.COL_USER_PASSWORD + " =? ";

        //arguments
        String[] args = {email, pass};

        //query to user table
        Cursor cursor = db.query(SqliteTable.TABLE_USER,
                columns, //return
                selection, //where clause
                args, // value of the clause
                null,
                null,
                null);

        int count = cursor.getCount();
        cursor.close();
        db.close();
        if (count > 0){
            Log.d(TAG, "return true");
            return true;
        }

        return false;
    }


    public boolean deleteUser(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(SqliteTable.TABLE_USER, SqliteTable.COL_USER_EMAIL + " =? ",
                new String[]{email}) > 0;
    }

}
