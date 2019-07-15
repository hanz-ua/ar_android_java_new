package com.bvblogic.examplearbvb.api.networking;

import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.service.LoginService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginNetworking extends Service<LoginService> {
    public LoginNetworking(LoginService networkService) {
        super(networkService);
    }

    public Disposable login(String phone, String pass, final Callback<Token> userCallback) {
        return networkService.login(phone, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Token>() {

                    @Override
                    public void onNext(Token token) {
                        userCallback.onSuccess(token);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
