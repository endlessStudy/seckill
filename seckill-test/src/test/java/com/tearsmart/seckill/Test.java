package com.tearsmart.seckill;

import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.util.Md5Utils;
import com.tearsmart.seckill.vo.LoginVo;
import org.apache.commons.codec.digest.DigestUtils;

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
        /*List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        System.out.println(String.format(CodeMessage.BIND_EXCEPTION.getMessage(), "123"));


    }

}
