package com.example.controller;

import cn.hutool.core.util.BooleanUtil;

import com.example.common.Result;
import com.example.entity.Carousel;
import com.example.entity.Comment;
import com.example.entity.Goods;
import com.example.service.CarouselService;
import com.example.service.GoodsService;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Resource
    private CarouselService carouselService;

    @Resource
    private GoodsService goodsService;
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Carousel carousel) {
        carouselService.add(carousel);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Carousel carousel = carouselService.selectById(id);
        return Result.success(carousel);
    }

    /**
     * 查询所有轮播图
     *
     * @return 轮播图
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Carousel> list = carouselService.selectAll();
        return Result.success(list);
    }
    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<Carousel> page = carouselService.selectPage(pageNum, pageSize);
        return Result.success(page);
    }
    /**
     * 保存轮播图
     *
     * @param carousel 轮播图数据
     * @return 保存结果
     */
    @PostMapping
    public Result save(@RequestBody Carousel carousel) {
        //商品不存在，则不保存轮播图
        if (BooleanUtil.isFalse(goodsService.existGood(carousel.getGoodsId()))) {
            return Result.error("400", "未查询到商品 id = " + carousel.getGoodsId());
        }

        //保存轮播图
        carouselService.saveOrUpdate(carousel);
        return Result.success();
    }

    /**
     * 更新轮播图
     *
     * @param carousel 轮播图对象
     * @return 更新结果
     */
    @PutMapping("/update")
    public Result update(@RequestBody Carousel carousel) {
        //商品不存在，则不保存轮播图
        if (BooleanUtil.isFalse(goodsService.existGood(carousel.getGoodsId()))) {
            return Result.error("400", "未查询到商品 id = " + carousel.getGoodsId());
        }

        //更新轮播图
        carouselService.updateById(carousel);
        return Result.success();
    }

    /**
     * 删除轮播图
     *
     * @param id 商品id
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        carouselService.removeById(id);
        return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        carouselService.deleteBatch(ids);
        return Result.success();
    }

}
