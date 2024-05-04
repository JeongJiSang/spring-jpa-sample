package com.jbground.web.config.interceptor;

import com.jbground.web.util.AppCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PortalInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(PortalInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession(false);

        if (null != session) {

            String userId = (String) session.getAttribute("userId");

            if(null != userId && !"".equals(userId)) {

                String nowIp = request.getRemoteAddr();

                String userAgent = request.getHeader("User-Agent");
                String nowBrowser = AppCommonUtil.getBrowser(userAgent);
                String nowOs = AppCommonUtil.getOs(userAgent);


                String loginIp = (String) session.getAttribute("loginIp");
                String loginBrowser = (String) session.getAttribute("loginBrowser");
                String loginOs = (String) session.getAttribute("loginOs");

                if(!nowIp.equals(loginIp) || !nowBrowser.equals(loginBrowser) || !nowOs.equals(loginOs)) {
                    session.invalidate();
                    response.sendRedirect("/");
                }

            }
        }
    }
}

