package com.example.fitit_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nilofar on 1/26/2017.
 */
public class LoginPage extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText pass = (EditText) findViewById(R.id.pass);
        Button login = (Button) findViewById(R.id.login);
        Button register= (Button) findViewById(R.id.register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name == null || name.toString().contains("")) {
                    name.setBackgroundColor(3);
                    Toast.makeText(getApplicationContext(), "‰«„ ò«—»—? Ê«—œ ‰‘œÂ «” ", Toast.LENGTH_LONG).show();
                } else if (pass == null) {
                    pass.setBackgroundColor(3);
                    Toast.makeText(getApplicationContext(), "—„“ ⁄»Ê— Ê«—œ ‰‘œÂ «” ", Toast.LENGTH_LONG).show();
                }


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterForm.class);
                LoginPage.this.startActivity(intent);
//                        intent.putExtra("USER_INPUT", userIn   put);
//                        intent.putExtra("USER_AGE", userAge);

            }
        });
    }





}

