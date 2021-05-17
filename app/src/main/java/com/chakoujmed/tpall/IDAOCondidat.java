package com.chakoujmed.tpall;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface IDAOCondidat {
    @Insert
    public void AddCondidat(Condidat c);
    @Query("select * from condidat")
    public List<Condidat> getAll();
    @Query("select * from condidat where filiere=:fil")
    public List<Condidat> getByFiliere(String fil);
    @Query("select * from condidat where sexe=:s")
    public List<Condidat> getBySexe(String s);
}
