package com.bvblogic.examplearbvb.mvp.manager.core;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;
import com.bvblogic.examplearbvb.mvp.manager.core.core.BaseManagerUI;


/**
 * Created by hanz on 7.05.18.
 */
public abstract class BaseMainActivityManagerUI extends BaseManagerUI {

    public BaseMainActivityManagerUI(AppCompatActivity activity) {
        super(activity);
    }


    @Override
    public void initToolbar(BaseFragment baseFragment, ToolBarById toolBarById, String... text) {
        View inflate = null;
        switch (toolBarById) {
            case CLOSE: {
                inflate = getActivity().getLayoutInflater().inflate(R.layout.toolbar_close, null);
                inflate.findViewById(R.id.close).setOnClickListener(view ->
                        getActivity().onBackPressed());
                break;
            }
        }
        updateToolbar(baseFragment, inflate);
    }

    private void updateToolbar(BaseFragment baseFragment, View inflate) {
        baseFragment.getToolbarContainer().removeAllViews();
        baseFragment.getToolbarContainer().addView(inflate);
    }
}
