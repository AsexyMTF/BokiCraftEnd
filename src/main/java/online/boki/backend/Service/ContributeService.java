package online.boki.backend.Service;

import com.alibaba.fastjson2.JSONObject;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Contribute;
import online.boki.backend.Repository.ContributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ResourceBundle;

@Service
public class ContributeService {
    @Autowired
    private ContributeRepository contributeRepository;

    @Bean
    public ContributeService getContributeService() {
        return new ContributeService();
    }

    public FrontendBody submit(JSONObject jsonObject) {
        String token = jsonObject.getString("token");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("keyword");
        if (!token.equals(resourceBundle.getString("contribute.token")))
            return new FrontendBody(StatusCodeEnum.Fatal, "token is not equals!");
        Contribute contribute = jsonObject.to(Contribute.class);
        contributeRepository.save(contribute);
        return new FrontendBody(StatusCodeEnum.Success, "Success");
    }

    public FrontendBody like(Contribute contribute) {
        Contribute contribute1 = contributeRepository.getReferenceById(contribute.getId());
        contribute1.setLiked(contribute1.getLiked() + 1);
        contributeRepository.save(contribute1);
        return new FrontendBody(StatusCodeEnum.Success, "Success");
    }
}
