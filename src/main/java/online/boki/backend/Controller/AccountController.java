package online.boki.backend.Controller;

import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Account;
import online.boki.backend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public FrontendBody registerUser(@RequestBody Account account) {

        try {
            return accountService.registerUser(account);
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

    @PostMapping("/login")
    public FrontendBody loginUSer(@RequestBody Account account) {
        try {
            return accountService.loginUSer(account);
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }
}
