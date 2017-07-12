package com.roomapplication;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.roomapplication.database.AppDatabase;
import com.roomapplication.entities.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inserting the users details

        AppDatabase db = Room.databaseBuilder(MainActivity.this, AppDatabase.class, "database-name").allowMainThreadQueries().build();

        int count = db.userDao().userCount("A0", "B0");
        if (count == 0) {
            for (int i = 0; i < 5; i++) {
                user = new User();
                user.setUid(i);
                user.setFirstName("A" + i);
                user.setLastName("B" + i);
                db.userDao().insertAll(user);
            }
        }

        List<User> userList = db.userDao().getAll();
        for (int i = 0; i < userList.size(); i++) {
            Log.d("amar", "onCreate: " + db.userDao().getAll().get(i).getFirstName());
        }


    }
}
