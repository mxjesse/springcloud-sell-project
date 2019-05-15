package com.mx.sellobjorder.util;

import com.mx.sellobjorder.vo.ResultVO;

/**
 * @author mx
 * @date 2019/5/8 4:34 PM
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {

        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }
}
