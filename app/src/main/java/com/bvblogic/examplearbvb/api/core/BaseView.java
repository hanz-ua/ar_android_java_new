package com.bvblogic.examplearbvb.api.core;

import com.bvblogic.examplearbvb.api.model.Error;

public interface BaseView<T> {
    void onFailure(Error error);

    void onSuccess(T t);

    void showWait();

    void hideWait();
}
