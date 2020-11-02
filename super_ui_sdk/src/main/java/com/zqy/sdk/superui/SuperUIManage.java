package com.zqy.sdk.superui;

import android.app.Application;

/**
 * Author: zhangqingyou
 * Date: 2020/10/18
 * Des:
 */
public class SuperUIManage {
    private static Application application;
    private static boolean debug;


    public static void init(Application application) {
        SuperUIManage.application = application;


//        LoadingLayout.getConfig()
//                .setErrorText("出错啦~请稍后重试！")
//                .setEmptyText("暂无数据~请稍后重试！")
//                .setNoNetworkText("无网络连接，请检查您的网络···")
//                .setErrorImage(R.mipmap.define_error)
//                .setEmptyImage(R.mipmap.define_empty)
//                .setNoNetworkImage(R.mipmap.define_nonetwork)
//                .setAllTipTextColor(ResourceUtils.getColorIdByName("colorPrimary"))
//                .setAllTipTextSize(14)
//                .setReloadButtonText("点我重试哦")
//                .setReloadButtonTextSize(14)
//                .setReloadButtonTextColor(ResourceUtils.getColorIdByName("colorPrimary"))
//                .setReloadButtonWidthAndHeight(150, 40);


    }

    public static Application getApplication() {
        return application;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        SuperUIManage.debug = debug;
    }
}
