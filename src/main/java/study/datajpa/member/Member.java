package study.datajpa.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
@NamedQuery(
        name = "Member.findByUsername",
        query = "select m from Member m where m.username = :username"
)
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team != null){
            changTeam(team);
        }
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    /** 연관관계 메소드 **/
    public void changTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
