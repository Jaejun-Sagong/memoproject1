package com.sparta.memoproject.service;

import com.sparta.memoproject.dto.CommentRequestDto;
import com.sparta.memoproject.model.Comment;
import com.sparta.memoproject.model.Memo;
import com.sparta.memoproject.repository.CommentRepository;
import com.sparta.memoproject.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.activation.CommandMap;
import javax.transaction.Transactional;

@RequiredArgsConstructor //final로 선언한 변수가 있으면 꼭 생성해달라는 것
@Service
public class CommentService {


    private final CommentRepository commentRepository; // [2번]update메소드 작성 전에 id에 맞는 값을 찾으려면 find를 써야하는데 find를 쓰기위해서는 Repository가 있어야한다.
    private final MemoRepository memoRepository;

    @Secured("ROLE_USER")
    @Transactional
    public Comment addComment(Long id, CommentRequestDto commentRequestDto) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 게시글이 존재하지 않습니다."));
        Comment comment = new Comment(memo, commentRequestDto);
        commentRepository.save(comment);
        memo.addComment(comment);

        return comment;

    }

    @Transactional
    public Comment updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("해당 댓글이 존재하지 않습니다."));
        comment.setComment(commentRequestDto);
        return comment;
    }

    @Transactional
    public Boolean deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("해당 댓글이 존재하지 않습니다."));
        commentRepository.deleteById(commentId);
        return true;
    }
}

