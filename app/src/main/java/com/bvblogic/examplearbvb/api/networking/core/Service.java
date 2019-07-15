package com.bvblogic.examplearbvb.api.networking.core;


import com.bvblogic.examplearbvb.api.networking.error.NetworkError;

public class Service<T> {
    protected final T networkService;

    public Service(T networkService) {
        this.networkService = networkService;
    }

    public interface Callback<T>{
        void onSuccess(T t);
        void onError(NetworkError networkError);
    }
}
