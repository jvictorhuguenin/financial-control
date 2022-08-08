package com.finantialcontrol.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersRequestTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/users")).andDo(MockMvcResultHandlers.print()).andExpect(
        MockMvcResultMatchers.status().is4xxClientError());
  }

  @Test
  public void createUser() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/users/registry")).andDo(MockMvcResultHandlers.print()).andExpect(
        MockMvcResultMatchers.status().is4xxClientError());
  }
}
