package io.github.lcn29.base.kit.utils;

import io.github.lcn29.base.kit.constants.BaseConstants;

/**
 * <pre>
 * 字符串工具类
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 21:03
 */
public class StringUtil {

    /**
     * 判断字符串如果为空, 返回默认值, 否则返回字符串本身
     *
     * @param content        需要判断的字符串
     * @param defaultContent 默认值
     * @return 需要的字符串
     */
    public static String defaultIfBlank(String content, String defaultContent) {
        if (content == null || content.length() == BaseConstants.INT_ZERO) {
            return defaultContent;
        }
        return content;
    }

}
