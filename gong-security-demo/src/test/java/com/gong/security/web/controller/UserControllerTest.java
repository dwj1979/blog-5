package com.gong.security.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by GongWenHua on 17.12.11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void listUsers() throws Exception {
        mockMvc.perform(get("/user/").contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(get("/user/123").contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().isOk()).
                andReturn().
                getResponse().
                getContentAsString().
                contains("Gong");
    }

    @Test
    public void createUser() throws Exception {
        String content = "{\"userId\":1,\"userName\":\"Zhang\",\"age\":18}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user/123").
                contentType(MediaType.APPLICATION_JSON_UTF8).content(content)).
                andExpect(status().isOk());
    }

    @Test
    public void updateUser() throws Exception {
        String content = "{\"userId\":1,\"userName\":\"Zhang\",\"age\":18}";
        mockMvc.perform(MockMvcRequestBuilders.put("/user/123").
                contentType(MediaType.APPLICATION_JSON_UTF8).content(content)).
                andExpect(status().isOk());
    }

    @Test
    public void queryUsers() throws Exception {
        mockMvc.perform(
                get("/user/query")
                        .param("userId", "123")
                        .param("userName", "Gong")
                        .param("age", "100")
                        .param("size", "10")
                        .param("page", "1")
//                        .param("sort","age,desc")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void whenUploadSuccess() throws Exception {
        mockMvc.perform(fileUpload("/file")
                .file(new MockMultipartFile("file","test.txt","multipart/form-data","test".getBytes())))
                .andExpect(status().isOk());
    }

}