package io.github.lcn29.base.kit.utils;

/**
 * <pre>
 * 数字工具
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 20:43
 */
public class NumberUtil {

    /**
     * 判断一个字符串是否为数字
     *
     * @param str 需要判断的字符串
     * @return true: 是数字, false: 不是
     */
    public static Boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.chars().allMatch(Character::isDigit);
    }
}
