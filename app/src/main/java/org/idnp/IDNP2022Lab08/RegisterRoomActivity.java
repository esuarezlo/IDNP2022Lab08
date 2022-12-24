package org.idnp.IDNP2022Lab08;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.idnp.IDNP2022Lab08.entity.Person;
import org.idnp.IDNP2022Lab08.room.Datasource;

import java.util.List;

public class RegisterRoomActivity extends AppCompatActivity {
    private static final String TAG = "RegisterRoomActivity";
    private Datasource datasource;
    private EditText edtId;
    private EditText edtFirstname;
    private EditText edtLastname;
    private EditText edtSchool;
    private EditText edtProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_room);

        datasource = Datasource.newInstance(getApplicationContext());

        Button btnSave = findViewById(R.id.btnSave2);
        Button btnRead = findViewById(R.id.btnRead2);
        edtId = findViewById(R.id.edtId2);
        edtFirstname = findViewById(R.id.edtFirstname2);
        edtLastname = findViewById(R.id.edtLastname2);
        edtSchool = findViewById(R.id.edtSchool2);
        edtProgram = findViewById(R.id.edtProgram2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {
                        datasource.personDao().insertar(getPerson());
                    }
                }).start();

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        List<Person> persons = datasource.personDao().personas();
                        for (Person p : persons
                        ) {
                            Log.d(TAG, p.toString());
                        }
                    }
                }).start();

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
}