package com.sparta.memoproject.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String title;
    private String username;
    private String contents;
    private String pw;
}
