package io.github.lcn29.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * 集合工具类
 *
 * @author canxin.li
 * @date 2024-08-29 16:30:30
 */
public class CollectionUtils {

    /**
     * 判断集合是否为空
     *
     * @param list 集合
     * @return 是否为空
     */
    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * 获取空 List
     *
     * @param <T> 集合元素类型
     * @return 空集合
     */
    public static <T> List<T> emptyList() {
        return Collections.emptyList();
    }

    /**
     * 获取空 List
     *
     * @param isMutable 是否是不可变 map
     * @param <T>       集合元素类型
     * @return 空 List
     */
    public static <T> List<T> emptyList(boolean isMutable) {
        if (isMutable) {
            return new ArrayList<>();
        }
        return emptyList();
    }

    /**
     * 切割集合
     *
     * @param list 集合
     * @param size 切割大小
     * @param <T>  集合元素类型
     * @return 切割后的集合
     */
    public static <T> List<List<T>> splitList(List<T> list, int size) {

        if (isEmpty(list)) {
            return new ArrayList<>();
        }
        if (list.size() <= size) {
            List<List<T>> result = new ArrayList<>();
            result.add(list);
            return result;
        }

        List<List<T>> result = new ArrayList<>();

        int totalSize = list.size();
        int count = totalSize / size;
        for (int i = 0; i < count; i++) {
            result.add(list.subList(i * size, (i + 1) * size));
        }

        int remainder = totalSize % size;
        if (remainder > 0) {
            result.add(list.subList(count * size, totalSize));
        }
        return result;
    }

    /**
     * 分批获取结果集
     *
     * @param params 参数集合
     * @param limit  一批最大处理的个数
     * @param invoke 执行函数
     * @param <P>    参数
     * @param <V>    结果
     * @return 结果集
     */
    public static <P, V> List<V> splitInvoke(List<P> params, int limit, Function<List<P>, List<V>> invoke) {
        if (CollectionUtils.isEmpty(params)) {
            return new ArrayList<>();
        }
        List<V> list = new ArrayList<>();
        List<P> tmpParams;

        int startIndex = 0;
        int endIndex = params.size();
        while (startIndex < endIndex) {
            int tmpIndex = Math.min((startIndex + limit), endIndex);
            tmpParams = params.subList(startIndex, tmpIndex);
            startIndex += limit;

            List<V> invokeResultList = invoke.apply(tmpParams);
            if (!isEmpty(invokeResultList)) {
                list.addAll(invokeResultList);
            }
        }
        return list;
    }

    /**
     * 判断 Set 是否为空
     *
     * @param set 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Set<?> set) {
        return set == null || set.isEmpty();
    }

    /**
     * 获取空 Set
     *
     * @param <T> 集合元素类型
     * @return 空 Set
     */
    public static <T> Set<T> emptySet() {
        return Collections.emptySet();
    }

    /**
     * 获取空 Set
     *
     * @param isMutable 是否是不可变 map
     * @param <T>       集合元素类型
     * @return 空 Set
     */
    public static <T> Set<T> emptySet(boolean isMutable) {
        if (isMutable) {
            return new HashSet<>();
        }
        return emptySet();
    }

    /**
     * 判断 map 是否为空
     *
     * @param map map
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 获取空 map
     *
     * @param <T> map key 类型
     * @param <V> map value 类型
     * @return 空 map
     */
    public static <T, V> Map<T, V> emptyMap() {
        return Collections.emptyMap();
    }

    /**
     * 获取空 map
     *
     * @param isMutable 是否是不可变 map
     * @param <T>       map key 类型
     * @param <V>       map value 类型
     * @return 空 map
     */
    public static <T, V> Map<T, V> emptyMap(boolean isMutable) {
        if (isMutable) {
            return new HashMap<>();
        }
        return emptyMap();
    }

}
