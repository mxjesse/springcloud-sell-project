package com.mx.sellobjproduct.repository;

import com.mx.sellobjproduct.domain.ProductCategory;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mx on 2019/5/7 11:45 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1));
        Assert.assertTrue(productCategories.size() > 0);
    }
}