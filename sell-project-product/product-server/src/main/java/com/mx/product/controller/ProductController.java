package com.mx.product.controller;

import com.mx.product.common.DecreaseStockInput;
import com.mx.product.domain.ProductCategory;
import com.mx.product.domain.ProductInfo;
import com.mx.product.service.ProductCategoryService;
import com.mx.product.service.ProductInfoService;
import com.mx.product.service.ProductService;
import com.mx.product.util.ResultVOUtil;
import com.mx.product.vo.ProductInfoVO;
import com.mx.product.vo.ProductVO;
import com.mx.product.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mx
 * @date 2019/5/9 10:00 AM
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    /**
     * 查询上架商品列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {

        // 查询所有上架商品
        List<ProductInfo> productInfos = productInfoService.findAllUp();
        // 查询所有分类种类
        List<Integer> categoryList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        // 查询产品分类
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryList);

        // 组装返回信息
        List<ProductVO> list = new ArrayList<ProductVO>();

        productCategoryList.forEach(productCategory -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            ArrayList<ProductInfoVO> infoVOArrayList = new ArrayList<>();

            List<ProductInfo> infos = productInfos.stream().filter(productInfo ->
                    productInfo.getCategoryType().equals(productCategory.getCategoryType())).collect(Collectors.toList());

            infos.forEach(productInfo -> {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductName(productInfo.getProductName());
                productInfoVO.setProductPrice(productInfo.getProductPrice());
                productInfoVO.setProductDescription(productInfo.getProductDescription());
                productInfoVO.setProductIcon(productInfo.getProductIcon());

                infoVOArrayList.add(productInfoVO);
            });
            productVO.setProductInfoVOList(infoVOArrayList);
            list.add(productVO);
        });

        return ResultVOUtil.success(list);
    }

    @RequestMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputs) {

        productService.decreaseStock(decreaseStockInputs);
    }
}
