package com.example.examen.DataBase.PSQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionPSQL {
    public void inserData() {
        myThread.start();
        if (myThread.isAlive()){
            System.out.println("Hecho!");
        } else {
            System.out.println("Fallo!");
        }
    }

    Thread myThread = new Thread() {
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
