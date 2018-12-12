package com.tearsmart.seckill.config;

import com.alibaba.druid.util.StringUtils;
import com.tearsmart.seckill.constant.Constant;
import com.tearsmart.seckill.domain.MiaoshaUser;
import com.tearsmart.seckill.service.IMiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 * @author admin
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    IMiaoshaUserService userService;


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == MiaoshaUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

        String paramValue = request.getParameter(Constant.USER_COOKIE_NAME);
        String cookieValue = getCookieValue(request, Constant.USER_COOKIE_NAME);
        if (StringUtils.isEmpty(paramValue) && StringUtils.isEmpty(cookieValue)) {
            return null;
        }
        String token = StringUtils.isEmpty(paramValue) ? cookieValue : paramValue;
        return userService.getUserFromRedis(response, token);
    }

    public String getCookieValue(HttpServletRequest request, String cookieName) {
        final String string = null;
        Cookie[] cookies = request.getCookies();
        return Stream.of(cookies).filter(c -> StringUtils.equals(c.getName(), cookieName)).findFirst().orElse(null).getValue();
      /*  for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(),cookieName)) {
                return cookie.getName();
            }
        }*/
    }
}
