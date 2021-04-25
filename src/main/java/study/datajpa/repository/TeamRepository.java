package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.member.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
