package org.idnp.IDNP2022Lab08.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.idnp.IDNP2022Lab08.entity.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class Datasource extends RoomDatabase {
    private static Datasource datasourceInstance;
    public abstract PersonDao personDao();

    public static Datasource newInstance(Context context) {
        if (datasourceInstance == null) {
            datasourceInstance = Room.databaseBuilder(
                    context,
                    Datasource.class,
                    "database_room").build();

        }
        return datasourceInstance;
    }

}
