package com.fastcampusallinone.project3.mycontact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTest {
    @Autowired
    private HelloWorldController helloWorldController;

    private MockMvc mockMvc;

    // 객체 호출 테스트 방법
    @Test
    void helloWorld(){
        //System.out.println("test");
        System.out.println(helloWorldController.helloWorld());

        assertThat(helloWorldController.helloWorld()).isEqualTo("HelloWorld");
    }

    // mockMvc 방법 실제 http를 적용한 테스트
    @Test
    void mockMvcTest() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld")
        ).andDo(MockMvcResultHandlers.print()) // 테스트 내용 출력
    .andExpect(MockMvcResultMatchers.status().isOk()) //
    .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
    }
}