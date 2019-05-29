package com.bvblogic.examplearbvb.fragment;


import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.login.LoginBeanView;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;


@EFragment(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment {

    @Bean
    LoginBeanView loginBeanView;

    @AfterViews
    public void init() {
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);
    }

}
