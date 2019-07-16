package com.bvblogic.examplearbvb.adapter.activities;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.adapter.core.RecyclerViewAdapterBase;
import com.bvblogic.examplearbvb.adapter.core.ViewWrapper;
import com.bvblogic.examplearbvb.db.domain.User;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;


@EBean
public class UserAdapter extends RecyclerViewAdapterBase<User, UserItemView> {

    @RootContext
    protected BaseActivity activity;

    @Override
    protected UserItemView onCreateItemView(ViewGroup parent, int viewType) {
        return UserItemView_.build(activity);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<UserItemView> activitiesItemViewViewWrapper, int i) {
        UserItemView view = activitiesItemViewViewWrapper.getView();
        User user = items.get(i);
        view.setTag(i);
        view.bind(user, i);
    }
}
