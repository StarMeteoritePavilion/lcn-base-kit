package io.github.lcn29.base.kit.utils;

import io.github.lcn29.base.kit.constants.BaseConstants;

import java.util.UUID;

/**
 * <pre>
 * UUID 工具类
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 21:05
 */
public class UuidUtil {


    /**
     * 获取 UUID 字符串
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace(BaseConstants.CROSS_BAR, BaseConstants.EMPTY_STRING);
    }

}
