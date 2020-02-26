package com.example.examen.DataBase.RoomDB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private UserDao userDao;
    private LiveData<List<UserModel>> userModelList;

    public Repository(Application application) {
        RoomDataBase fichappRoomDb = RoomDataBase.getDatabase(application.getApplicationContext());
        userDao = fichappRoomDb.fichappDao();
        userModelList = userDao.getAllUsers();
    }

    public LiveData<List<UserModel>> getAllUsers() {
        return userModelList;
    }

    public void insertUser(final UserModel user) {
        RoomDataBase.databaseWriterExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }
}

