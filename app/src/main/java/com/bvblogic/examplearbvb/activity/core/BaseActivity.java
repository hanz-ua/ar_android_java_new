package com.bvblogic.examplearbvb.activity.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;

import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.FragmentFeedback;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;
import com.bvblogic.examplearbvb.mvp.manager.core.core.ManagerUI;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


/**
 * Created by hanz on 7.05.18.
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity implements FragmentFeedback {

    private ManagerUI managerUI;

    @AfterViews
    public void initManager() {
        managerUI = this.getManagerUIToInit();
    }

    protected abstract ManagerUI getManagerUIToInit();

    @Override
    public void changeFragmentTo(FragmentData fragment) {
        this.managerUI.changeFragmentTo(fragment);
    }

    @Override
    public void initToolBar(BaseFragment baseFragment, ToolBarById toolBarById, String... label) {
        this.managerUI.initToolbar(baseFragment, toolBarById, label);
    }


    @Override
    public void onBackPressed() {
        BaseFragment.changeColorBar(this, BaseFragment.ColorBar.WHITE_DARK);
        if (!managerUI.removeFragment()) {
            super.onBackPressed();
        }
    }
}
