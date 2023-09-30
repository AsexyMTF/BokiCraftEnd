package online.boki.backend.Service;

import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Enums.StatusCodeEnum;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.Scanner;

@Slf4j
@Service
public class FunctionService {
    @Bean
    public FunctionService getFunctionService() {
        return new FunctionService();
    }

    public String getVerifyCode() throws URISyntaxException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("apis");
        URIBuilder uri = new URIBuilder(resourceBundle.getString("verifyCode.url"));
        uri.addParameter("app_id", resourceBundle.getString("verifyCode.app_id"));
        uri.addParameter("app_secret", resourceBundle.getString("verifyCode.app_secret"));
        uri.addParameter("type", "0");
        HttpGet httpGet = new HttpGet(uri.toString());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        httpResponse = httpClient.execute(httpGet);
        Scanner scanner = new Scanner(httpResponse.getEntity().getContent());
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }
}
