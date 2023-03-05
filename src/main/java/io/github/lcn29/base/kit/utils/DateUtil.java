package io.github.lcn29.base.kit.utils;

import io.github.lcn29.base.kit.constants.BaseConstants;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * <pre>
 * 时间工具类
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 20:31
 */
public class DateUtil {

    /**
     * 时间格式器
     * DateTimeFormatter: 线程安全
     */
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(BaseConstants.DATE_FORMAT);
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(BaseConstants.DATE_TIME_FORMAT);
    private final static DateTimeFormatter YEAR_MONTH_WITHOUT_DELIMITER_FORMATTER = DateTimeFormatter.ofPattern(BaseConstants.YEAR_MONTH_WITHOUT_DELIMITER_FORMAT);

    /**
     * 字符串转 localDate, 格式： yyyy-MM-dd
     *
     * @param stringDate 需要转换的字符串
     * @return localDate
     */
    public static LocalDate string2LocalDate(String stringDate) {
        return LocalDate.parse(stringDate, DATE_TIME_FORMATTER);
    }

    /**
     * 字符串转 localDate, 格式： yyyy-MM-dd HH:mm:ss
     *
     * @param stringDateTime 需要转换的字符串
     * @return localDateTime
     */
    public static LocalDateTime string2LocalDateTime(String stringDateTime) {
        return LocalDateTime.parse(stringDateTime, DATE_TIME_FORMATTER);
    }

    /**
     * long 转 localDate
     *
     * @param longTime long 时间
     * @return localDate
     */
    public static LocalDate long2LocalDate(Long longTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(longTime), ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * long 转 localDateTime
     *
     * @param longTime long 时间
     * @return localDateTime
     */
    public static LocalDateTime long2LocalDateTime(Long longTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(longTime), ZoneId.systemDefault());
    }

    /**
     * localDate  转 long
     *
     * @param localDate localDate  时间
     * @return 转换后的 long 类型时间戳
     */
    public static Long localDate2Long(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * localDateTime 转 long
     *
     * @param localDateTime localDateTime 时间
     * @return 转换后的 long 类型时间戳
     */
    public static Long localDateTime2Long(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * localDate 转字符串, 格式： yyyy-MM-dd
     *
     * @param localDate 需要转换的 localDate 对象
     * @return 转换后的字符串
     */
    public static String localDate2String(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    /**
     * localDateTime 转字符串, 格式： yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime 需要转换的 LocalDateTime 对象
     * @return 转换后的字符串
     */
    public static String localDateTime2String(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * localDateTime 转字符串, 格式： yyyyMM
     *
     * @param localDateTime 需要转换的 LocalDateTime 对象
     * @return 转换后的字符串
     */
    public static String localDateTime2YearMonthString(LocalDateTime localDateTime) {
        return localDateTime.format(YEAR_MONTH_WITHOUT_DELIMITER_FORMATTER);
    }

    /**
     * 获取指定时间的开始时间点
     *
     * @param changeLocalDateTime 需要转换的时间
     * @return 指定时间的开始时间点 yyyy:MM:dd 00:00:00
     */
    public static LocalDateTime getDateStartLocalDateTime(LocalDateTime changeLocalDateTime) {
        return LocalDateTime.of(changeLocalDateTime.toLocalDate(), LocalTime.MIN);
    }

    /**
     * 获取指定时间的结束时间点
     *
     * @param changeLocalDateTime 需要转换的时间
     * @return 指定时间的开始时间点 yyy:MM:dd 23:59:59
     */
    public static LocalDateTime getDateEndLocalDateTime(LocalDateTime changeLocalDateTime) {
        return LocalDateTime.of(changeLocalDateTime.toLocalDate(), LocalTime.MAX);
    }

    /**
     * 获取本周周一的开始时间点
     *
     * @return 本周周一的开始时间点
     */
    public static LocalDateTime getMondayLocalDateTimeInThisWeek() {
        return LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();
    }

    /**
     * 获取上周周一的开始时间点
     *
     * @return 上周周一的开始时间点 yyyy:MM:dd 00:00:00
     */
    public static LocalDateTime getMondayStartTimeInLastWeek() {
        //获取当前时间
        LocalDate local = LocalDate.now();
        // 获取今天是周几
        DayOfWeek dayOfWeek = local.getDayOfWeek();
        // 算出上周一
        LocalDate lastMonday = local.minusDays((7 + dayOfWeek.getValue() - 1));
        return LocalDateTime.of(lastMonday, LocalTime.MIN);
    }

    /**
     * 获取上周周日的结束时间点
     *
     * @return 上周周日的结束时间点 yyyy-MM-dd 23:59:59
     */
    public static LocalDateTime getSundayEndTimeInLastWeek() {
        //获取当前时间
        LocalDate local = LocalDate.now();
        // 获取今天是周几
        DayOfWeek dayOfWeek = local.getDayOfWeek();
        // 算出上周日
        LocalDate lastSunday = local.minusDays(dayOfWeek.getValue());
        return LocalDateTime.of(lastSunday, LocalTime.MAX);
    }

    /**
     * 获取本月第一天的开始时间点
     *
     * @return 本月第一天的开始时间点 yyyy-MM-dd 00:00:00
     */
    public static LocalDateTime getFirstDayStartTimeInThisMonth() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN).with(TemporalAdjusters.firstDayOfMonth());
    }
}
