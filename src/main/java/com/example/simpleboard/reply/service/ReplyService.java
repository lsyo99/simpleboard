package com.example.simpleboard.reply.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.db.ReplyRepository;
import com.example.simpleboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    public ReplyEntity craete(
            ReplyRequest replyRequest
    ){
        var entity = ReplyEntity.builder()
                .postId(replyRequest.getPostId())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .status("registered")
                .replied_at(LocalDateTime.now())
                .build();
        return replyRepository.save(entity);
    }
    public List<ReplyEntity> findAllPostId(Long postId){
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "registered");
    }
}
