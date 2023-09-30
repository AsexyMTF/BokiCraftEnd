package online.boki.backend.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    Success("Success"),
    Fatal("Fatal");
    private final String value;
}
