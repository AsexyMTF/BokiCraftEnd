package online.boki.backend.Controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/function")
@Slf4j
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @GetMapping("/vcode")
    public FrontendBody getVCode() {
        try {
            String res = functionService.getVerifyCode();
            return new FrontendBody(StatusCodeEnum.Success, JSONObject.parseObject(res));
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }
}
