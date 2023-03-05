package io.github.lcn29.base.kit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  集合和 Map 工具类
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 20:47
 */
public class CollectionMapUtil {

    /**
     * 创建一个空的 List
     *
     * @param <T> 泛型类型
     * @return 空的 ArrayList
     */
    public static <T> List<T> emptyList() {
        return new ArrayList<>();
    }

    /**
     * 判断一个 list 是否为空
     *
     * @param list 需要判断的 list
     * @return true: 为空/null, false: 否
     */
    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * 判断一个 map 是否为空
     *
     * @param map 需要判断的 map
     * @return true: 为空/null, false: 否
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
