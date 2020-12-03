package com.example.myapplication3;
// создаем один объект - Синглетный класс (может быть создан только один объект)
public class UserList {
    private static UserList userList; // обращаемся не создавая объект
    public static UserList get(){ // проверка существования UserList
        if(userList == null){
            userList = new UserList(); // если он не существует, то создаем
        }
        return userList; // возвращаем существующий список
    }
    private UserList(){ }
}
