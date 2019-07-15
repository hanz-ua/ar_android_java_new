package com.bvblogic.examplearbvb.mvp.manager.core.core;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bvblogic.examplearbvb.fragment.core.BaseFragment;


public abstract class BaseManagerUI implements ManagerUI {

    private AppCompatActivity activity;


    public BaseManagerUI(AppCompatActivity activity) {
        this.activity = activity;
        this.initUI();
    }

    protected AppCompatActivity getActivity() {
        return this.activity;
    }

    protected abstract int getIdFragmentsContainer();

    protected abstract void initUI();

    protected void addFragmentToContainer(BaseFragment baseFragment, boolean toBackStack, FragmentTransaction transaction) {
        if (toBackStack) {
            transaction.addToBackStack(baseFragment.getClass().getSimpleName()).add(this.getIdFragmentsContainer(), baseFragment, baseFragment.getClass().getSimpleName());
        } else {
            transaction.replace(this.getIdFragmentsContainer(), baseFragment,
                    baseFragment.getClass().getSimpleName());
        }
        transaction.commitAllowingStateLoss();
    }

}
