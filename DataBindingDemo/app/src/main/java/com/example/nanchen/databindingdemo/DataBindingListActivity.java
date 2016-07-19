package com.example.nanchen.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nanchen.databindingdemo.databinding.ActivityDataBindingListBinding;

import java.util.ArrayList;
import java.util.List;

public class DataBindingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding_list);
        ActivityDataBindingListBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_list);

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("用户 " + i );
            user.setIcon("http://qlogo1.store.qq.com/qzone/503233512/503233512/100?1311741184");
            list.add(user);
        }
        CommonAdapter<User> adapter = new CommonAdapter<>(
                this, list, R.layout.list_item, com.example.nanchen.databindingdemo.BR.user);
        binding.setAdapter(adapter);

    }


}
