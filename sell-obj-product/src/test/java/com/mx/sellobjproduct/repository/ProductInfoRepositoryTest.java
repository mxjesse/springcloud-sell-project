package com.mx.sellobjproduct.repository;

import com.mx.sellobjproduct.domain.ProductInfo;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * Created by mx on 2019/5/7 6:37 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByStatus() {

        List<ProductInfo> productInfos = productInfoRepository.findByStatus(1);
//        System.err.println(productInfos.toString());
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void findByProductIdIn() {

        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList(1, 2));

        Assert.assertTrue(productInfoList.size() > 0);
    }
}