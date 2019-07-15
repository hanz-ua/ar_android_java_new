package com.bvblogic.examplearbvb.db.presenter;


import android.widget.Toast;

import com.bvblogic.examplearbvb.db.datamanager.UserDataManager;
import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

import org.androidannotations.annotations.EBean;

import java.util.List;

/**
 * Created by hanz on 08.05.2018.
 */

@EBean
public class UserPresenter extends Presenter<List<User>> {

    public UserPresenter() {
    }

    public void getAllUser() {
        new UserDataManager().getAllUsers(appDatabase, this);
    }

    public void saveUser(User user) {
        new UserDataManager().saveUser(user, appDatabase, new Presenter<Long>() {
            @Override
            public void onSuccess(Long aLong) {
                Toast.makeText(activity, "" + aLong, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onSuccess(List<User> users) {
        if (users != null)
            Toast.makeText(activity, "" + users.size(), Toast.LENGTH_LONG).show();
    }
}
