package com.bvblogic.examplearbvb.activity;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.manager.MainActivityManagerUI;
import com.bvblogic.examplearbvb.mvp.manager.core.core.ManagerUI;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @AfterViews
    public void init() {
        changeFragmentTo(new FragmentData(FragmentById.SPLASH_FRAGMENT));
    }


    @Override
    protected ManagerUI getManagerUIToInit() {
        return new MainActivityManagerUI(this);
    }
}
