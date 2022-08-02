//package com.sparta.memoproject.security;
//
//import com.sparta.memoproject.model.Member;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//public class UserDetailsImpl implements UserDetails {  //UserDetailsService 가  DB에서 가져온 데이터를 담는 곳  //인터페이스의 필수조건 살펴보기
//
//    private final Member member; //로그인 된 사용자
//
//    public UserDetailsImpl(Member member) {
//        this.member = member;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//
//    @Override
//    public String getPassword() {
//        return member.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return member.getNickname();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {  //정해놓은 룰을 따라야하므로 하나하나 이해하려고 하지말자.
//
//        String authority = String.valueOf(member.getAuthority());  //"ROLE_USER" or "ROLE_ADMIN" 둘 중 하나 반환
//
//        SimpleGrantedAuthority simpleGrantedAuthority =  new SimpleGrantedAuthority(authority); //GrantedAuthority 가 상속받는 인터페이스
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(simpleGrantedAuthority);
//
//        return authorities;
//    }
//}