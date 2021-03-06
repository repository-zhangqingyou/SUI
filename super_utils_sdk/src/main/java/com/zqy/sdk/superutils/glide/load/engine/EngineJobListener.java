package com.zqy.sdk.superutils.glide.load.engine;

import com.zqy.sdk.superutils.glide.load.Key;

interface EngineJobListener {

    void onEngineJobComplete(Key key, EngineResource<?> resource);

    void onEngineJobCancelled(EngineJob engineJob, Key key);
}
