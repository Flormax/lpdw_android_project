package lol.meteoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 18/04/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper sInstance;

    private static final String DB_NAME = "myApp.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_CITIES = "cities";
    private static final String KEY_CITIES_ID = "id";
    private static final String KEY_CITIES_NAME = "name";
    private static final String KEY_CITIES_COUNTRY = "country";

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CITIES_TABLE = "CREATE TABLE " + TABLE_CITIES +
                "(" +
                KEY_CITIES_ID + " INTEGER PRIMARY KEY," +
                KEY_CITIES_NAME + " TEXT," +
                KEY_CITIES_COUNTRY + " TEXT" +
                ")";

        db.execSQL(CREATE_CITIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
            onCreate(db);
        }
    }

    public void addCity(MyCity myCity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CITIES_NAME, myCity.name);
        values.put(KEY_CITIES_COUNTRY, myCity.CountryCode);

        // Inserting Row
        db.insert(TABLE_CITIES, null, values);
        db.close();
    }

    public List<MyCity> getAllCities() {
        List<MyCity> myCityList = new ArrayList<MyCity>();
        String selectQuery = "SELECT  * FROM " + TABLE_CITIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MyCity myCity = new MyCity(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
                myCityList.add(myCity);
            } while (cursor.moveToNext());
        }

        db.close();
        return myCityList;
    }

    public void deleteCity(MyCity myCity) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CITIES, KEY_CITIES_ID + " = ?",
                new String[] { String.valueOf(myCity.id) });
        db.close();
    }
}