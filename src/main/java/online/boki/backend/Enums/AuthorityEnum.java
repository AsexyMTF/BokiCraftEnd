package online.boki.backend.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthorityEnum {
    Administrator,
    Acceptor,
    Asker,
    Visitor,
    None;
}
