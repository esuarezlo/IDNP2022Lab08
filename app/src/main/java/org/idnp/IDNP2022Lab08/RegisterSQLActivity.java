package org.idnp.IDNP2022Lab08;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.idnp.IDNP2022Lab08.adapter.PersonAdapter;
import org.idnp.IDNP2022Lab08.entity.Person;
import org.idnp.IDNP2022Lab08.sql.PostulanteDatasource;

import java.util.ArrayList;
import java.util.List;

public class RegisterSQLActivity extends AppCompatActivity {

    private static final String TAG = "RegisterSQLActivity";
    private PostulanteDatasource datasource;
    private PersonAdapter adapter;
    private List<Person> persons;
    private EditText edtId;
    private EditText edtFirstname;
    private EditText edtLastname;
    private EditText edtSchool;
    private EditText edtProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_sql);

        datasource = new PostulanteDatasource(getApplicationContext());
        RecyclerView personsRView = findViewById(R.id.rvSqlite);
        Button btnSave = findViewById(R.id.btnSave1);
        Button btnRead = findViewById(R.id.btnRead1);
        edtId = findViewById(R.id.edtId1);
        edtFirstname = findViewById(R.id.edtFirstname1);
        edtLastname = findViewById(R.id.edtLastname1);
        edtSchool = findViewById(R.id.edtSchool1);
        edtProgram = findViewById(R.id.edtProgram1);

        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        persons = new ArrayList<>();
        adapter = new PersonAdapter(persons);
        personsRView.setLayoutManager(new LinearLayoutManager(this));
        personsRView.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(getPerson());
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btnRead");
                read();
                adapter.notifyDataSetChanged();
            }
        });

    }

    private Person getPerson() {
        Person person = new Person();
        person.setId(Integer.parseInt(edtId.getText().toString()));
        person.setFirstname(edtFirstname.getText().toString());
        person.setLastname(edtLastname.getText().toString());
        person.setSchool(edtSchool.getText().toString());
        person.setProgram(edtProgram.getText().toString());

        return person;
    }

    private void write(Person person) {
        datasource.insert(person.getId(),
                person.getFirstname(),
                person.getLastname(),
                person.getSchool(),
                person.getProgram());
    }

    private List<Person> read() {
        //List<Person> persons = new ArrayList<>();
        Cursor cursor = datasource.findAll();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String firstname = cursor.getString(1);
            String lastname = cursor.getString(2);
            String school = cursor.getString(3);
            String program = cursor.getString(4);

            Person person = new Person();
            person.setId(id);
            person.setFirstname(firstname);
            person.setLastname(lastname);
            person.setSchool(school);
            person.setProgram(program);

            persons.add(person);

            Log.d(TAG, person.toString());
        }

        return persons;
    }
}