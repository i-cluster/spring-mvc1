package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/request-header?username=hello
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);

        resp.getWriter().write("ok");
    }

    // Start Line
    private void printStartLine(HttpServletRequest request) {

        System.out.println("--- REQUEST-LINE START ---");

        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());

        System.out.println("request.getRequestURL() = " + request.getRequestURL());

        System.out.println("request.getRequestURI() = " + request.getRequestURI());

        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());

        System.out.println("--- REQUEST-LINE END ---");
        System.out.println();
    }

    // Header
    private void printHeaders(HttpServletRequest request) {

        System.out.println("--- Headers START ---");

        /*
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        System.out.println(headerName + ": " + request.getHeader(headerName));
        }
        */

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));

        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    // Header Utils
    private void printHeaderUtils(HttpServletRequest request) {

        System.out.println("--- Header Utils START ---");

        System.out.println("[Host Info]");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language Info]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie Info]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content Info]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--- Header Utils END ---");
        System.out.println();
    }

    // Others
    private void printEtc(HttpServletRequest request) {

        System.out.println("--- Others START ---");

        System.out.println("[Remote Info]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println();

        System.out.println("[Local Info]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("--- Others END ---");
        System.out.println();
    }
}
