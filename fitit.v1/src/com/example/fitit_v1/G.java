package com.example.fitit_v1;

import android.app.Application;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import model.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
/**
 * Created by nilofar on 1/26/2017.
 */
public class G extends Application {
    public static Context context;
    public static SQLiteDatabase database;

//    public static final String DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
//    public  final String DIR_SDCARD = getFilesDir().getAbsolutePath();
//    Connection conn = DriverManager.getConnection(HOST+DB,USER,PASSWORD);
    public static String DIR_DATABASE2=Environment.getExternalStorageDirectory().getAbsolutePath()+ "/database-test";

    @Override
    public void onCreate() {
        super.onCreate();

        context = this.getApplicationContext();
//        final String DIR_DATABASE =getFilesDir().getAbsolutePath()+ "/database-test";
        final String DIR_DATABASE =Environment.getExternalStorageDirectory().getAbsolutePath()+ "/database-test";
//        DIR_DATABASE2=DIR_DATABASE;
//        System.out.println("address DIR_SDCARD::" + getFilesDir().getAbsolutePath());
//        System.out.println("address DIR_DATABASE::"+  DIR_DATABASE );
        new File(DIR_DATABASE).mkdirs();
        try {
            database = SQLiteDatabase.openOrCreateDatabase(DIR_DATABASE+"/farazDatabase.sqlite", null);
//            database.execSQL("CREATE  TABLE  IF NOT EXISTS person ( " +
//                    "person_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE, " +
//                    "person_name TEXT, " +
//                    "person_family TEXT, " +
//                    "person_age INTEGER" +
//                    ")");

//            final Connection cn= DriverManager.getConnection(DIR_SDCARD + database, null, null);
//

            database.execSQL("CREATE  TABLE IF NOT EXISTS person(id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE " +
                    ", name TEXT, last TEXT, weight INTEGER, height INTEGER, email TEXT, vip CHAR " +
                    ", creationDate DATETIME, expireDate DATETIME, pass TEXT) ");
//            File source = new File(DIR_DATABASE);
//            File destination = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+android.os.Environment.DIRECTORY_DCIM);
//            copyFile(source,destination);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean registerPerson(Person person){
            try {
    //            booleanExpression ? value1 : value2
    //            System.out.println("data base ::" + database);
    //            System.loadLibrary("../libs/sqlite-jdbc-3.8.11.2.jar");
    //            final Connection cn= DriverManager.getConnection(DIR_DATABASE2 + database,"","");
                String url = "jdbc:sqlite:" + DIR_DATABASE2+"/farazDatabase.sqlite";
    //            String url = "jdbc:sqlite:farazDatabase.sqlite";
    //            String url = DIR_DATABASE2+"/farazDatabase.sqlite";
                // create a connection to the database
    //            Class.forName("org.sqlite.JDBC");
    //            DriverManager.registerDriver(new org.sqlite.JDBC());
    //            final Connection cn = DriverManager.getConnection(url);
    //            final Connection cn = DriverManager.getConnection(url);
    //            final Connection cn= DriverManager.getConnection(DIR_DATABASE2 + database,"","");
    //            String sql = "INSERT INTO person( name, last, weight, height, email, vip, creationDate" +
    //                    ", expireDate, pass) VALUES (?, ?, ?,?,?,?,?,?,?)";
    //            PreparedStatement ps = cn.prepareStatement(sql);
    //            ps.setString(1, person.getName());
    //            ps.setString(2, person.getLastName());
    //            ps.setInt(3, person.getWeight());
    //            ps.setInt(4, person.getHeight());
    //            ps.setString(5, person.getEmail());
    //            ps.setString(6, person.isVIP() ? "1" : "0");
    //            ps.setDate(7, (java.sql.Date) getSysdate());
    //            ps.setDate(8, (java.sql.Date) getSysdate());
    //            ps.setString(9, md5(person.getPass()));
    //            ps.executeUpdate();
    //            return true;
            } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
                System.exit(0);
                return false;
        }
            return false;
    }


    private boolean login(String name,String pass){
        try {
           String passMD5= md5(pass);
//        String sql = "INSERT INTO MYTABLE (NAME, EMP_NO, DATE_HIRED) VALUES (?, ?, ?)";
//        PreparedStatement ps = sqlite.prepareStatement(sql);
//        ps.setString(1, myString);
//        ps.setInt(2, myInt);
//        ps.setDate(3, myDate);
//        ps.executeUpdate();

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public static final String md5(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static Date getSysdate(){

     return null;
    }




    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.getParentFile().exists())
            destFile.getParentFile().mkdirs();

        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

}
