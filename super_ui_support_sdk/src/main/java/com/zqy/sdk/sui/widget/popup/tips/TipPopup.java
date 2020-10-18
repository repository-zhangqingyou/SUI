package com.zqy.sdk.sui.widget.popup.tips;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zqy.sdk.utils.core.ResourcesUtil;

/**
 * 作者: zhangqingyou
 * 时间: 2020/7/14 14:26
 * 描述: 提示PopupWindow
 */
public class TipPopup extends BaseTipsPopup {

    private TextView mToastMsg;
    private LinearLayout mLlRootView;

    public TipPopup(Activity activity) {
        super(activity);

    }

    public TipPopup(Activity activity, int width, int height) {
        super(activity, width, height);
    }

    @Override
    public Object getLayout() {
        return ResourcesUtil.getLayoutId("sui_tip_popup");
    }

    @Override
    public void initView(View rootView) {
        mToastMsg = findViewById(ResourcesUtil.getId("toast_msg"));
        mLlRootView = findViewById(ResourcesUtil.getId("ll_RootView"));
    }

    @Override
    public void initData() {

    }

    @Override
    public void listener() {

    }

    public void setText(String text) {
        if (text == null) text = "";
        mToastMsg.setText(text);
    }

}
