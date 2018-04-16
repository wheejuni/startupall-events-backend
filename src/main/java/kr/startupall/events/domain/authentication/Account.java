package kr.startupall.events.domain.authentication;

import kr.startupall.events.domain.EventApply;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private long id;

    private String name;

    @Column(name = "LOGIN_ID")
    private String loginId;

    private String password;

    private String company;

    private String status;

    @Column(name = "SOCIAL_PROVIDER")
    @Enumerated(value = EnumType.STRING)
    private SocialProviders provider;

    @OneToMany(mappedBy = "account")
    private List<EventApply> applies;

}
