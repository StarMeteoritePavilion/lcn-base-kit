package io.github.lcn29.base.kit.utils;

import io.github.lcn29.base.kit.constants.BaseConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <pre>
 * 分批调用处理
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 20:45
 */
public class PatchInvokeUtil {

    /**
     * 分批次处理
     *
     * @param dataList 需要处理的数据
     * @param limit    分批, 每批的个数
     * @param invoke   分批执行的函数
     * @return 最终的结果
     */
    public static <P, V> List<V> batchInvoke(List<P> dataList, int limit, Function<List<P>, List<V>> invoke) {

        // 没有数据需要处理, 直接返回空的集合
        if (CollectionMapUtil.isEmpty(dataList)) {
            return CollectionMapUtil.emptyList();
        }

        // 需要处理的数据小于等于每批处理的条数, 直接调用
        if (dataList.size() <= limit) {
            return invoke.apply(dataList);
        }

        // 可以分成的批次数
        int handleCount = computeHandCount(dataList.size(), limit);
        // 存放过程的处理的结果, 也就是最终的处理结果
        List<V> resultList = new ArrayList<>(dataList.size());

        for (int index = BaseConstants.INT_ZERO; index <= handleCount; index++) {
            // 获取当前批次需要处理的次数
            List<P> curDataList = curBatchHandleDate(handleCount, index, limit, dataList);
            // 已经为空, 结束
            if (curDataList.isEmpty()) {
                break;
            }

            // 当前批次处理得到的结果
            List<V> tmpResultList = invoke.apply(curDataList);
            if (!CollectionMapUtil.isEmpty(tmpResultList)) {
                resultList.addAll(tmpResultList);
            }
        }
        return resultList;
    }


    /**
     * 分批次处理, 同时获取成功的个数
     *
     * @param dataList 需要处理的数据
     * @param limit    分批, 每批的个数
     * @param invoke   分批执行的函数
     * @return 执行成功的个数
     */
    public static <P> int batchInvokeWithCount(List<P> dataList, int limit, Function<List<P>, Integer> invoke) {

        // 没有数据需要处理
        if (CollectionMapUtil.isEmpty(dataList)) {
            return BaseConstants.INT_ZERO;
        }

        // 需要处理的数据小于等于每批处理的条数, 直接调用
        if (dataList.size() <= limit) {
            return invoke.apply(dataList);
        }

        // 可以分成的批次数
        int handleCount = computeHandCount(dataList.size(), limit);
        // 处理成功的次数
        int successCount = BaseConstants.INT_ZERO;

        for (int index = BaseConstants.INT_ZERO; index <= handleCount; index++) {
            // 获取当前批次需要处理的次数
            List<P> curDataList = curBatchHandleDate(handleCount, index, limit, dataList);
            // 已经为空, 结束
            if (curDataList.isEmpty()) {
                break;
            }
            // 当前批次处理得到的结果
            successCount += invoke.apply(curDataList);
        }
        return successCount;
    }

    /**
     * 计算分批处理, 分批的次数
     *
     * @param dataSize 数据的个数
     * @param limit    每批处理的个数
     * @return 计算得到的分批次数
     */
    private static int computeHandCount(int dataSize, int limit) {
        // 可以分成的批次数
        int handleCount = dataSize / limit;
        if (dataSize % limit != 0) {
            // 最后一次的个数不满, 也需要计算为 1 次
            handleCount++;
        }
        return handleCount;
    }

    /**
     * 获取当前批次处理的数据
     *
     * @param countIndex 总的批次
     * @param curIndex   当前处理的批次
     * @param limit      每批的个数
     * @param dataList   需要处理的数据
     * @return 当前批次需要处理的数据
     */
    private static <T> List<T> curBatchHandleDate(int countIndex, int curIndex, int limit, List<T> dataList) {

        // 当前已经处理的条数
        int hadHandleCount = curIndex * limit;
        // 已经到了最后一个批次, 可能不满 limit, 重新计算当前批次的个数
        int subCount = countIndex == curIndex - BaseConstants.INT_ONE ? dataList.size() - hadHandleCount : limit;
        return dataList.subList(hadHandleCount, hadHandleCount + subCount);
    }

}
