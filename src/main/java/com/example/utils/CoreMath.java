package com.example.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.example.entity.RelateDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class CoreMath {

    /**
     * 计算相关系数并排序
     * 计算一个用户与其他用户之间的相关系数，并将结果存储在一个Map中，以便进行排序。
     * 参数：当前用户的id，Map<用户id，与该用户ID关联的RelateDTO列表>，type用于指定计算相关系数的类型
     */
    public static Map<Integer, Double> computeNeighbor(Integer key, Map<Integer, List<RelateDTO>> map, int type) {
        //TreeMap存储用户ID和对应的相关系数
        Map<Integer, Double> distMap = new TreeMap<>();

        List<RelateDTO> userItems = map.get(key);
        if (CollectionUtil.isNotEmpty(userItems)) {
            //便历map
            map.forEach((k, v) -> {
                //排除此用户id!=k
                if (!k.equals(key)) {
                    //使用relateDist方法计算两个用户之间的相关系数。
                    double coefficient = relateDist(v, userItems, type);
                    //关系距离
                    double distance = Math.abs(coefficient);
                    distMap.put(k, distance);
                }
            });
        }
        return distMap;
    }


    /**
     * 计算两个用户的相关系数
     * xList：第一个用户的RelateDTO列表。
     * yList：第二个用户的RelateDTO列表。
     * type：相关系数计算的类型
     */
    private static double relateDist(List<RelateDTO> xList, List<RelateDTO> yList, int type) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        xList.forEach(x -> yList.forEach(y -> {
            if (type == 0) {
                if (x.getGoodsId().equals(y.getGoodsId())) {
                    xs.add(x.getIndex());
                    ys.add(y.getIndex());
                }
            } else {
                if (x.getUseId().equals(y.getUseId())) {
                    xs.add(x.getIndex());
                    ys.add(y.getIndex());
                }
            }
        }));
        //计算这些索引值的相关系数
        return getRelate(xs, ys);
    }

    /**
     * 方法描述: 皮尔森（pearson）相关系数计算
     * @param xs x集合
     * @param ys y集合
     * @Return {@link double}
     */
    public static double getRelate(List<Integer> xs, List<Integer> ys) {
        int n = xs.size();
        //检查列表的大小，至少有两个元素。如果小于2，则返回0，因为无法计算相关系数
        if (n < 2) {
            return 0D;
        }
        double Ex = xs.stream().mapToDouble(x -> x).sum();
        double Ey = ys.stream().mapToDouble(y -> y).sum();
        double Ex2 = xs.stream().mapToDouble(x -> Math.pow(x, 2)).sum();
        double Ey2 = ys.stream().mapToDouble(y -> Math.pow(y, 2)).sum();
        double Exy = IntStream.range(0, n).mapToDouble(i -> xs.get(i) * ys.get(i)).sum();
        double numerator = Exy - Ex * Ey / n;
        double denominator = Math.sqrt((Ex2 - Math.pow(Ex, 2) / n) * (Ey2 - Math.pow(Ey, 2) / n));
        //如果分母为0，则返回0，表示两个序列完全不相关。
        if (denominator == 0) {
            return 0D;
        }
        return numerator / denominator;
    }

}
