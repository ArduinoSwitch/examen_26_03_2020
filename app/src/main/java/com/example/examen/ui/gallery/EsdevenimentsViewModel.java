package com.example.examen.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.DataBase.RoomDB.Repository;
import com.example.examen.DataBase.RoomDB.UserModel;

import java.util.List;

public class EsdevenimentsViewModel extends ViewModel {

    public LiveData<List<UserModel>> userList;

    public EsdevenimentsViewModel() {
    }

    public void setList(Repository repository){
        userList = repository.getAllUsers();
    }

    public LiveData<List<UserModel>> getList() {
        return userList;
    }
}