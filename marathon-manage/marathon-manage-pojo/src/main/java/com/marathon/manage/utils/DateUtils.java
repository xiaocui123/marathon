package com.marathon.manage.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cui on 2017/5/17.
 */
public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String convert(Date date) {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    public static Date convert(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
