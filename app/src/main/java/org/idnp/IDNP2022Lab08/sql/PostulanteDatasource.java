package org.idnp.IDNP2022Lab08.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.io.File;

public class PostulanteDatasource {
    private static final String TAG = "PostulanteDatasource";
    private PostulanteDbHelper dbHelper;

    public PostulanteDatasource(Context context) {
        SQLiteDatabase db;
        File storagePath = context.getFilesDir();
        String dbPath = storagePath + "/" + "postulante";
        try {
            db = SQLiteDatabase.openDatabase(dbPath, null,
                    SQLiteDatabase.CREATE_IF_NECESSARY);

            dbHelper = new PostulanteDbHelper(context);
            dbHelper.onCreate(db);
            db.close();
        } catch (SQLiteException e) {
           Log.e(TAG, e.getMessage());
        }
    }

    public void insert(int id, String firstname, String lastname, String school, String program) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PostulanteEntry.COLUMN_NAME_ID, id);
        values.put(PostulanteEntry.COLUMN_NAME_FIRSTNAME, firstname);
        values.put(PostulanteEntry.COLUMN_NAME_LASTNAME, lastname);
        values.put(PostulanteEntry.COLUMN_NAME_SCHOOL, school);
        values.put(PostulanteEntry.COLUMN_NAME_PROGRAMM, program);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(PostulanteEntry.TABLE_NAME, null, values);
    }

    public Cursor findById(String programm){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                PostulanteEntry.COLUMN_NAME_ID, //BaseColumns._ID,
                PostulanteEntry.COLUMN_NAME_FIRSTNAME,
                PostulanteEntry.COLUMN_NAME_LASTNAME,
                PostulanteEntry.COLUMN_NAME_SCHOOL
        };

        // Filter results WHERE "programm" = 'programm'
        String selection = PostulanteEntry.COLUMN_NAME_PROGRAMM + " = ?";
        String[] selectionArgs = { programm };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                PostulanteEntry.COLUMN_NAME_LASTNAME + " DESC";

        Cursor cursor = db.query(
                PostulanteEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        return cursor;
    }

    public Cursor findAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                PostulanteEntry.COLUMN_NAME_ID, //BaseColumns._ID,
                PostulanteEntry.COLUMN_NAME_FIRSTNAME,
                PostulanteEntry.COLUMN_NAME_LASTNAME,
                PostulanteEntry.COLUMN_NAME_SCHOOL,
                PostulanteEntry.COLUMN_NAME_PROGRAMM
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                PostulanteEntry.COLUMN_NAME_LASTNAME + " DESC";

        Cursor cursor = db.query(
                PostulanteEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        return cursor;
    }
}
