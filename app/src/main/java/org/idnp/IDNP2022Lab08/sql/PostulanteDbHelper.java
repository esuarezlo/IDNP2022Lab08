package org.idnp.IDNP2022Lab08.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PostulanteDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Postulante_sql.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " +
            PostulanteEntry.TABLE_NAME + " (" +
            PostulanteEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            PostulanteEntry.COLUMN_NAME_FIRSTNAME + " TEXT," +
            PostulanteEntry.COLUMN_NAME_LASTNAME + " TEXT," +
            PostulanteEntry.COLUMN_NAME_SCHOOL + " TEXT," +
            PostulanteEntry.COLUMN_NAME_PROGRAMM + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PostulanteEntry.TABLE_NAME;

    public PostulanteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
