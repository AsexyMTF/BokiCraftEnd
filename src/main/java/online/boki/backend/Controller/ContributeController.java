package online.boki.backend.Controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Contribute;
import online.boki.backend.Service.ContributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contribute")
public class ContributeController {
    @Autowired
    private ContributeService contributeService;

    @PostMapping("/submit")
    public FrontendBody submit(@RequestBody String json) {
        try {
            return contributeService.submit(JSONObject.parseObject(json));
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

    @PostMapping("/like")
    public FrontendBody like(@RequestBody Contribute contribute) {
        try {
            return contributeService.like(contribute);
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }
}
