package com.bvblogic.examplearbvb.bean.core;

import com.bvblogic.examplearbvb.activity.core.BaseActivity;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;


@EBean
public class Bean {
    @RootContext
    protected BaseActivity activity;
}
