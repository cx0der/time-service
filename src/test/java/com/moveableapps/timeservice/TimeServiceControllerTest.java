package com.moveableapps.timeservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class TimeServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnTimeStamp() throws Exception {
        this.mockMvc.perform(get("/timestamp/1450137600000")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Tue Dec 15 00:00:00 UTC 2015")));
    }

    @Test
    public void shouldHandleInvalidTimestamp() throws Exception {
        this.mockMvc.perform(get("/timestamp/dead")).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("Invalid timestamp ")));
    }

    @Test
    public void shouldReturnUnixTimeForDate() throws Exception {
        this.mockMvc.perform(get("/timestamp/2018-08-12")).andExpect(status().isOk())
                .andExpect(content().string(containsString("1534032000000")));
    }
}
