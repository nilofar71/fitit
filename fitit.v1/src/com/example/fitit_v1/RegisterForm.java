package com.example.fitit_v1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.fitit_v1.data.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import model.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nilofar on 2/8/2017.
 */
public class RegisterForm extends Activity {
    private DatabaseHelper databaseHelper = null;
    private List<Person> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerform);
        Button register = (Button) findViewById(R.id.btnRegist);
        final TextView name = (TextView) findViewById(R.id.name);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Person person=new Person();
//                System.out.println("register name::"+name.toString());
//                person.setName(name.getText().toString());
//                boolean result= G.registerPerson(person);
//                System.out.println("result::" + result);
                final Person stuDetails = new Person();
                stuDetails.name = "nilofar";
//                stuDetails.address = address_et.getText().toString();

                final Dao<Person, Integer> studentDao;
                try {
                    studentDao = getHelper().getPersonsDao();
                    studentDao.create(stuDetails);
                    studentList = studentDao.queryForAll();
                    System.out.println("list"+studentList.size());
                    Person person=studentDao.queryForId(2);
                    if (person == null) {
                        System.out.println("nashod");
                    }else{
                        System.out.println("person find");

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                //This is the way to insert data into a database table

            }
        });
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}


