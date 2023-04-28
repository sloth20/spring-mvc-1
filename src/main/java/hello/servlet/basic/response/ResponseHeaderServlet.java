package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-custom-header", "hello");

        content(response);
        cookie(response);
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("안녕");
    }

    // header 편의 메서드
    private void content(HttpServletResponse response) {
        // Content-Type: text/plain;charset=utf-8
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // 또는 response.setHeader("Content-Type", "text/plain;charset=utf-8");으로도 설정가능

        // Content-Length: 8
        // 생략시 자동 생성
        response.setContentLength(8);
    }

    // 쿠키 편의 메서드
    private void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600;
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        // 또는 response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");으로도 설정가능

        response.addCookie(cookie);
    }

    // 리다이렉트 편의 메서드
    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html
        response.sendRedirect("/basic/hello-form.html");
        // 또는 아래 두 줄로도 설정가능
        // response.setStatus(HttpServletResponse.SC_FOUND); // 302
        // response.setHeader("Location", "/basic/hello-form.html");
    }
}
