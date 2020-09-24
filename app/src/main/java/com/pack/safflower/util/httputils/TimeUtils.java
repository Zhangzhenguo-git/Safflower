package com.pack.safflower.util.httputils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtils {
    private static TimeUtils timeUtils;

    public static TimeUtils getInstance() {
        if (null == timeUtils) {
            timeUtils = new TimeUtils();
        }
        return timeUtils;
    }

    /**
     * @return //XXXX年XX月XX日 星期X
     */
    public String StringData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear;
        String mMonth;
        String mDay;
        String mWay;
        //获取当前年份
        mYear = String.valueOf(c.get(Calendar.YEAR));
        // 获取当前月份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);
        // 获取当前月份的日期号码
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));

        return mYear + "年" + mMonth + "月" + mDay + "日" + "星期" + getWay(mWay);
    }

    private String getWay(String mWay) {
        String[] ways = {"日", "一", "二", "三", "四", "五", "六"};
        return ways[Integer.parseInt(mWay) - 1];
    }

    public String getStringNowDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public String getStringNowDate(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 获取年
     */
    public String getStringNowYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 字符串转日期
     */
    public Date parseServerTime(String serverTime, String format) {
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINESE);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        Date date = null;
        try {
            date = sdf.parse(serverTime);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 日期转字符串
     */
    public String getDateStr(Date date, String format) {
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 毫秒转字符串日期
     */
    public String timeStampToDate(long tsp, String format) {
        SimpleDateFormat sdf;
        if (format == null && format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        } else {
            sdf = new SimpleDateFormat(format, Locale.getDefault());
        }
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return sdf.format(tsp);
    }

    /**
     * 毫秒转字符串日期
     */
    public String timeStampToDate(long tsp, String format, TimeZone zone) {
        SimpleDateFormat sdf;
        if (format == null && format.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        } else {
            sdf = new SimpleDateFormat(format, Locale.getDefault());
        }
        sdf.setTimeZone(zone);
        return sdf.format(tsp);
    }

    /**
     * 将毫秒转时分秒
     */
    public String generateTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * HH:mm:ss 转秒
     */
    public int returnSeconde(String instr) {
        String[] a = instr.split("\\.");
        String[] b = a[0].split(":");
        return Integer.valueOf(b[0]) * 60 * 60 + Integer.valueOf(b[1]) * 60
                + Integer.valueOf(b[2]);
    }

    /**
     * 秒转时间
     */
    public String FormatRunTime(long runTime) {
        if (runTime < 0) {
            return "00:00:00";
        }

        long hour = runTime / 3600;
        long minute = (runTime % 3600) / 60;
        long second = runTime % 60;

        return unitTimeFormat(hour) + ":" + unitTimeFormat(minute) + ":" +
                unitTimeFormat(second);
    }

    private static String unitTimeFormat(long number) {
        return String.format("%02d", number);
    }

}
