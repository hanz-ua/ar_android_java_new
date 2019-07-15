package com.bvblogic.examplearbvb.db.datamanager;

import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.core.DBView;
import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hanz on 08.05.2018.
 */

public class UserDataManager {


    public void getAllUsers(AppDatabase appDatabase, DBView<List<User>> listDBView) {
        listDBView.showWait();
        appDatabase.userDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<User>>() {
                    @Override
                    public void onSuccess(List<User> users) {
                        listDBView.onSuccess(users);
                        listDBView.hideWait();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listDBView.onError(e);
                        listDBView.hideWait();
                    }
                });
    }


    public void saveUser(User user, AppDatabase appDatabase, DBView<Long> listDBView) {
        listDBView.showWait();
        appDatabase.userDao().insertAll(user);
    }
}
