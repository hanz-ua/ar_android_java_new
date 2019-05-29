package com.bvblogic.examplearbvb.bean.core;


import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.Error;

import org.androidannotations.annotations.EBean;


@EBean
public class BeanAPI<T> extends Bean implements BaseView<T> {

    @Override
    public void onFailure(Error error) {
    }

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void showWait() {

    }

    @Override
    public void hideWait() {

    }
}
