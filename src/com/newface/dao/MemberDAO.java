package com.newface.dao;

import com.newface.domain.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 11..
 */
public interface MemberDAO {

    public List<Member> selectAll();

    public Member selectByNo(int memberNo);

    public Member selectById(String memberId);

    public String getId(String memberId);

    public Member login(@Param("memberId") String memberId, @Param("memberPw") String memberPw);

    public int add(Member member);
}
