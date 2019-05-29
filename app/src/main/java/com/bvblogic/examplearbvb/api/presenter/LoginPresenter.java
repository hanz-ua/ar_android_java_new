package com.bvblogic.examplearbvb.api.presenter;

import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.networking.LoginNetworking;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.presenter.core.Presenter;
import com.bvblogic.examplearbvb.bean.login.LoginBeanView;

import org.androidannotations.annotations.Bean;

import okhttp3.Credentials;

public class LoginPresenter extends Presenter<LoginNetworking, Token> {
    public LoginPresenter(LoginNetworking service, BaseView<Token> tokenBaseView) {
        super(service, tokenBaseView);
    }

    public void login(String phone, String pass) {
        yBaseView.showWait();
        compositeDisposable.add(service.login(phone, pass, new Service.Callback<Token>() {
            @Override
            public void onSuccess(Token token) {
                yBaseView.hideWait();
                yBaseView.onSuccess(token);
                stop();
            }

            @Override
            public void onError(NetworkError networkError) {
                yBaseView.hideWait();
                yBaseView.onFailure(networkError.getAppErrorMessage());
                stop();
            }
        }));

    }
}
