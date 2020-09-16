/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.RequiresApi;

import com.zqy.googlelib.R;

/**
 * An ImageButton that can display, combine  and filter images. <b>Added in 2.0</b>
 * <p>
 * Subclass of AppCompatImageButton to handle various common filtering operations.
 * </p>
 * <h2>ImageFilterButton attributes</h2>
 * <table summary="KeyTrigger attributes">
 * <tr>
 * <td>altSrc</td>
 * <td>Provide and alternative image to the src image to allow cross fading </td>
 * </tr>
 * <tr>
 * <td>saturation</td>
 * <td>Sets the saturation of the image.<br>  0 = grayscale, 1 = original, 2 = hyper saturated </td>
 * </tr
 * <tr>
 * <td>brightness</td>
 * <td>Sets the brightness of the image.<br>  0 = black, 1 = original, 2 = twice as bright
 * </td>
 * </tr>
 * <tr>
 * <td>warmth</td>
 * <td>This adjust the apparent color temperature of the image.<br> 1=neutral, 2=warm, .5=cold </td>
 * </tr>
 * <tr>
 * <td>contrast</td>
 * <td>This sets the contrast. 1 = unchanged, 0 = gray, 2 = high contrast</td>
 * </tr>
 * <tr>
 * <td>crossfade</td>
 * <td>Set the current mix between the two images. <br>  0=src 1= altSrc image </td>
 * </tr>
 * <tr>
 * <td>round</td>
 * <td>(id) call the TransitionListener with this trigger id</td>
 * </tr>
 * <tr>
 * <td>roundPercent &nbs; </td>
 * <td>Set the corner radius of curvature  as a fraction of the smaller side.
 *    For squares 1 will result in a circle</td>
 * </tr>
 * <tr>
 * <td>overlay</td>
 * <td>Defines whether the alt image will be faded in on top of the original image or if it will be
 * crossfaded with it. Default is true. Set to false for semitransparent objects</td>
 * </tr>
 * </table>
 */
public class ImageFilterButton extends androidx.appcompat.widget.AppCompatImageButton {
    private ImageFilterView.ImageMatrix mImageMatrix = new ImageFilterView.ImageMatrix();
    private float mCrossfade = 0;
    private float mRoundPercent = 0; // rounds the corners as a percent
    private float mRound = Float.NaN; // rounds the corners in dp if NaN RoundPercent is in effect
    private Path mPath;
    ViewOutlineProvider mViewOutlineProvider;
    RectF mRect;

    Drawable[] mLayers;
    LayerDrawable mLayer;
    private boolean mOverlay = true;

    public ImageFilterButton(Context context) {
        super(context);
        init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ImageFilterButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setPadding(0, 0, 0, 0);
        if (attrs != null) {
            TypedArray a = getContext()
                    .obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            final int N = a.getIndexCount();
            Drawable drawable = a.getDrawable(R.styleable.ImageFilterView_altSrc);

            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.ImageFilterView_crossfade) {
                    mCrossfade = a.getFloat(attr, 0);
                } else if (attr == R.styleable.ImageFilterView_warmth) {
                    setWarmth(a.getFloat(attr, 0));
                } else if (attr == R.styleable.ImageFilterView_saturation) {
                    setSaturation(a.getFloat(attr, 0));
                } else if (attr == R.styleable.ImageFilterView_contrast) {
                    setContrast(a.getFloat(attr, 0));
                } else if (attr == R.styleable.ImageFilterView_round) {
                    setRound(a.getDimension(attr, 0));
                } else if (attr == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(a.getFloat(attr, 0));
                } else if (attr == R.styleable.ImageFilterView_overlay) {
                    setOverlay(a.getBoolean(attr, mOverlay));
                }
            }
            a.recycle();

            if (drawable != null) {
                mLayers = new Drawable[2];
                mLayers[0] = getDrawable();
                mLayers[1] = drawable;

                mLayer = new LayerDrawable(mLayers);
                mLayer.getDrawable(1).setAlpha((int) (255 * (mCrossfade)));
                super.setImageDrawable(mLayer);
            }
        }
    }

    /**
     * Defines whether the alt image will be faded in on top of the original image or if it will be
     * crossfaded with it. Default is true.
     *
     * @param overlay
     */
    private void setOverlay(boolean overlay) {
        mOverlay = overlay;
    }

    /**
     * sets the saturation of the image;
     * 0 = grayscale, 1 = original, 2 = hyper saturated
     *
     * @param saturation
     */

    public void setSaturation(float saturation) {
        mImageMatrix.mSaturation = saturation;
        mImageMatrix.updateMatrix(this);
    }

    /**
     * Returns the currently applied saturation
     *
     * @return 0 = grayscale, 1 = original, 2 = hyper saturated
     */
    public float getSaturation() {
        return mImageMatrix.mSaturation;
    }

    /**
     * This sets the contrast. 1 = unchanged, 0 = gray, 2 = high contrast
     *
     * @param contrast
     */
    public void setContrast(float contrast) {
        mImageMatrix.mContrast = contrast;
        mImageMatrix.updateMatrix(this);
    }

    /**
     * Returns the currently applied contrast
     *
     * @return 1 = unchanged, 0 = gray, 2 = high contrast
     */
    public float getContrast() {
        return mImageMatrix.mContrast;
    }

    /**
     * This makes the apparent color temperature of the image warmer or colder.
     *
     * @param warmth 1 is neutral, 2 is warm, .5 is cold
     */
    public void setWarmth(float warmth) {
        mImageMatrix.mWarmth = warmth;
        mImageMatrix.updateMatrix(this);
    }

    /**
     * Returns the currently applied warmth
     *
     * @return warmth 1 is neutral, 2 is warm, .5 is cold
     */
    public float getWarmth() {
        return mImageMatrix.mWarmth;
    }

    /**
     * Set the current mix between the two images that can be set on this view.
     *
     * @param crossfade a number from 0 to 1
     */
    public void setCrossfade(float crossfade) {
        mCrossfade = crossfade;
        if (mLayers != null) {
            if (!mOverlay) {
                mLayer.getDrawable(0).setAlpha((int) (255 * (1 - mCrossfade)));
            }
            mLayer.getDrawable(1).setAlpha((int) (255 * (mCrossfade)));
            super.setImageDrawable(mLayer);
        }
    }

    /**
     * Returns the currently applied crossfade.
     *
     * @return a number from 0 to 1
     */
    public float getCrossfade() {
        return mCrossfade;
    }

    /**
     * sets the brightness of the image;
     * 0 = black, 1 = original, 2 = twice as bright
     *
     * @param brightness
     */

    public void setBrightness(float brightness) {
        mImageMatrix.mBrightness = brightness;
        mImageMatrix.updateMatrix(this);
    }

    /**
     * Set the corner radius of curvature  as a fraction of the smaller side.
     * For squares 1 will result in a circle
     *
     * @param round the radius of curvature as a fraction of the smaller width
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public void setRoundPercent(float round) {
        boolean change = (mRoundPercent != round);
        mRoundPercent = round;
        if (mRoundPercent != 0.0f) {
            if (mPath == null) {
                mPath = new Path();
            }
            if (mRect == null) {
                mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (mViewOutlineProvider == null) {
                    mViewOutlineProvider = new ViewOutlineProvider() {
                        @Override
                        public void getOutline(View view, Outline outline) {
                            int w = getWidth();
                            int h = getHeight();
                            float r = Math.min(w, h) * mRoundPercent / 2;
                            outline.setRoundRect(0, 0, w, h, r);
                        }
                    };
                    setOutlineProvider(mViewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int w = getWidth();
            int h = getHeight();
            float r = Math.min(w, h) * mRoundPercent / 2;
            mRect.set(0, 0, w, h);
            mPath.reset();
            mPath.addRoundRect(mRect, r, r, Path.Direction.CW);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setClipToOutline(false);
            }
        }
        if (change) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                invalidateOutline();
            }
        }

    }

    /**
     * Set the corner radius of curvature
     *
     * @param round the radius of curvature  NaN = default meaning roundPercent in effect
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            mRound = round;
            float tmp = mRoundPercent;
            mRoundPercent = -1;
            setRoundPercent(tmp); // force eval of roundPercent
            return;
        }
        boolean change = (mRound != round);
        mRound = round;

        if (mRound != 0.0f) {
            if (mPath == null) {
                mPath = new Path();
            }
            if (mRect == null) {
                mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (mViewOutlineProvider == null) {
                    mViewOutlineProvider = new ViewOutlineProvider() {
                        @Override
                        public void getOutline(View view, Outline outline) {
                            int w = getWidth();
                            int h = getHeight();
                            outline.setRoundRect(0, 0, w, h, mRound);
                        }
                    };
                    setOutlineProvider(mViewOutlineProvider);
                }
                setClipToOutline(true);

            }
            int w = getWidth();
            int h = getHeight();
            mRect.set(0, 0, w, h);
            mPath.reset();
            mPath.addRoundRect(mRect, mRound, mRound, Path.Direction.CW);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setClipToOutline(false);
            }
        }
        if (change) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                invalidateOutline();
            }
        }

    }

    /**
     * Get the fractional corner radius of curvature.
     *
     * @return Fractional radius of curvature with respect to smallest size
     */
    public float getRoundPercent() {
        return mRoundPercent;
    }

    /**
     * Get the corner radius of curvature NaN = RoundPercent in effect.
     *
     * @return Radius of curvature
     */
    public float getRound() {
        return mRound;
    }

    @Override
    public void draw(Canvas canvas) {
        boolean clip = false;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (mRound != 0.0f && mPath != null) {
                clip = true;
                canvas.save();
                canvas.clipPath(mPath);
            }
        }
        super.draw(canvas);
        if (clip) {
            canvas.restore();
        }
    }
}
