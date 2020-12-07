package com.example.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication3.database.UserBaseHelper;
import com.example.myapplication3.database.UserDbSchema;

import java.util.ArrayList;
import java.util.List;

// создаем один объект - Синглетный класс (может быть создан только один объект)
public class UserList {
    private static UserList userList; // обращаемся не создавая объект
    private Context context;
    private SQLiteDatabase database;
    private List users = new ArrayList();
    public static UserList get(Context context){ // проверка существования UserList
        if(userList == null){
            userList = new UserList(context); // если он не существует, то создаем
        }
        return userList; // возвращаем существующий список
    }
    private UserList(Context context){ // заполняем список пользователей данными
        this.context = context.getApplicationContext();
        database = new UserBaseHelper(context).getWritableDatabase();
    }
    public List getUsers() {
        UserCursorWrapper cursor = queryUsers(null, null);
        try {
            cursor.moveToFirst(); // первое значение бд
            while (!cursor.isAfterLast()){
                users.add(cursor.getUser());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return users;
    }
    public void addUser(User user){
        ContentValues values = getContentValues(user);
        database.insert(UserDbSchema.UserTable.NAME, null, values);
        //users.add(user);
    }

    private static ContentValues getContentValues(User user){
        ContentValues values = new ContentValues();
        values.put(UserDbSchema.UserTable.cols.UUID, user.getUuid().toString());
        values.put(UserDbSchema.UserTable.cols.USERNAME, user.getUserName());
        values.put(UserDbSchema.UserTable.cols.USERLASTNAME, user.getUserLastName());
        return values;
    }
    private UserCursorWrapper queryUsers(String whereClause, String[] whereArgs){
        Cursor cursor = database.query(
                UserDbSchema.UserTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new UserCursorWrapper(cursor);
    }
}
