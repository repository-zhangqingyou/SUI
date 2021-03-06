package com.zqy.sdk.superutils.logger;

/**
 * @author Orhan Obut
 */
public final class Settings {

    private int methodCount = 2;
    private boolean showThreadInfo = true;

    /**
     * Determines how logs will printed
     */
    private com.zqy.sdk.superutils.logger.LogLevel logLevel = com.zqy.sdk.superutils.logger.LogLevel.FULL;

    public Settings hideThreadInfo() {
        showThreadInfo = false;
        return this;
    }

    public Settings setMethodCount(int methodCount) {
        this.methodCount = methodCount;
        return this;
    }

    public Settings setLogLevel(com.zqy.sdk.superutils.logger.LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
