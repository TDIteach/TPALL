package com.chakoujmed.tpall;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Condidat.class},version = 1)
public abstract class CondidatsDataBase extends RoomDatabase {
    public abstract IDAOCondidat getDaoCondidat();
}
