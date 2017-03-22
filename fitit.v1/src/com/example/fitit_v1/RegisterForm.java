package com.example.fitit_v1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import model.Person;

/**
 * Created by nilofar on 2/8/2017.
 */
public class RegisterForm extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerform);
        Button register= (Button) findViewById(R.id.btnRegist);
        final TextView name= (TextView) findViewById(R.id.name);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person=new Person();
                System.out.println("register name::"+name.toString());
                person.setName(name.getText().toString());
                boolean result= G.registerPerson(person);
                System.out.println("result::" + result);
            }
        });

    }
}
