package com.tearsmart.seckill;

import com.alibaba.fastjson.JSONObject;
import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.util.Md5Utils;
import com.tearsmart.seckill.vo.LoginVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarker;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-07
 */
public class Test {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("nihoa : {}","123");
        logger.info(Marker.ANY_NON_NULL_MARKER, "21312");
    }
}
