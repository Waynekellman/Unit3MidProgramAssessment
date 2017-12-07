package com.nyc.unit3midprogramassessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private CheckBox save;
    private Button login;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getApplicationContext().getSharedPreferences("key", MODE_PRIVATE);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        save = findViewById(R.id.save);
        login = findViewById(R.id.login);

        if(sharedPreferences.getBoolean("checked",false)){
            email.setText(sharedPreferences.getString("email",null));
            password.setText(sharedPreferences.getString("password", null));
            save.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(save.isChecked()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email",email.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("checked", true);
                    editor.commit();
                }

                if(email.getText().toString().equals("user@aol.com")&&password.getText().toString().equals("password1234")){
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
