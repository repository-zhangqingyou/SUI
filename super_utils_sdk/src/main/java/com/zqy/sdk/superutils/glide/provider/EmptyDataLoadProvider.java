package com.zqy.sdk.superutils.glide.provider;

import com.zqy.sdk.superutils.glide.load.Encoder;
import com.zqy.sdk.superutils.glide.load.ResourceDecoder;
import com.zqy.sdk.superutils.glide.load.ResourceEncoder;

import java.io.File;

/**
 * A {@linkcom.zqy.sutils.glide.provider.DataLoadProvider} that returns {@code null} for every class.
 *
 * @param <T> unused data type.
 * @param <Z> unused resource type.
 */
public class EmptyDataLoadProvider<T, Z> implements DataLoadProvider<T, Z> {
    private static final DataLoadProvider<?, ?> EMPTY_DATA_LOAD_PROVIDER = new EmptyDataLoadProvider<Object, Object>();

    @SuppressWarnings("unchecked")
    public static <T, Z> DataLoadProvider<T, Z> get() {
        return (DataLoadProvider<T, Z>) EMPTY_DATA_LOAD_PROVIDER;
    }

    @Override
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return null;
    }

    @Override
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return null;
    }

    @Override
    public Encoder<T> getSourceEncoder() {
        return null;
    }

    @Override
    public ResourceEncoder<Z> getEncoder() {
        return null;
    }
}
