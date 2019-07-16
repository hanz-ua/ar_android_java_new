package com.bvblogic.examplearbvb.bean.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.bvblogic.examplearbvb.adapter.activities.UserAdapter;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.domain.User;

import org.androidannotations.annotations.EBean;

import java.util.List;


@EBean
public class ProviderBeanUser extends Bean {

    @org.androidannotations.annotations.Bean
    public UserAdapter adapter;


    public void initAdapter(RecyclerView rv) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(activity));
        rv.setAdapter(adapter);
    }

    public void initAdapter(List<User> users) {
        adapter.setItems(users);

    }

}
