package com.github.jaskey.rocketmq.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DelayedRetryExample2 {

    private static final int MAX_DELAY_LEVEL = 5; // 最大延迟等级
    private static final int INITIAL_DELAY = 1; // 初始延迟时间（单位：秒）
    private static final int MAX_RETRIES = 3; // 最大重试次数

    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduleRetry(INITIAL_DELAY, 1);
    }

    private static void scheduleRetry(int delay, int retryCount) {
        if (retryCount > MAX_RETRIES) {
            // 达到最大重试次数后的处理逻辑
            System.out.println("Reached maximum retry count. Aborting.");
            return;
        }

        ScheduledFuture<?> future = executorService.schedule(() -> {
            System.out.println("Retrying after delay: " + delay + " seconds. Retry count: " + retryCount);
            // 执行需要重试的操作
            boolean success = makeApiCall();

            if (!success) {
                int nextDelayLevel = calculateNextDelayLevel(delay);
                int nextRetryCount = retryCount + 1;
                int nextDelay = calculateDelay(nextDelayLevel);

                scheduleRetry(nextDelay, nextRetryCount);
            }
        }, delay, TimeUnit.SECONDS);
    }

    private static boolean makeApiCall() {
        // 执行需要重试的操作
        // 如果操作失败，返回false，表示需要进行重试
        return false;
    }

    private static int calculateNextDelayLevel(int currentDelay) {
        // 根据当前的延迟时间计算下一个延迟等级
        int nextDelayLevel = currentDelay + 1;
        if (nextDelayLevel > MAX_DELAY_LEVEL) {
            nextDelayLevel = MAX_DELAY_LEVEL;
        }
        return nextDelayLevel;
    }

    private static int calculateDelay(int delayLevel) {
        // 根据延迟等级计算延迟时间
        // 可以使用自定义的策略，例如指数退避等
        return (int) Math.pow(2, delayLevel);
    }
}
