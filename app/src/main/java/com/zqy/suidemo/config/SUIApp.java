package com.zqy.suidemo.config;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.zqy.sdk.sui.SUIManage;

/**
 * 作者: zhangqingyou
 * 时间: 2020/8/19 15:07
 * 描述:
 */
public class SUIApp extends Application {
    private static Application application;

    /**
     * 获取Application
     */
    public static Application getApplication() {
        return application;
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initModule();
    }

    /**
     *
     */
    private void initModule() {
        SUIManage.init(this);
      //  SUIManage.initBugly("", "SUI");//不使用就不初始化，否则报错
//        SUIManage.setApiCallback(new ApiCallbackService() {
//
//            @Override
//            public void onStart(String baseUrl, String endUrl, Request request) {
//                //这里可以添加公共请求参数
//            }
//
//            @Override
//            public void onFinish(String msg) {
//            }
//
//            @Override
//            public void onError(String baseUrl, String endUrl, Response response) {
//                Throwable exception = response.getException();
//                okhttp3.Response responseRawResponse = response.getRawResponse();
//                String requestString = "";//请求信息
//                String bodyString = "";//返回信息
//                if (responseRawResponse != null) {
//                    if (responseRawResponse.request() != null) {
//                        requestString = responseRawResponse.request().toString();
//                        Log.d(endUrl + "出错啦！--请求信息：", requestString);
//                    }
//
//                    if (responseRawResponse.body() != null) {
//                        bodyString = responseRawResponse.body().toString();
//                        Log.d(endUrl + "出错啦！--返回信息：", bodyString);
//                    }
//
//                }
//
//                if (exception != null) {
//                    ToastUtil.toast(endUrl + "出错啦！--错误信息：" + exception.getMessage());
//                    Log.d(endUrl + "出错啦！--错误信息：", exception.getMessage());
//
//                    if (exception instanceof JsonSyntaxException) {
//                        // 极光计数事件（接口返回json数据解析错误使用）
//                      //  JEventUtils.onJsonCountEventError(baseUrl, requestString, bodyString, exception.getMessage());
//                    } else {
//                        //极光计数事件（接口连接失败使用）
//                       // JEventUtils.onCountEventError(baseUrl, requestString, bodyString, exception.getMessage());
//                    }
//                }
//
//            }
//
//            @Override
//            public void onSuccess(String baseUrl, String endUrl, Response response) {
//                okhttp3.Response responseRawResponse = response.getRawResponse();
//                String requestString = "";//请求信息
//                String bodyString = "";//返回信息
//                if (responseRawResponse != null) {
//                    if (responseRawResponse.request() != null) {
//                        requestString = responseRawResponse.request().toString();
//                    }
//                    if (responseRawResponse.body() != null) {
//                        bodyString = responseRawResponse.body().toString();
//                    }
//
//                }
//                Log.d(endUrl, "成功啦！请求信息:" + requestString + "\n返回信息：" + bodyString);
//            }
//        });

    }


}
