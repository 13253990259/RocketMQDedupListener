package com.github.jaskey.rocketmq.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RetryWithBackoffExample {

    private static final int INITIAL_DELAY = 1; // 初始延迟时间（单位：秒）
    private static final int MAX_RETRIES = 5; // 最大重试次数

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // 提交任务到线程池
        executorService.submit(() -> {

            if (!makeApiCall()) {
                scheduleRetry(executorService, scheduledExecutorService, INITIAL_DELAY, MAX_RETRIES);
            }
        });

        // 关闭线程池
        /*executorService.shutdown();
        scheduledExecutorService.shutdown();*/
    }

    private static boolean makeApiCall() {


        // 执行需要重试的操作
        // 如果操作失败，返回false，表示需要进行重试
        return false;
    }

    private static void scheduleRetry(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, int delay, int retries) {
        if (retries > 0) {
            System.out.println("Retrying after delay: " + delay + " seconds. Retry count: " + retries);
            scheduledExecutorService.schedule(() -> {
                executorService.submit(() -> {
                    if (!makeApiCall()) {
                        int nextDelay = calculateNextDelay(delay);
                        scheduleRetry(executorService, scheduledExecutorService, nextDelay, retries - 1);
                    }
                });
            }, delay, TimeUnit.SECONDS);
        } else {
            // 达到最大重试次数后的处理逻辑
        }
    }

    private static int calculateNextDelay(int currentDelay) {
        // 根据当前的延迟时间计算下一次的延迟时间
        // 可以使用指数退避等算法来计算
        return currentDelay * 3;
    }
}
