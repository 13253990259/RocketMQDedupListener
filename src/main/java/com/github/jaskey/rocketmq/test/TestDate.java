package com.github.jaskey.rocketmq.test;

import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        long startTimestampOfDate = getStartTimestampOfDate(System.currentTimeMillis());
        System.out.println(startTimestampOfDate);

        final long finalTotalCount = 100001;
        int end = (int) Math.min(5000000, finalTotalCount);
        System.out.println(end);

        long l1 = 1L << 0L;
        System.out.println(l1);
        long l = 1L << 1L;
        System.out.println(l);
        long l4 = 1L << 4L;
        System.out.println(l4);
        long l5 = 1L << 5L;
        System.out.println(l5);
        long l6 = 1L << 6L;
        System.out.println(l6);
        long l58 = 1L << 58L;
        System.out.println(l58);
        long l59 = 1L << 59L;
        System.out.println(l59);



    }

    public static long getStartTimestampOfDate(long timestamp) {
        return getStartTimestampOfDate(new Date(timestamp));
    }

    public static long getStartTimestampOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900 + date.getYear(), date.getMonth(), date.getDate(), 0, 0, 0);
        return calendar.getTimeInMillis() / 1000 * 1000;
    }
}
