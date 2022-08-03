package com.sparta.memoproject.controller;

import com.sparta.memoproject.dto.CommentRequestDto;
import com.sparta.memoproject.model.Comment;
import com.sparta.memoproject.service.CommentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;  // 필수적인 요소이기 때문에 final 선언


    @Secured("ROLE_USER")
    @PostMapping("/api/auth/comment/{id}")
    public Comment addComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.addComment(id, commentRequestDto);
    }

    @Secured("ROLE_USER")
    @PutMapping("/api/auth/comment/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(commentId, commentRequestDto);
    }
    @Secured("ROLE_USER")
    @DeleteMapping("/api/auth/comment/{commentId}")
    public Boolean deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

}

//    @GetMapping("/api/memos")
//    public List<Memo> readMemo(){
//        return memoRepository.findAllByOrderByModifiedAtDesc();
//    }
//}
