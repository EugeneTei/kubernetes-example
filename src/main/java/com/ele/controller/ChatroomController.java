package com.ele.controller;

import com.ele.controller.dto.ResponseDto;
import com.ele.repository.ChatroomRepository;
import com.ele.repository.entity.Chatroom;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Chatroom")
@RequiredArgsConstructor
@RequestMapping("/chatroom")
@RestController
@Slf4j
public class ChatroomController {

    private final ChatroomRepository chatroomRepository;

    @Operation(summary = "Upsert chatroom")
    @PatchMapping
    ResponseDto upsertChatroom(@RequestBody Chatroom chatroom) {
        chatroomRepository.save(chatroom);
        return ResponseDto.success("Upsert success");
    }

    @Operation(summary = "Get chatroom list")
    @GetMapping
    ResponseDto getChatroomList() {
        return ResponseDto.success(chatroomRepository.findAll());
    }
}

