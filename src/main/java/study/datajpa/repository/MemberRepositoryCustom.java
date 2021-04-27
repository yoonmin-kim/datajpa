package study.datajpa.repository;

import study.datajpa.member.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
