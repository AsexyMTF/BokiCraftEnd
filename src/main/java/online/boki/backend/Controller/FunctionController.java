package online.boki.backend.Controller;

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
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @GetMapping("/vcode")
    public String getVCode() throws URISyntaxException, IOException {
        return functionService.getVerifyCode();
    }
}
