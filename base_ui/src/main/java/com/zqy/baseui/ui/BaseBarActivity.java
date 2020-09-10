package com.zqy.baseui.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjy.baseui.R;
import com.zqy.baseui.ui.view.imageview.ColorStateImageView;

/**
 * 作者: zhangqingyou 申请
 * 时间: 2020/7/21 10:17
 * 描述: 带Toobar View的Activity
 */
public abstract class BaseBarActivity extends BaseActivity {


    private ColorStateImageView mIvBackImageBar;
    /**
     * xxxx
     */
    private TextView mTvTextBar;
    private LinearLayout mLlBar;


    /**
     * @param title
     */
    public View getTooBarView(String title, View.OnClickListener onBackImageBarClickListener) {
        View inflate = View.inflate(getContext(), R.layout.bui_bar_black_white, null);
        mIvBackImageBar = inflate.findViewById(R.id.iv_back_image_bar);
        mTvTextBar = inflate.findViewById(R.id.tv_text_bar);
        mLlBar = inflate.findViewById(R.id.ll_bar);
        if (title != null)
            mTvTextBar.setText(title);
        mIvBackImageBar.setOnClickListener(onBackImageBarClickListener);

        return inflate;
    }


}