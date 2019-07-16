package com.bvblogic.examplearbvb.fragment;


import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.login.LoginBeanView;
import com.bvblogic.examplearbvb.bean.login.LoginBeanView_;
import com.bvblogic.examplearbvb.bean.user.ProviderBeanUser;
import com.bvblogic.examplearbvb.bean.user.ProviderBeanUser_;
import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.db.presenter.UserPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Random;


@EFragment(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment {

    @Bean
    LoginBeanView loginBeanView;

    @Bean
    UserPresenter userPresenter;

    @AfterViews
    public void init() {
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);
        User user = new User();
        user.setUid(new Random().nextInt());
        user.setName("Yura1");
        userPresenter.saveUser(user);
        userPresenter.getAllUser();

    }

}
