package online.boki.backend.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthorityEnum {
    Administrator("Administrator"),
    Acceptor("Acceptor"),
    Asker("Asker");
    private String value;
}
