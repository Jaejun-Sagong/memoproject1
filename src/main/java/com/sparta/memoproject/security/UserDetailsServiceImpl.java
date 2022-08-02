//package com.sparta.memoproject.security;
//
//import com.sparta.memoproject.model.Member;
//import com.sparta.memoproject.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService { // 어센티케이션 매니저가 UserDetailsService에게 회원정보 찾아달라고 요청한 부분
//
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public UserDetailsServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  //UserDetailsService 인터페이스의 상세정보를 보면 꼭 구현해줘야하는 메소드로 지정되어있다.
//        Member member = memberRepository.findByNickname(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));
//
//        return new UserDetailsImpl(member);
//    }
//}
