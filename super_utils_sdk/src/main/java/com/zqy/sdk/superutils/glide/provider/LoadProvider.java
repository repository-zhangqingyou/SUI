package com.zqy.sdk.superutils.glide.provider;

import com.zqy.sdk.superutils.glide.load.model.ModelLoader;
import com.zqy.sdk.superutils.glide.load.resource.transcode.ResourceTranscoder;

/**
 * An extension of {@linkcom.zqy.sutils.glide.provider.DataLoadProvider} that also allows a
 * {@linkcom.zqy.sutils.glide.load.model.ModelLoader} and a
 * {@linkcom.zqy.sutils.glide.load.resource.transcode.ResourceTranscoder} to be retrieved.
 *
 * @param <A> The type of model.
 * @param <T> The type of data that will be decoded from.
 * @param <Z> The type of resource that will be decoded.
 * @param <R> The type of resource that the decoded resource will be transcoded to.
 */
public interface LoadProvider<A, T, Z, R> extends DataLoadProvider<T, Z> {

    /**
     * Returns the {@linkcom.zqy.sutils.glide.load.model.ModelLoader} to convert from the given model to a data type.
     */
    ModelLoader<A, T> getModelLoader();

    /**
     * Returns the {@linkcom.zqy.sutils.glide.load.resource.transcode.ResourceTranscoder} to convert from the decoded
     * and transformed resource into the transcoded resource.
     */
    ResourceTranscoder<Z, R> getTranscoder();
}
