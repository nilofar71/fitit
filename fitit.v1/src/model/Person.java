package model;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nilofar on 2/3/2017.
 */
public class Person implements Serializable {

    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "name")
    public String name;

//    private String lastName;
//    private int weight;
//    private int height;
//    private boolean isVIP;
//    private String email;
//    private String pass;
//    private Date creationDate;
//    private Date expireDate;


    public Person(String name) {
        this.name = name;
    }
    public Person(){}
}
