package com.zqy.sdk.superutils.glide.load.resource.file;

import com.zqy.sdk.superutils.glide.load.resource.SimpleResource;

import java.io.File;

/**
 * A simple {@linkcom.zqy.sutils.glide.load.engine.Resource} that wraps a {@link File}.
 */
public class FileResource extends SimpleResource<File> {
    public FileResource(File file) {
        super(file);
    }
}
