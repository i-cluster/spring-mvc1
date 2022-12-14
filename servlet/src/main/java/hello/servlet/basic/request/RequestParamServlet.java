package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// http://localhost:8080/request-param?username=hello&age=20                    // 파라미터 전송
// http://localhost:8080/request-param?username=hello&username=kim&age=20       // 동일 파라미터 전송
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회]");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println("paramName = " + paramName));
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        String age = req.getParameter("age");
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[동일한 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        resp.getWriter().write("ok");
    }
}
