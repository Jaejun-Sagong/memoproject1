package com.sparta.memoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.memoproject.Timestamped;
import com.sparta.memoproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.IDENTITY : ID값이 서로 영향없이 자기만의 테이블 기준으로 올라간다.
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "MEMO_ID", nullable = false)
    private Memo memo;

//    @Builder
//    public Comment(String author, String content, Authority authority) { //
//        this.author = author;
//        this.content = content;
//        this.authority = authority;
//    }

    public Comment(Memo memo, CommentRequestDto commentRequestDto) {
        this.writer = commentRequestDto.getWriter();
        this.content = commentRequestDto.getContent();
        this.memo = memo;
    }
}
