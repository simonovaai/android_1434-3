package com.example.myapplication3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {
    private User user;
    private TextView userName_userLastname_View;
    //запускается при создании фрагмента
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User(); // создан пустой пользователь
        // задали значения пользователя
        user.setUserName("Ivan");
        user.setUserLastName("Ivanov");
    }
    // создаем компоненты внутри фрагментов и передаем их в Активность
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // шаблон-фрагмент кладем в контейнер и расширяем его, не присоединяя объекты к корневому элементу
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        //  на фрагменте (View) ищем наш элемент
        userName_userLastname_View = view.findViewById(R.id.userName_userLastname_View);
        // соединяем фамилию и имя пользователя
        String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: "+user.getUserLastName();
        userName_userLastname_View.setText(userName); // выводим на экран нашу строку
        return view; // возвращает отображение
    }
}
