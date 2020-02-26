package com.example.examen.DataBase.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserModel user);

    @Query("SELECT * FROM user_table")
    LiveData<List<UserModel>> getAllUsers();
}
