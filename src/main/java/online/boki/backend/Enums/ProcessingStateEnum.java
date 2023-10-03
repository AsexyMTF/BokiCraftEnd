package online.boki.backend.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessingStateEnum {
    Unsolved,//提交，但是未受理
    Pending,//已经受理，正在修复
    Delayed,//由于原因，暂时被推迟
    Rejected,//已经被拒绝
    Resolved;//已经被解决
}
