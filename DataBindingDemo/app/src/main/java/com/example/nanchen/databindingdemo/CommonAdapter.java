package com.example.nanchen.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ListView的通用Adapter
 * Created by 南尘 on 16-7-18.
 */
public class CommonAdapter<T> extends BaseAdapter {
    private Context context;//上下文环境
    private List<T> list;//通用的，不知道数据
    private int layoutId;//通用的，不知道布局
    private int variableId;//变量的id

    /**
     * 构造方法
     */
    public CommonAdapter(Context context, List<T> list, int layoutId, int variableId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding = null;
        if (convertView == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(context),layoutId,parent,false);
        }else{
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(variableId,list.get(position));
        return binding.getRoot();
    }
}
