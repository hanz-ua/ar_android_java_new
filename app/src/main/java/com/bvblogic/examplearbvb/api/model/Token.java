package com.bvblogic.examplearbvb.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token")
    @Expose
    private String myToken;

    public Token() {
    }

    public Token(String myToken) {
        this.myToken = myToken;
    }

    public String getMyToken() {
        return myToken;
    }

    public void setMyToken(String myToken) {
        this.myToken = myToken;
    }
}
