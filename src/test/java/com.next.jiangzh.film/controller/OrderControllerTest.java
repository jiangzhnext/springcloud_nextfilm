package com.next.jiangzh.film.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.next.jiangzh.film.common.BaseControllerTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

public class OrderControllerTest extends BaseControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /*
        获取影厅信息
     */
    @Test
    public void buyTickets() throws Exception{
        String uri = "/order/buyTickets";

        String mvcResult=mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("userId","1")
                .param("fieldId","1")
                .param("soldSeats","1")
                .param("seatsName","第一排1座")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("mvcResult="+mvcResult);
    }

}
