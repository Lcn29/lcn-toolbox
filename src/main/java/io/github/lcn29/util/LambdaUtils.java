package io.github.lcn29.util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Lambda 工具类
 *
 * @author canxin.li
 * @date 2024-08-29 16:22:42
 */
public class LambdaUtils {

    /**
     * 将 List 转换为 Map
     *
     * @param list 集合
     * @param key  key
     * @param <T>  集合元素类型
     * @param <K>  key 类型
     * @return Map
     */
    public static <T, K> Map<K, T> toMap(List<T> list, Function<T, K> key) {
        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.emptyMap();
        }
        return list.stream()
                .collect(Collectors.toMap(key, Function.identity(), (p1, p2) -> p1));
    }

    /**
     * 将 List 转换为 Map
     *
     * @param list  集合
     * @param key   key
     * @param value value
     * @param <T>   集合元素类型
     * @param <K>   key 类型
     * @param <V>   value 类型
     * @return Map
     */
    public static <T, K, V> Map<K, V> toMap(List<T> list, Function<T, K> key, Function<T, V> value) {
        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.emptyMap();
        }
        return list.stream().collect(Collectors.toMap(key, value, (p1, p2) -> p1));
    }

    /**
     * 根据 key 分组
     *
     * @param list 集合
     * @param key  key
     * @param <T>  集合元素类型
     * @param <K>  key 类型
     * @return Map
     */
    public static <T, K> Map<K, List<T>> groupBy(List<T> list, Function<T, K> key) {
        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.emptyMap();
        }
        return list.stream().collect(Collectors.groupingBy(key));
    }


    /**
     * 升序排序
     *
     * @param list         集合
     * @param keyExtractor key 提取器
     * @param <T>          集合元素类型
     * @param <U>          key 类型
     * @return 排序后的集合
     */
    public static <T, U extends Comparable<U>> List<T> orderBy(List<T> list, Function<T, U> keyExtractor) {

        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.emptyList();
        }
        return list.stream()
                .sorted(Comparator.comparing(keyExtractor))
                .collect(Collectors.toList());
    }

    /**
     * 降序排序
     *
     * @param list         集合
     * @param keyExtractor key 提取器
     * @param <T>          集合元素类型
     * @param <U>          key 类型
     * @return 排序后的集合
     */
    public static <T, U extends Comparable<U>> List<T> orderByDesc(List<T> list, Function<T, U> keyExtractor) {

        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.emptyList();
        }
        return list.stream()
                .sorted(Comparator.comparing(keyExtractor).reversed())
                .collect(Collectors.toList());
    }

    /**
     * 降序排序
     *
     * @param list         集合
     * @param keyExtractor key 提取器
     * @param <T>          集合元素类型
     * @param <U>          key 类型
     * @return 排序后的集合
     */
    public static <T, U extends Comparable<U>> List<T> orderByDesc(List<T> list, Function<T, U> keyExtractor, Function<T, U> keyExtractor2) {

        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.emptyList();
        }
        return list.stream()
                .sorted(Comparator.comparing(keyExtractor).thenComparing(keyExtractor2))
                .collect(Collectors.toList());
    }


}
