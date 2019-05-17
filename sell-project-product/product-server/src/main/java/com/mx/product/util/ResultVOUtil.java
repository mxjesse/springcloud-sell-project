package com.mx.product.util;

import com.mx.product.vo.ResultVO;

/**
 * @author mx
 * @date 2019/5/9 3:25 PM
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }
}
