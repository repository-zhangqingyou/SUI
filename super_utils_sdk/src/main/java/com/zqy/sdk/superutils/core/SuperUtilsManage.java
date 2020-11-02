package com.zqy.sdk.superutils.core;

import android.app.Application;
import android.text.TextUtils;

import com.zqy.sdk.superutils.logger.Logger;
import com.zqy.sdk.superutils.utilcode.util.Utils;


/**
 * 缓存工具类
 * Author: zhangqingyou
 * Date: 2020/4/7
 * Des:
 */
public class SuperUtilsManage {
    private static Application application;
    private static String logTag;

    public static void init(Application application) {
        SuperUtilsManage.application = application;

        Utils.init(application);//初始化android工具类

        if (TextUtils.isEmpty(logTag)) {
            Logger.init("Logger日志");
        }


    }

    public static Application getApplication() {
        return application;
    }

    /**
     * 设置日志TAG
     *
     * @param logTag 日志TAG
     */
    public static void setLogTag(String logTag) {
        SuperUtilsManage.logTag = logTag;
        Logger.init(logTag);
    }

    /**
     * 设置缓存配置
     *
     * @param cacheRootPath     缓存路径
     */
    public static void setCache(String cacheRootPath) {
        CacheUtil.init(cacheRootPath);
    }

}
