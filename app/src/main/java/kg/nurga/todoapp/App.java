package kg.nurga.todoapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import kg.nurga.todoapp.room.AppDataBase;

public class App extends Application {

    private static AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(this,
                AppDataBase.class,
                "database").build();
    }

    public static AppDataBase getDataBase() {
        return dataBase;
    }
}
