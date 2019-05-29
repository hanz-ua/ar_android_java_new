package com.bvblogic.examplearbvb.api.service;

import com.bvblogic.examplearbvb.api.model.Token;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginService {
    @POST("authH")
    Observable<Token> login(@Header("phone") String phone, @Header("pass") String pass);
}
