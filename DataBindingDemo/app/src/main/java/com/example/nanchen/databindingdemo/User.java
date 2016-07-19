package com.example.nanchen.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

/**
 * 继承，观察可刷新
 * Created by 南尘 on 16-7-18.
 */
public class User extends BaseObservable {
    private String name;//用户名
    private String nickName;//昵称
    private String email;//邮箱

    private boolean vip;//是否是会员
    private int level;//级别
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public User() {
    }

    public User(String name, String nickName, String email) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
        //刷新变量（变量id）
        notifyPropertyChanged(com.example.nanchen.databindingdemo.BR.name);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void clickName(View view){
        Toast.makeText(view.getContext(),"点击了用户名：" + name,Toast.LENGTH_SHORT).show();
    }

    public boolean longClickNickName(View view){
        Toast.makeText(view.getContext(),"长按了昵称:"+nickName,Toast.LENGTH_SHORT).show();
        return true;
    }

    public void click(View view){
        setName(getName() + "( 已点击 )");
    }
}
