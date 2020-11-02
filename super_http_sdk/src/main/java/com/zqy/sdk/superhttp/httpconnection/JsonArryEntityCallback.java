package com.zqy.sdk.superhttp.httpconnection;

import com.zqy.sdk.superhttp.SuperHttpManage;
import com.zqy.sdk.superutils.core.ParameterizedTypeImpl;
import com.zqy.sdk.superutils.gson.Gson;
import com.zqy.sdk.superutils.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


/**
 * Author: zhangqingyou
 * Date: 2020/5/22
 * Des:
 * <p>
 * json为数组时使用
 *
 * @param <T> json对象实体类
 */

public abstract class JsonArryEntityCallback<T> extends StringDataCallBack {
    private Class<T> classOfBean;//json对象实体

    public JsonArryEntityCallback(Class<T> classOfBean) {
        this.classOfBean = classOfBean;
    }

    public JsonArryEntityCallback(Class<T> classOfBean, String requestName) {
        super(requestName);
        this.classOfBean = classOfBean;
    }

    @Override
    public void onUIStart(String url, Map<String, String> headers, Map<String, String> requestParameters) {

    }

    @Override
    public void onUIFinish(String msg) {

    }

    /**
     * 请求成功
     *
     * @param response
     */
    @Override
    public void onUISuccess(String response) {
        try {
            //泛型转换
            Type type = new ParameterizedTypeImpl(classOfBean);
            List<T> list = new Gson().fromJson(response, type);
            onUISuccessEntity(list);
        } catch (JsonSyntaxException e) {
            if (SuperHttpManage.getHttpApiCallback() != null) {
                SuperHttpManage.getHttpApiCallback().onError(getBaseUrl(), getEndUrl(), "json数据格式错误:" + e.getMessage());
            }

        }
    }

    /**
     * 返回数据进行操作的回调， UI线程
     */
    public abstract void onUISuccessEntity(List<T> tList);


}
