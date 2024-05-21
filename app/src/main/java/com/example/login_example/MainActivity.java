package com.example.login_example;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText etUsername;
        EditText etPassword;
        Button btnSave;

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSave = findViewById(R.id.btn1);

        manager = SQLiteManager.instanceOfDatabase(MainActivity.this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (manager.readUserFromDB(etUsername.getText().toString(), etPassword.getText().toString())){
                Toast.makeText(MainActivity.this, "loged in", Toast.LENGTH_LONG).show();
            }


            }

        });
    }
}