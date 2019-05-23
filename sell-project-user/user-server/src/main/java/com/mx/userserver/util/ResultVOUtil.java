package com.mx.userserver.util;

import com.mx.userserver.enums.ResultEnum;
import com.mx.userserver.vo.ResultVO;

/**
 * @author mx
 * @date 2019/5/9 3:25 PM
 */
public class ResultVOUtil {

    public static ResultVO success() {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(Object data) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(ResultEnum resultEnum) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }
}
