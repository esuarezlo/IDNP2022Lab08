package org.idnp.IDNP2022Lab08.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.idnp.IDNP2022Lab08.entity.Person;

import java.util.List;


@Dao
public interface PersonDao {
    @Insert
    public void insertar(Person person);

    @Update
    public void actualizar(Person person);

    @Delete
    public void eliminar(Person person);

    @Query("select * from persona")
    public List<Person> personas();
}
