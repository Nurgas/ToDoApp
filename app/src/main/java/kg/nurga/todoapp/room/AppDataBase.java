package kg.nurga.todoapp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import kg.nurga.todoapp.Task;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();

}
