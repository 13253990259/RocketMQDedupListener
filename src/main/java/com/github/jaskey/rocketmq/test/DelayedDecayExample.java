package com.github.jaskey.rocketmq.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DelayedDecayExample {

    private static final int MAX_DELAY_LEVEL = 5; // 最大延迟等级
    private static final int INITIAL_DELAY = 1; // 初始延迟时间（单位：秒）
    private static final int MAX_RETRIES = 3; // 每个延迟等级的最大重试次数

    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduleDecay(INITIAL_DELAY, 1);
    }

    private static void scheduleDecay(int delay, int decayLevel) {
        if (decayLevel > MAX_DELAY_LEVEL) {
            // 达到最大延迟等级后的处理逻辑
            System.out.println("Reached maximum decay level. Aborting.");
            return;
        }

        ScheduledExecutorService decayExecutorService = Executors.newScheduledThreadPool(1);
        Runnable decayTask = () -> {
            System.out.println("Decaying after delay: " + delay + " seconds. Decay level: " + decayLevel);
            // 执行需要执行的操作

            // 判断是否需要进行下一级的延迟衰减
            if (decayLevel < MAX_DELAY_LEVEL) {
                int nextDecayLevel = decayLevel + 1;
                int nextDelay = calculateDelay(nextDecayLevel);
                scheduleDecay(nextDelay, nextDecayLevel);
            }
        };

        ScheduledFuture<?> future = decayExecutorService.schedule(decayTask, delay, TimeUnit.SECONDS);
        decayExecutorService.shutdown();
    }

    private static int calculateDelay(int decayLevel) {
        // 根据延迟等级计算延迟时间
        // 可以使用自定义的策略，例如指数退避等
        return (int) Math.pow(2, decayLevel);
    }
}
