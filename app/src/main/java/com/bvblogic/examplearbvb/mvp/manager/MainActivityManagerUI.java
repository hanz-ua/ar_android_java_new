package com.bvblogic.examplearbvb.mvp.manager;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.fragment.SplashFragment_;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.manager.core.BaseMainActivityManagerUI;

import java.util.ArrayList;



/**
 * Created by hanz on 7.05.18.
 */
public class MainActivityManagerUI extends BaseMainActivityManagerUI {

    public MainActivityManagerUI(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected int getIdFragmentsContainer() {
        return R.id.fragment_container;
    }

    @Override
    protected void initUI() {
    }

    @SuppressLint("CommitTransaction")
    @Override
    public void changeFragmentTo(FragmentData fragment) {
        switch (fragment.getFragmentById()) {
            case SPLASH_FRAGMENT: {
                addFragmentToContainer(SplashFragment_.builder().build(), false,
                        this.getActivity().getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(0, android.R.anim.fade_out));
                break;
            }
            
            case NEW_FRAGMENT:{
                // TODO: 15.07.2019 add fragment 
            }

            case NEW_NEW:
            {

            }
        }
    }

    private void removeAnimFragment(Fragment fragment, int anim) {
        this.getActivity().getSupportFragmentManager().
                beginTransaction().
                setCustomAnimations(anim, anim).
                remove(fragment).
                commitAllowingStateLoss();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private String[] fragments = {
            //SplashFragment_.class.getSimpleName()
    };

    @Override
    public boolean removeFragment() {
        for (String s : fragments) {
            Fragment fragment = this.getActivity().getSupportFragmentManager().findFragmentByTag(s);
            if (fragment != null) {
//                if (fragment.getClass().getSimpleName().equals(SplashFragment_.class.getSimpleName())) {
//                    BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.WHITE_DARK);
//                }
//                removeAnimFragment(fragment, R.anim.anim_exit);
                return true;
            }
        }
        return false;
    }
}
