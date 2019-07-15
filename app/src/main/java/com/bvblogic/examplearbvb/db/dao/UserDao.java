package com.bvblogic.examplearbvb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bvblogic.examplearbvb.db.domain.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;


/**
 * Created by hanz on 08.05.2018.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    Single<List<User>> getAll();

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(User... users);

    @Delete
    void delete(User user);
}
