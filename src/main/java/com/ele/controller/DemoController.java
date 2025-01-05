package com.ele.controller;

import com.ele.controller.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Demo")
@RequiredArgsConstructor
@RequestMapping("/demo")
@RestController
@Slf4j
public class DemoController {

    @Operation(summary = "Demo for post request")
    @PostMapping
    ResponseDto postDemo() {
        log.info("Post request success");
        return ResponseDto.success("Post request success");
    }

    @Operation(summary = "Demo for get request")
    @GetMapping
    ResponseDto getDemo() {
        log.info("Get request success");
        return ResponseDto.success("Get request success");
    }
}
