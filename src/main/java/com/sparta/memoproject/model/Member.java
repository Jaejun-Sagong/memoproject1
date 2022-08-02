package com.sparta.memoproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

   @Id
   @Column(name = "member_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false, unique = true)
   private String nickname;
   @Column(nullable = false)
   private String password;

   @Enumerated(EnumType.STRING)
   private Authority authority;

   @Builder
   public Member(String nickname, String password, Authority authority) {
      this.nickname = nickname;
      this.password = password;
      this.authority = authority;
   }
}
