package com.sparta.memoproject.controller;

import com.sparta.memoproject.dto.*;
import com.sparta.memoproject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto, HttpServletResponse response) {
//        TokenDto tokenDto = authService.login(memberRequestDto);
        response.setHeader("Authorization", "Bearer " + authService.login(memberRequestDto).getAccessToken());
        response.setHeader("Refresh-Token", authService.login(memberRequestDto).getRefreshToken());
        response.setHeader("Access-Token-Expire-Time", String.valueOf(authService.login(memberRequestDto).getAccessTokenExpiresIn()));
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")  //재발급을 위한 로직
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}