package in.welldoc.data.local;



public class SqliteTable {

   public static final String TABLE_USER = "register1";
 public static final String COL_USER_ID = " col_user_id";
 public static final String COL_USER_FNAME = " col_user_fname";
 public static final String COL_USER_LNAME = " col_user_lname";
 public static final String COL_USER_DOB = " col_user_dob";
 public static final String COL_USER_PHONE = " col_user_phone";
 public static final String COL_USER_EMAIL = " col_user_email";
 public static final String COL_USER_PASSWORD = " col_user_password";



 public static final String DB_USER = "CREATE TABLE " + TABLE_USER + "(" + COL_USER_ID + " INTEGER PRIMARY KEY, "
         + COL_USER_FNAME + " TEXT, " + COL_USER_LNAME + " TEXT, " + COL_USER_DOB + " TEXT, " + COL_USER_PHONE + " TEXT, "
         + COL_USER_EMAIL + " TEXT, " + COL_USER_PASSWORD + " TEXT " + " + COL_USER_PASSWORD + \" TEXT \" + \")";


}
