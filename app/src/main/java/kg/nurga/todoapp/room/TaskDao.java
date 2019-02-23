package kg.nurga.todoapp.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import kg.nurga.todoapp.Task;
@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Query("SELECT * FROM task WHERE id = :id")
    Task getTaskById (int id);


    @Insert
    void insert(Task task);


    @Update
    void ubdate(Task task);

    @Delete
    void delete(Task task);
}
