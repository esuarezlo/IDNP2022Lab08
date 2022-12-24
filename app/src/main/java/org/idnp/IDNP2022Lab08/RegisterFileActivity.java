package org.idnp.IDNP2022Lab08;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.idnp.IDNP2022Lab08.entity.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class RegisterFileActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtFirstname;
    private EditText edtLastname;
    private EditText edtSchool;
    private EditText edtProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_file);

        Button btnPublicStorage = findViewById(R.id.btnPublicStorage);
        Button btnPrivateStorage = findViewById(R.id.btnPrivateStorage);

        edtId = findViewById(R.id.edtId3);
        edtFirstname = findViewById(R.id.edtFirstname3);
        edtLastname = findViewById(R.id.edtLastname3);
        edtSchool = findViewById(R.id.edtSchool3);
        edtProgram = findViewById(R.id.edtProgram3);

        btnPublicStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnPrivateStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePrivateStorage();
            }
        });

    }

    public void savePrivateStorage() {
        File file_private_internal = new File(getApplicationContext().getFilesDir(), "f2_persona_specific_internal.txt");
        File file_private_external = new File(getApplicationContext().getExternalFilesDir(null), "f2_persona_specific_external.txt");
        try {
            OutputStream osInternal = new FileOutputStream(file_private_internal);
            osInternal.write(getPerson().getBytes());
            osInternal.close();

            OutputStream osExternal = new FileOutputStream(file_private_external);
            osExternal.write(getPerson().getBytes());
            osExternal.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getPerson() {
        Person person = new Person();
        person.setId(Integer.parseInt(edtId.getText().toString()));
        person.setFirstname(edtFirstname.getText().toString());
        person.setLastname(edtLastname.getText().toString());
        person.setSchool(edtSchool.getText().toString());
        person.setProgram(edtProgram.getText().toString());

        return person.toString();
    }
}