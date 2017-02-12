package com.example.fitit_v1;

import model.Person;

/**
 * Created by nilofar on 2/4/2017.
 */
public class main {
    public static void main(String[] args){
        Person person=new Person();
        person.setLastName("ggg");
       boolean result= G.registerPerson(person);
        System.out.println("result::"+result);


    }
}
