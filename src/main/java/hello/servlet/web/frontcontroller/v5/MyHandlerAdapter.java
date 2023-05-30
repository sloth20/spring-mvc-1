package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    // 어댑터가 해당 컨트롤러(handler)를 처리할 수 있는지 판단
    boolean supports(Object handler);

    // 어댑터는 실제 컨트롤러를 호출하고 그 결과로 ModelView를 반환
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException;
}
