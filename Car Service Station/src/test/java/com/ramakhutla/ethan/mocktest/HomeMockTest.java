package com.ramakhutla.ethan.mocktest;

import com.ramakhutla.ethan.App;
import com.ramakhutla.ethan.api.HomePage;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ethon on 2016/10/31.
 */
@SpringApplicationConfiguration(classes = App.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class HomeMockTest {

    final String BASE_URL="http://localhost:8080/";
    private MockMvc mockMvc;

    //    @Test
    public void setup() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(
                new HomePage())
                .build();
    }

    //    @Test
    public void read() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + "api/home")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                       is ("This is the Home Page")));
    }
}
