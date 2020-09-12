package com.zqy.baseui.ui.view.textview;

/**
 * 万能样式 SuperDrawable
 * <p>
 * 1.支持圆角 四个角可以单独设置
 * 2.支持描边大小、描边颜色
 * 3.支持点击颜色变化设置
 * <p>
 * Author: zhangqingyou
 * Date: 2020/4/28 9:21
 * Des:
 */
public class TextViewDrawable {

//    private float clickAlpha;//按下时 背景颜色和字体颜色 透明度
//
//    public Drawable initStateListDrawable(Context context, AttributeSet attrs) {
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SuperTextView_Copy);
//        clickAlpha = typedArray.getFloat(R.styleable.SuperTextView_Copy_zqy_stv_clickAlpha, 0.7f);
//
//        int colorBg = typedArray.getColor(R.styleable.SuperTextView_Copy_zqy_stv_backgroundColor, Color.TRANSPARENT);
//        int colorBorder = typedArray.getColor(R.styleable.SuperTextView_Copy_zqy_stv_borderColor, Color.TRANSPARENT);
//        int startColor = typedArray.getColor(R.styleable.SuperTextView_Copy_zqy_stv_startColor, Color.TRANSPARENT);
//        int endColor = typedArray.getColor(R.styleable.SuperTextView_Copy_zqy_stv_endColor, Color.TRANSPARENT);
//        int clickColorBg = typedArray.getColor(R.styleable.SuperTextView_Copy_zqy_stv_clickColorBg,Color.TRANSPARENT);
//        int clickColorBorder = typedArray.getColor(R.styleable.SuperTextView_Copy_zqy_stv_clickColorBorder, Color.TRANSPARENT);
//        int gradient = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_gradient, -1);
//        int orientation = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_orientation, -1);
//        int borderWidth = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_borderWidth, 0);
//        boolean isRadiusAdjustBounds = typedArray.getBoolean(R.styleable.SuperTextView_Copy_zqy_stv_isRadiusAdjustBounds, false);
//        int mRadius = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_radius, 5);
//        int mRadiusTopLeft = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_radiusTopLeft, 0);
//        int mRadiusTopRight = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_radiusTopRight, 0);
//        int mRadiusBottomLeft = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_radiusBottomLeft, 0);
//        int mRadiusBottomRight = typedArray.getInt(R.styleable.SuperTextView_Copy_zqy_stv_radiusBottomRight, 0);
//
//        typedArray.recycle();
//
//        GradientDrawable.Orientation orientation1 = GradientDrawable.Orientation.TOP_BOTTOM;
//        GradientDrawable.Orientation[] values = GradientDrawable.Orientation.values();
//        for (GradientDrawable.Orientation value : values) {
//            if (value.ordinal() == orientation) {
//                orientation1 = value;
//            }
//        }
//
//
//        /**
//         * @param colorBg              未点击状态背景色
//         * @param colorBorder          未点击状态的描边色
//         * @param clickColorBg         点击状态背景色
//         * @param clickColorBorder     点击状态的边框色
//         * @param gradient             设置线性渐变，除此之外还有：GradientDrawable.SWEEP_GRADIENT（扫描式渐变），GradientDrawable.RADIAL_GRADIENT（圆形渐变）
//         * @param colors               设置渐变颜色
//         * @param orientation          设置渐变方向
//         * @param borderWidth          边框宽度
//         * @param isRadiusAdjustBounds 设置圆角大小是否自动适应为 View 的高度的一半
//         * @param radius               四角圆形度数
//         * @param radiusTopLeft        左上圆形度数
//         * @param radiusTopRight       右上圆形度数
//         * @param radiusBottomLeft     左下圆形度数
//         * @param radiusBottomRight    右下圆形度数
//         * @return
//         */
//        SuperStateListDrawable superStateListDrawable = new SuperStateListDrawable().setClickAlpha(clickAlpha)
//                .setRadius(mRadius)
//                .setBorderWidth(borderWidth)
//                .setRadiusAdjustBounds(isRadiusAdjustBounds)
//                .setRadiusBottomLeft(mRadiusBottomLeft)
//                .setRadiusBottomRight(mRadiusBottomRight)
//                .setRadiusTopLeft(mRadiusTopLeft)
//                .setRadiusTopRight(mRadiusTopRight)
//                .setColorBg(colorBg)
//                .setColorBorder(colorBorder)
//                .setClickColorBg(clickColorBg)
//                .setClickColorBorder(clickColorBorder);
//
//        if (startColor != 0 && endColor != 0) {
//            superStateListDrawable
//                    .setSGradientType(gradient)
//                    .setSColors(new int[]{startColor, endColor})
//                    .setSOrientation(orientation1);
//        }
//        return superStateListDrawable.buid();
//    }
//
//    public float getClickAlpha() {
//        return clickAlpha;
//    }
}
