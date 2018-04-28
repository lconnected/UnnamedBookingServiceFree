package org.ubsfree.bookingapp.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.ubsfree.bookingapp.BookingAppStarterTest;

import static org.hamcrest.Matchers.*;
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
                .andExpect(jsonPath("$.content[0]", hasKey("id")))
                .andExpect(jsonPath("$.content[0]", hasKey("name")))
                .andExpect(jsonPath("$.content[0]", hasKey("durationMinutes")))
                .andExpect(jsonPath("$.content[0]", hasKey("cooldownMinutes")))
                .andExpect(jsonPath("$.content[0]", hasKey("conflictable")));
    }

    @Test
    public void shouldReturnServiceObject() throws Exception {
        mockMvc.perform(get("/service/200"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("$", hasKey("id")))
                .andExpect(jsonPath("$.id", is(200)))
                .andExpect(jsonPath("$", hasKey("name")))
                .andExpect(jsonPath("$.name", is(any(String.class))))
                .andExpect(jsonPath("$", hasKey("description")))
                .andExpect(jsonPath("$.description", is(any(String.class))))
                .andExpect(jsonPath("$", hasKey("durationMinutes")))
                .andExpect(jsonPath("$.durationMinutes", is(any(Integer.class))))
                .andExpect(jsonPath("$", hasKey("cooldownMinutes")))
                .andExpect(jsonPath("$.cooldownMinutes", is(any(Integer.class))))
                .andExpect(jsonPath("$", hasKey("conflictable")))
                .andExpect(jsonPath("$.conflictable", is(any(Boolean.class))));
    }

}