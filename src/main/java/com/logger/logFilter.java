package com.logger;

import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by FlipBook TP300LD on 15.11.2016.
 */
public class logFilter implements Filter {
    private ServletContext conteхt;
    public logFilter() {}
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chаin) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String ip = httpReq.getRemoteAddr();
        String uri = httpReq.getRequestURI();
        HttpServletResponse httpRes = (HttpServletResponse) response;
        String status = Integer.toString(httpRes.getStatus());

        conteхt.log("ip: " + ip + ", uri: " + uri + ", status: " + status + "\n");
        chаin.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        conteхt = config.getServletContext();
    }
}
