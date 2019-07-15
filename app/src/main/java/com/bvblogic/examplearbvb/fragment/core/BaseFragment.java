package com.bvblogic.examplearbvb.fragment.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.FragmentFeedback;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * Created by hanz on 7.05.18.
 */
@EFragment
public abstract class BaseFragment extends Fragment {

    @ViewById(R.id.toolbar_container)
    public RelativeLayout toolbarContainer;
    @ViewById(R.id.toolbar)
    public Toolbar toolbar;


    @AfterInject
    public void initBaseFragment() {
        cleanFullScreen();
    }

    protected void initToolBar(ToolBarById toolBarById, String... text) {
        if (this.getFragmentFeedback() != null) {
            this.getFragmentFeedback().initToolBar(this, toolBarById, text);
        }
    }

    protected void setFullScreen() {
        if (getActivity() != null)
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public enum ColorBar {
        BLUE(Color.parseColor("#1B74E3")),
        WHITE_DARK(Color.parseColor("#F1F3F6")),
        BLACK(Color.parseColor("#000000")),
        WHITE(Color.WHITE);

        private final int color;

        private ColorBar(int color) {
            this.color = color;
        }
    }

    public static void changeColorBar(Activity activity, ColorBar colorBar) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(colorBar.color);
        if (colorBar == ColorBar.BLUE || colorBar == ColorBar.BLACK) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    protected void cleanFullScreen() {
        if (getActivity() != null)
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public RelativeLayout getToolbarContainer() {
        return toolbarContainer;
    }

    protected FragmentFeedback getFragmentFeedback() {
        return (FragmentFeedback) this.getActivity();
    }

    protected void changeFragmentTo(FragmentData fragment) {
        if (this.getFragmentFeedback() != null) {
            this.getFragmentFeedback().changeFragmentTo(fragment);
        }
    }

}
