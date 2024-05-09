package org.example.api.controller.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/*")
@Component
public class TestFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("1");
        Filter.super.init(filterConfig);
        System.out.println("2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3");
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            System.out.println("Attribute Name: " + attributeName + ", Value: " + servletRequest.getAttribute(attributeName));
        }


        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("4");
    }

    @Override
    public void destroy() {
        System.out.println("5");
        Filter.super.destroy();
        System.out.println("6");
    }
}
