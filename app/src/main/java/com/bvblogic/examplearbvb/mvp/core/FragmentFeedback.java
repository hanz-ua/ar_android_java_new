package com.bvblogic.examplearbvb.mvp.core;


import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

public interface FragmentFeedback {

    void changeFragmentTo(FragmentData fragment);

    void initToolBar(BaseFragment baseFragment, ToolBarById toolBarById, String... label);

}
