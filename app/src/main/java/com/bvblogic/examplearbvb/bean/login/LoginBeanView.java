package com.bvblogic.examplearbvb.bean.login;

import android.widget.Toast;

import com.bvblogic.examplearbvb.api.model.Error;
import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.presenter.LoginPresenter;
import com.bvblogic.examplearbvb.bean.login.core.LoginBean;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EBean;

@EBean
public class LoginBeanView extends LoginBean {

    @Override
    public void init() {
        super.init();
        getLoginDeps().inject(this);
    }

    @AfterViews
    public void login(){
        new LoginPresenter(networkLogin, this).login("+380990337452","123456");
    }

    @Override
    public void onSuccess(Token token) {
        Toast.makeText(activity, token.getMyToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Error error) {
        Toast.makeText(activity, error.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
