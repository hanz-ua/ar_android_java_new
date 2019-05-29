package com.bvblogic.examplearbvb.api.presenter.core;


import com.bvblogic.examplearbvb.api.core.BaseView;

import io.reactivex.disposables.CompositeDisposable;

public abstract class Presenter<T, Y> {

    protected final T service;
    protected final BaseView<Y> yBaseView;
    protected CompositeDisposable compositeDisposable;

    public Presenter(T service, BaseView<Y> yBaseView) {
        this.service = service;
        this.yBaseView = yBaseView;
        this.compositeDisposable = new CompositeDisposable();
    }

    protected void stop(){
        compositeDisposable.dispose();
    }
}
