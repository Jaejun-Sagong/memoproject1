package com.sparta.memoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.memoproject.Timestamped;
import com.sparta.memoproject.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String memberName;

//    public Memo(String title, String username, String contents, String pw) {
//        this.title = title;
//        this.username = username;
//        this.contents = contents;
//        this.pw = pw;
//    }

    public Memo(MemoRequestDto requestDto, String memberName) {
        this.memberName = memberName;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
    public Memo(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
//    public Memo(PwDto pwDto) {
//        this.title = pwDto.getPw();
//    }

    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
