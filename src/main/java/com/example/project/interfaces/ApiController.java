package com.example.project.interfaces;

import com.example.project.common.exception.EntityNotFoundException;
import com.example.project.common.response.CommonResponse;
import com.example.project.common.response.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/hello")
    public CommonResponse hello() {
        return CommonResponse.success("hello");
    }

    @GetMapping("/fail")
    public CommonResponse fail() {
        return CommonResponse.fail(ErrorCode.COMMON_SYSTEM_ERROR);
    }

    @GetMapping("/exception")
    public CommonResponse exception() {
        throw new EntityNotFoundException("Entity not found");
    }
}
