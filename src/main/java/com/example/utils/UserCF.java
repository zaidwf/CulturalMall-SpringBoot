package com.example.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.example.entity.RelateDTO;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserCF {

    /**
     * 方法描述: 推荐商品id列表
     *
     * @param userId 当前用户
     * @param list   用户商品评分数据
     * @return {@link List<Integer>}返回为用户推荐的商品id列表
     */
    public static List<Integer> recommend(Integer userId, List<RelateDTO> list) {
        // 将评分数据按用户ID分组，存储到userMap中
        Map<Integer, List<RelateDTO>> userMap = list.stream().collect(Collectors.groupingBy(RelateDTO::getUseId));
        // computeNeighbor计算当前用户userId与其他用户的关系值，并将结果存储在userDisMap中
        Map<Integer, Double> userDisMap = CoreMath.computeNeighbor(userId, userMap, 0);
        if (CollectionUtil.isEmpty(userDisMap)) {
            return Collections.emptyList();
        }
        // 获取关系最近的用户--关系值最大的用户，将这些用户ID存储在userIds集合中
        double maxValue = Collections.max(userDisMap.values());
        Set<Integer> userIds = userDisMap.entrySet().stream().filter(e -> e.getValue() == maxValue).map(Map.Entry::getKey).collect(Collectors.toSet());
        // 从userIds集合中随机选择一个用户ID作为最近邻用户的ID
        Integer nearestUserId = userIds.stream().findAny().orElse(null);
        if (nearestUserId == null) {
            return Collections.emptyList();
        }
        // 最近邻用户看过商品列表
        List<Integer> neighborItems = userMap.get(nearestUserId).stream().map(RelateDTO::getGoodsId).collect(Collectors.toList());
        // 获取当前用户看过的商品列表
        List<Integer> userItems = userMap.get(userId).stream().map(RelateDTO::getGoodsId).collect(Collectors.toList());
        // 找到最近邻看过，但是该用户没看过的商品
        neighborItems.removeAll(userItems);
        //返回最终推荐商品ID列表
        return neighborItems;
    }

}
