package com.example.myapplication3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UserListFragment extends Fragment {
    private RecyclerView userRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
    // создаем компонент View
        View view = inflater.inflate(R.layout.fragment_user_list, viewGroup, false);
        userRecyclerView = view.findViewById(R.id.userRecyclerView); // находим его на экране
        //создаем макет области и получаем активность, там будут размещаться элементы списка
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
    private class UserHolder extends RecyclerView.ViewHolder{
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup){
            super(inflater.inflate(R.layout.list_item_user, viewGroup, false));
        }
    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        private List<User> users;
        public UserAdapter(List<User> users){
            this.users = users;
        }

        @NonNull
        @Override //  для создания следующего элемента списка
        public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new UserHolder(inflater, viewGroup);
        } // при перелистывании берется каждый раз новый элемент list_item_user

        @Override
        public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {

        }

        @Override // возвращает кол-во элементов в списке
        public int getItemCount() {
            return users.size();
        }
    }
}
