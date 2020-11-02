package com.zqy.sdk.superutils.glide.load.resource.file;

import com.zqy.sdk.superutils.glide.load.ResourceDecoder;
import com.zqy.sdk.superutils.glide.load.engine.Resource;

import java.io.File;

/**
 * A simple {@linkcom.zqy.sutils.glide.load.ResourceDecoder} that creates resource for a given {@link java.io.File}.
 */
public class FileDecoder implements ResourceDecoder<File, File> {

    @Override
    public Resource<File> decode(File source, int width, int height) {
        return new FileResource(source);
    }

    @Override
    public String getId() {
        return "";
    }
}
