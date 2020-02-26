package com.example.examen.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.DataBase.RoomDB.UserModel;
import com.example.examen.R;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {

    private List<UserModel> userList;

    static class ItemListViewHolder extends RecyclerView.ViewHolder {

        TextView firstText, secondText, thirdText, zeroText;

        ItemListViewHolder(View v) {
            super(v);
            this.zeroText = v.getRootView().findViewById(R.id.zeroText);
            this.firstText = v.getRootView().findViewById(R.id.firstText);
            this.secondText = v.getRootView().findViewById(R.id.secondText);
            this.thirdText = v.getRootView().findViewById(R.id.thirdText);
        }
    }

    ItemListAdapter(List<UserModel> registerHistoryModelList) {
        this.userList = registerHistoryModelList;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ItemListViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        if(userList != null) {
            holder.zeroText.setText(position + 1 + "");
            holder.firstText.setText(userList.get(position).getName());
            holder.secondText.setText(userList.get(position).getLastName());
            holder.thirdText.setText(userList.get(position).getEmail());
        }
    }

    @Override
    public int getItemCount() {
        if(userList != null) {
            return userList.size();
        }
        return 0;
    }
}
