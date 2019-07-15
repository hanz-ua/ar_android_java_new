package com.bvblogic.examplearbvb.bean.login.core;

import com.bvblogic.examplearbvb.api.deps.DaggerLoginDeps;
import com.bvblogic.examplearbvb.api.deps.LoginDeps;
import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.networking.LoginNetworking;
import com.bvblogic.examplearbvb.api.networking.module.NetworkModule;
import com.bvblogic.examplearbvb.bean.core.BeanAPI;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.io.File;

import javax.inject.Inject;


@EBean
public abstract class LoginBean extends BeanAPI<Token> {

    private LoginDeps loginDeps;

    public LoginDeps getLoginDeps() {
        return loginDeps;
    }

    @Inject
    public LoginNetworking networkLogin;

    @AfterInject
    public void init() {
        loginDeps = DaggerLoginDeps.builder().networkModule
                (new NetworkModule(new File(activity.getCacheDir(), "responses"),
                "http://class-music.herokuapp.com/", activity)).build();
    }
}
