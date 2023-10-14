package online.boki.backend.Controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Contribute;
import online.boki.backend.Service.ContributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
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

    @GetMapping("/getall")
    public FrontendBody getAll() {
        try {
            return contributeService.getAll();
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

    @GetMapping("/getcard")
    public FrontendBody getCard() {
        try {
            return contributeService.getCard();
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

    @GetMapping("/getcommit")
    public FrontendBody getCommit() {
        try {
            return contributeService.getCommit();
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

    @PostMapping("/delete")
    public FrontendBody deleteOne() {
        try {
            return null;
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

}
