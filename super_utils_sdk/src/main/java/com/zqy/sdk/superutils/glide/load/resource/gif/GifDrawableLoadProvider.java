package com.zqy.sdk.superutils.glide.load.resource.gif;

import android.content.Context;

import com.zqy.sdk.superutils.glide.load.Encoder;
import com.zqy.sdk.superutils.glide.load.ResourceDecoder;
import com.zqy.sdk.superutils.glide.load.ResourceEncoder;
import com.zqy.sdk.superutils.glide.load.engine.bitmap_recycle.BitmapPool;
import com.zqy.sdk.superutils.glide.load.model.StreamEncoder;
import com.zqy.sdk.superutils.glide.load.resource.file.FileToStreamDecoder;
import com.zqy.sdk.superutils.glide.provider.DataLoadProvider;

import java.io.File;
import java.io.InputStream;

/**
 * An {@linkcom.zqy.sutils.glide.provider.DataLoadProvider} that loads an {@link java.io.InputStream} into
 * {@linkcom.zqy.sutils.glide.load.resource.gif.GifDrawable} that can be used to display an animated GIF.
 */
public class GifDrawableLoadProvider implements DataLoadProvider<InputStream, GifDrawable> {
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;
    private final FileToStreamDecoder<GifDrawable> cacheDecoder;

    public GifDrawableLoadProvider(Context context, BitmapPool bitmapPool) {
        decoder = new GifResourceDecoder(context, bitmapPool);
        cacheDecoder = new FileToStreamDecoder<GifDrawable>(decoder);
        encoder = new GifResourceEncoder(bitmapPool);
        sourceEncoder = new StreamEncoder();
    }

    @Override
    public ResourceDecoder<File, GifDrawable> getCacheDecoder() {
        return cacheDecoder;
    }

    @Override
    public ResourceDecoder<InputStream, GifDrawable> getSourceDecoder() {
        return decoder;
    }

    @Override
    public Encoder<InputStream> getSourceEncoder() {
        return sourceEncoder;
    }

    @Override
    public ResourceEncoder<GifDrawable> getEncoder() {
        return encoder;
    }
}
