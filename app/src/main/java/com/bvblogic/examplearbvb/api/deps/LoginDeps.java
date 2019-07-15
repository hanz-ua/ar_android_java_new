package com.bvblogic.examplearbvb.api.deps;

import com.bvblogic.examplearbvb.api.networking.module.NetworkModule;
import com.bvblogic.examplearbvb.bean.login.LoginBeanView;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface LoginDeps {
    void inject(LoginBeanView loginBeanView);
}
