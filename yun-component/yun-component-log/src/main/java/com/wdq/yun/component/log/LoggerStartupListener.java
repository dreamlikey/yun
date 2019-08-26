package com.wdq.yun.component.log;

import com.ctrip.framework.apollo.internals.RemoteConfigRepository;

import java.util.Properties;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wudq
 * @date 2019/8/26
 * @Description: logback动态配置
 */
@Slf4j
public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {

    private boolean started = false;

    private final String namespace = "TEST1.logback";

    private static final String LOG_LEVEL_KEY = "log.root.level";
    private static final String LOG_PATH_KEY = "log.path";
    private static final String ENV = "dev";

    @Override
    public boolean isResetResistant() {
        return false;
    }

    @Override
    public void onStart(LoggerContext context) {

    }

    @Override
    public void onReset(LoggerContext context) {

    }

    @Override
    public void onStop(LoggerContext context) {

    }

    @Override
    public void onLevelChange(Logger logger, Level level) {

    }

    @Override
    public void start() {
        if (started) {
            return;
        }
        //apollo远程配置
        RemoteConfigRepository  logbackConfigRepository = new RemoteConfigRepository(namespace);
        Properties properties = logbackConfigRepository.getConfig();
        //logback context赋值
        Context context = getContext();
        context.putProperty("level", properties.getProperty(LOG_LEVEL_KEY, "error"));
        context.putProperty("path", properties.getProperty(LOG_PATH_KEY, ""));
        context.putProperty("env", properties.getProperty(ENV, "dev"));
        started = true;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }

}
