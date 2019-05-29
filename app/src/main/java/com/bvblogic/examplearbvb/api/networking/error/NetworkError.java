package com.bvblogic.examplearbvb.api.networking.error;

import android.util.Log;

import com.bvblogic.examplearbvb.api.model.Error;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;


/**
 * Created by hanz on 14.04.2018.
 */

public class NetworkError extends Throwable {


    private final Throwable error;

    public NetworkError(Throwable error) {
        super(error);
        this.error = error;
    }

    public String getMessage() {
        return error.getMessage();
    }

    public Error getAppErrorMessage() {
        Log.d("error", error.getMessage());
        if (this.error instanceof IOException) return new Error(-1, "Not internet connect");
        return new Error(-1, "Something went wrong");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        NetworkError networkError = (NetworkError) obj;

        return error != null ? error.equals(networkError.error)
                : networkError.error == null;
    }


    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
