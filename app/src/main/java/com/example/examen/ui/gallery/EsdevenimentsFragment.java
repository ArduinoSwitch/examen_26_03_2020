package com.example.examen.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.DataBase.RoomDB.Repository;
import com.example.examen.DataBase.RoomDB.UserModel;
import com.example.examen.R;

import java.util.List;
import java.util.Objects;

public class EsdevenimentsFragment extends Fragment {

    private RecyclerView recyclerView;

    private EsdevenimentsViewModel esdevenimentsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        esdevenimentsViewModel =
                ViewModelProviders.of(this).get(EsdevenimentsViewModel.class);
        Repository repository = new Repository(Objects.requireNonNull(getActivity()).getApplication());
        repository.insertUser(new UserModel("andrey","melnikov@gmail.com","melnikov",1, "1273912", 32));
        esdevenimentsViewModel.setList(repository);

        View root = inflater.inflate(R.layout.fragment_listat_esdeveniments, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        esdevenimentsViewModel.getList().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                RecyclerView.Adapter adapter = new ItemListAdapter(userModels);
                recyclerView.setAdapter(adapter);
            }
        });

        return root;
    }
}