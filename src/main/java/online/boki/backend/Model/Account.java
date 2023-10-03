package online.boki.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import online.boki.backend.Enums.AuthorityEnum;

@Entity
@Table(name = "server_user_data")
@Data
public class Account {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "user_id")
    private String userID;
    @Column(name = "password")
    private String password;
    @Column(name = "authority")
    private AuthorityEnum authority;
}
