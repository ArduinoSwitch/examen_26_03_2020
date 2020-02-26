package com.example.examen.DataBase.PSQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionPSQL {
    ArrayList<EventsModel> listEvents;
    public void inserData() {
        postData.start();
        if (postData.isAlive()){
            System.out.println("Hecho!");
        } else {
            System.out.println("Fallo!");
        }
    }

    Thread getData = new Thread(){
        Connection conn;

        public void run() {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://192.168.0.22:5432/esdeveniments",
                        "maggy",
                        "hamilton"
                );
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM EventDetail;");
                rs
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    };

    Thread postData = new Thread() {
        Connection conn;

        public void run() {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://192.168.0.22:5432/esdeveniments",
                        "maggy",
                        "hamilton"
                );
                Statement st = conn.createStatement();
                st.execute("INSERT INTO EventDetail values(‘Examen’, ‘02/28/2020’, ‘INS JdA’, ‘jda@jda.org’, ‘Aula 39’, 50, 20, ‘Examen ABP de M3, M6, M8 i M9’);");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    };
}
