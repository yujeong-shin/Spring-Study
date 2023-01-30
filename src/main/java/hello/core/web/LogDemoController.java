package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo") // log-demo라는 요청이 오면 동작
    @ResponseBody // View 화면 없이 문자를 반환할 경우 사용
    public String logDemo(HttpServletRequest request) { // HttpServletRequest : 자바에서 제공하는 표준 서블릿 규약에 의한 고객 요청정보를 받음
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}