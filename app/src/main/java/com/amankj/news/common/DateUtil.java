package com.amankj.news.common;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    private static final String TAG = DateUtil.class.getSimpleName();

    public static String YYYY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static String MMM_DD_YYYY_HH_MM_A = "MMM dd, yyyy hh:mm a";

    public static String formatUTCDateToLocal(String dateStr, String prevFormat, String reqFormat) {
        Log.d(TAG, "formatDate");

        SimpleDateFormat pf = new SimpleDateFormat(prevFormat, Locale.ENGLISH);
        pf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = pf.parse(dateStr);
        } catch (ParseException e) {
            Log.e(TAG, e.getMessage());
        }
        pf.setTimeZone(TimeZone.getDefault());

        SimpleDateFormat rf = new SimpleDateFormat(reqFormat, Locale.ENGLISH);

        return rf.format(date);
    }
}
