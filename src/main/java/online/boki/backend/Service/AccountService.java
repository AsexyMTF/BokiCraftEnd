package online.boki.backend.Service;

import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.AuthorityEnum;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Account;
import online.boki.backend.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public AccountService getUserService() {
        return new AccountService();
    }

    public FrontendBody registerUser(Account account) {
        if (accountRepository.findAccountByUserID(account.getUserID()) != null) {
            return new FrontendBody(StatusCodeEnum.Fatal, "Id is Exist(ID已存在)");
        }
        accountRepository.save(account);
        return new FrontendBody(StatusCodeEnum.Success, "Success");
    }

    public FrontendBody loginUSer(Account account) {
        Account saveAccount = accountRepository.findAccountByUserID(account.getUserID());
        if (saveAccount == null) return new FrontendBody(StatusCodeEnum.Fatal, "User not exist!(用户不存在)");
        if (!saveAccount.getPassword().equals(account.getPassword()))
            return new FrontendBody(StatusCodeEnum.Fatal, "Password Error!（密码错误）");
        return new FrontendBody(StatusCodeEnum.Success, saveAccount.getAuthority().toString(),true);
    }

}
