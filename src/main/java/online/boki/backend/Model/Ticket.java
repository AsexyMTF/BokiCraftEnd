package online.boki.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import online.boki.backend.Enums.ProcessingStateEnum;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "submit_user_name")
    private String submitUserName;
    @Column(name = "context")
    private String context;
    @Column(name = "submit_time")
    private String submitTime;
    @Column(name = "response")
    private String response;
    @Column(name = "response_time")
    private String responseTime;
    @Column(name = "pending_status")
    private ProcessingStateEnum pendingStatus;
}
