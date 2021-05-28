package ru.mirea.kovyrev.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
class Employee {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public int salary;
}
