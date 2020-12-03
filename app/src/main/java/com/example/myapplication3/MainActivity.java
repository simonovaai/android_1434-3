package com.example.myapplication3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // создаем объект UserList - это наш список
        UserList userList = UserList.get();
        // вызывает фрагмент FragmentManager для управления отображением элементов на экране
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Создаем фрагмент
        Fragment fragment = new UserFragment();
        // помещает элементы фрагмента на экран и фиксируем их на экране
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
    }
}