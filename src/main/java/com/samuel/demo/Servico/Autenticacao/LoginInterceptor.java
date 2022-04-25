package com.samuel.demo.Servico.Autenticacao;

import com.samuel.demo.Servico.CookieService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
                try {
                    if (CookieService.getCookie(request, "usuarioId") != null) {
                        return true;
                    }
                }
                catch ( Exception erro ) {}
        response.sendRedirect("/login");
        return false;
    }



}
