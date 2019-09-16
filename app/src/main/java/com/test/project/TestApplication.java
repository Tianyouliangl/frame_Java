package com.test.project;

import android.app.Application;
import android.content.Context;

import com.test.project.common.Constant;
import com.test.project.common.act.NetConfig;

import net.ljb.kt.HttpConfig;

import java.util.HashMap;

/**
 * author : fengzhangwei
 * date : 2019/9/11
 */
public class TestApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext =  this;
        HttpConfig.INSTANCE.init(Constant.BaseUrl,getHeader(),getParams(),true);
        NetConfig.init(this);
    }

    /**
     * 公共Header
     * @return
     */
    private HashMap<String,String> getHeader(){
        HashMap<String, String> hashMap = new HashMap<>();
        return hashMap;
    }

    public static Context getContext(){
        return mContext;
    }

    /**
     * 公共参数
     * @return
     */
    private HashMap<String,String> getParams(){
        HashMap<String, String> hashMap = new HashMap<>();
        return hashMap;
    }
}
