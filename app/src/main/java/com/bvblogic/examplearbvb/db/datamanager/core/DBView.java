package com.bvblogic.examplearbvb.db.datamanager.core;

/**
 * Created by hanz on 08.05.2018.
 */

public interface DBView<T> {

    void showWait();

    void hideWait();

    void onError(Throwable throwable);

    void onSuccess(T t);


}
