package club.codehero.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换工具
 *
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/18 13:17
 */
public class DateUtils {

    /**
     * 日期转换成字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static Date stringToDate(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateStr);
        return date;
    }
}
