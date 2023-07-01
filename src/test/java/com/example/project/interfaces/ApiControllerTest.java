package com.example.project.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.project.common.ApiDocumentUtils.getDocumentRequest;
import static com.example.project.common.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class ApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        // given
        // when
        ResultActions result = mockMvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andDo(document("hello", getDocumentRequest(), getDocumentResponse(),
                        responseFields(
                                fieldWithPath("result").description("성공 여부"),
                                fieldWithPath("data").description("데이터"),
                                fieldWithPath("message").description("응답 메시지"),
                                fieldWithPath("errorCode").description("에러 코드")
                        )));
    }

    @Test
    void fail() throws Exception {
        // given
        // when
        ResultActions result = mockMvc.perform(get("/fail")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andDo(document("fail", getDocumentRequest(), getDocumentResponse(),
                        responseFields(
                                fieldWithPath("result").description("성공 여부"),
                                fieldWithPath("data").description("데이터"),
                                fieldWithPath("message").description("응답 메시지"),
                                fieldWithPath("errorCode").description("에러 코드")
                        )));
    }

    @Test
    void exception() throws Exception {
        // given
        // when
        ResultActions result = mockMvc.perform(get("/exception")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andDo(document("exception", getDocumentRequest(), getDocumentResponse(),
                        responseFields(
                                fieldWithPath("result").description("성공 여부"),
                                fieldWithPath("data").description("데이터"),
                                fieldWithPath("message").description("응답 메시지"),
                                fieldWithPath("errorCode").description("에러 코드")
                        )));
    }

}