package com.example.todoapplication.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.todoapplication.Models.Todo;
import com.example.todoapplication.Models.User;

@Database(entities = {Todo.class, User.class}, version = 6, exportSchema = false)
public abstract class DB extends RoomDatabase {
    private static DB database;
    private static String DB_Name = "TodoApplication";

    public synchronized static DB getInstance(Context context){
       if(database==null){
            database = Room.databaseBuilder(context.getApplicationContext(), DB.class, DB_Name)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
       }

       return database;
    }

    public abstract TodoDAO todoDAO();
    public abstract UserDAO userDAO();
}
