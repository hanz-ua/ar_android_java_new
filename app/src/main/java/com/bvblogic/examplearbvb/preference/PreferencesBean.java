package com.bvblogic.examplearbvb.preference;


import com.bvblogic.examplearbvb.preference.core.Preference;

import org.androidannotations.annotations.EBean;



/**
 * Created by hanz on 10.05.2017.
 */

@EBean
public class PreferencesBean extends Preference {

    public void exit() {
        removeToken();
    }

    public void saveToken(String token) {
        savePreferences(TOKEN_KEY, token);
    }

    public String getToken() {
        return getPreferencesString(TOKEN_KEY);
    }

    public void removeToken() {
        remove(TOKEN_KEY);
    }


}
