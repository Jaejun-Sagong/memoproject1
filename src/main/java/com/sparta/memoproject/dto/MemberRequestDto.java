package com.sparta.memoproject.dto;

import com.sparta.memoproject.model.Authority;
import com.sparta.memoproject.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

   @NotBlank(message = "아이디를 입력하세요")
   @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{4,12}", message = "아이디는 4~12자 영문 대 소문자, 숫자를 사용하세요.")
   private String nickname;
   @NotBlank(message = "비밀번호를 입력하세요.")
   @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{4,32}", message = "비밀번호는 4~32자 영문 대 소문자, 숫자를 사용하세요.")
   private String password;

   private String passwordConfirm;

   public Member toMember(PasswordEncoder passwordEncoder) {
      return Member.builder()
              .nickname(nickname)
              .password(passwordEncoder.encode(password))
              .authority(Authority.ROLE_USER)
              .build();
   }

   public UsernamePasswordAuthenticationToken toAuthentication() {
      return new UsernamePasswordAuthenticationToken(nickname, password);
   }
}

