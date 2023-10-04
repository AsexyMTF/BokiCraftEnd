package online.boki.backend.Body;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.*;
import online.boki.backend.Enums.StatusCodeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FrontendBody {
    private StatusCodeEnum code;
    private JSONObject data;
    private JSONArray listData;
    private String msg;
    private String dataText;

    public FrontendBody(StatusCodeEnum statusCodeEnum, String dataText, boolean isDataText) {
        if (isDataText) {
            this.code = statusCodeEnum;
            this.dataText = dataText;
        } else {
            this.code = statusCodeEnum;
            this.msg = dataText;
        }
    }

    public FrontendBody(StatusCodeEnum statusCodeEnum, String msg) {
        this.code = statusCodeEnum;
        this.msg = msg;
    }

    public FrontendBody(StatusCodeEnum statusCodeEnum, JSONObject data) {
        this.code = statusCodeEnum;
        this.data = data;
    }

    public FrontendBody(StatusCodeEnum statusCodeEnum, JSONArray jsonArray) {
        this.code = statusCodeEnum;
        this.listData = jsonArray;
    }
}
