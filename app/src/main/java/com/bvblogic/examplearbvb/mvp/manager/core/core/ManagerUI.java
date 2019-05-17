package com.bvblogic.examplearbvb.mvp.manager.core.core;

import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;


/**
 * Created by hanz on 7.05.18.
 */
public interface ManagerUI {

    void changeFragmentTo(FragmentData fragmentData);

    void initToolbar(BaseFragment baseFragment, ToolBarById toolBarById, String... text);

    boolean removeFragment();
}
