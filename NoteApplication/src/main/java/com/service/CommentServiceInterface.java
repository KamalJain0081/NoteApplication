package com.service;

import org.springframework.stereotype.Service;

import com.dto.CommentRequestDto;
import com.dto.CommentResponseDto;


@Service
public interface CommentServiceInterface {
	
	CommentResponseDto addCommentToNote(CommentRequestDto commentDto);
}
