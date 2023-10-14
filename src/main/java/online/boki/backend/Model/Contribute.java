package online.boki.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "contributes")
@Setter
@Getter
public class Contribute {
    @GeneratedValue
    @Id
    private long id;
    @Column(name = "main_tag")
    private String mainTag;
    @Column(name = "oth_tag")
    private String othTag;
    @Column(name = "show_base64", columnDefinition = "LONGTEXT")
    private String showBase64;
    @Column(name = "head_base64", columnDefinition = "LONGTEXT")
    private String headBase64;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "commit_name")
    private String commitName;
    @Column(name = "date_str")
    private String dateStr;
    @Column(name = "liked")
    private long liked;
    @Column(name = "has_pic")
    private boolean hasPicture;
    @Column(name = "star")
    private float starCnt;
    @Column(name = "commit")
    private String commit;
}
