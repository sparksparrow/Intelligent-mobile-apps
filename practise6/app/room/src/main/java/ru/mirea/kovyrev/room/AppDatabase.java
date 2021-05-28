package ru.mirea.kovyrev.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
