package com.roomapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.roomapplication.dao.UserDao;
import com.roomapplication.entities.User;

/**
 * Created by emb-amarbai on 12/7/17.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();




}


