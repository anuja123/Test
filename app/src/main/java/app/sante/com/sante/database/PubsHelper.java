package app.sante.com.sante.database;

/**
 * Created by User on 5/9/2015.
 */

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    public class PubsHelper {
        private static final int DATABASE_VERSION = 2;
        private static final String DATABASE_NAME = "Sante1.db";
        private static final String TABLE_NAME = "pubs1";
        public static final String PUBS_COLUMN_NAME = "Name";
        public static final String PUBS_COLUMN_COSTSYMBOL = "Cost_Symbol";
        Pubs openHelper;
        private SQLiteDatabase database;

        public PubsHelper(Context context){
            openHelper = new Pubs(context);
            database = openHelper.getWritableDatabase();
        }
        public void savePubRecord(String name, String cstSymbol) {
            ContentValues contentValues = new ContentValues();
            System.out.println("VALUSES ARE : " + name + cstSymbol );
            contentValues.put(PUBS_COLUMN_NAME, name);
            contentValues.put(PUBS_COLUMN_COSTSYMBOL, cstSymbol);
            database.insert(TABLE_NAME, null, contentValues);
        }
        public Cursor getTimeRecordList() {
            return database.rawQuery("select * from " + TABLE_NAME, null);
        }
        private class Pubs extends SQLiteOpenHelper {

            public Pubs(Context context) {
                // TODO Auto-generated constructor stub
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                // TODO Auto-generated method stub
                db.execSQL("CREATE TABLE " + TABLE_NAME + "( "
                        + PUBS_COLUMN_NAME + " TEXT(100), "
                        + PUBS_COLUMN_COSTSYMBOL + " TEXT(100) );" );
               // System.out.println("Creating databasesssssssssssss \n");

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // TODO Auto-generated method stub
                db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
                onCreate(db);
            }

        }
    }


