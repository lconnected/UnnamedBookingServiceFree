package org.ubsfree.bookingapp.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.ubsfree.bookingapp.BookingAppStarterTest;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 19/04/2018.
 */
@AutoConfigureMockMvc(secure = false)
public class ServiceControllerTest extends BookingAppStarterTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mockMvcInitialized() throws Exception {
        assertNotNull(mockMvc);
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/service/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("$.content.*", Matchers.hasSize(Matchers.greaterThan(0))))
                .andExpect(jsonPath("$.content[0]", Matchers.hasKey("id")))
                .andExpect(jsonPath("$.content[0]", Matchers.hasKey("name")))
                .andExpect(jsonPath("$.content[0]", Matchers.hasKey("durationMinutes")))
                .andExpect(jsonPath("$.content[0]", Matchers.hasKey("cooldownMinutes")))
                .andExpect(jsonPath("$.content[0]", Matchers.hasKey("conflictable")));

    }

}