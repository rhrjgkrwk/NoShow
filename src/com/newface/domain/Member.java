package com.newface.domain;

import java.sql.Date;
import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 8..
 */
public class Member {

    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberTel;
    private Date memberRegdate;
    private String memberState;
    private String memberType;

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberTel() {
        return memberTel;
    }

    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }

    public Date getMemberRegdate() {
        return memberRegdate;
    }

    public void setMemberRegdate(Date memberRegdate) {
        this.memberRegdate = memberRegdate;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}