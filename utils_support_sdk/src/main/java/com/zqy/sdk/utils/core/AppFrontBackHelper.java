package com.zqy.sdk.utils.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangqingyou
 * Date: 2020/5/18 11:33
 * Des:
 */
public class AppFrontBackHelper {
    private static AppFrontBackHelper mInstance;
    private List<OnAppStatusListener> listenerList;


    private AppFrontBackHelper() {
        listenerList = new ArrayList<>();
    }

    public static AppFrontBackHelper getInstance() {
        if (mInstance == null) {
            synchronized (AppFrontBackHelper.class) {
                if (mInstance == null) {
                    mInstance = new AppFrontBackHelper();
                }
            }
        }
        return mInstance;
    }


    public void setOnAppStatusListener(OnAppStatusListener mOnAppStatusListener) {
        if (mOnAppStatusListener != null)
            listenerList.add(mOnAppStatusListener);
    }

    /**
     * 注册状态监听，仅在Application中使用
     *
     * @param application
     */
    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void unRegister(Application application) {
        listenerList.clear();
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        //打开的Activity数量统计
        private int activityStartCount = 0;

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {
            activityStartCount++;
            //数值从0变到1说明是从后台切到前台
            if (activityStartCount == 1) {
                //从后台切到前台
                if (listenerList != null && listenerList.size() > 0) {
                    for (OnAppStatusListener onAppStatusListener : listenerList) {
                        onAppStatusListener.onFront();
                    }
                }

            }
        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            activityStartCount--;
            //数值从1到0说明是从前台切到后台
            if (activityStartCount == 0) {
                //从前台切到后台
                if (listenerList != null && listenerList.size() > 0) {
                    for (OnAppStatusListener onAppStatusListener : listenerList) {
                        onAppStatusListener.onBack();
                    }
                }

            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    public interface OnAppStatusListener {
        void onFront();

        void onBack();
    }

}

