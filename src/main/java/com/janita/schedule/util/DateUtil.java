package com.janita.schedule.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Janita on 2017/3/14
 */
public class DateUtil {

    public static String FMT_HH_mm_ss_SSS = "HH:mm:ss.SSS";
    public static String FMT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化毫秒时间戳，输出时分秒
     *
     * @param timestampInMs
     * @return
     */
    public static String fmtHMSS(Long timestampInMs) {
        if (timestampInMs == null) {
            return "";
        }
        return new SimpleDateFormat(DateUtil.FMT_HH_mm_ss_SSS).format(new Date(timestampInMs));
    }

    /**
     * 格式化毫秒时间戳，输出到秒
     *
     * @param timestampInMs
     * @return
     */
    public static String fmtTime(Long timestampInMs) {
        if (timestampInMs == null) {
            return "";
        }
        return new SimpleDateFormat(DateUtil.FMT_yyyy_MM_dd_HH_mm_ss).format(new Date(timestampInMs));
    }
}
