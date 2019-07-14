package com.next.jiangzh.springboot.nextfilmcinema.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.next.jiangzh.springboot.nextfilmcinema.common.BaseControllerTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CinemaControllerTest extends BaseControllerTest {

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
    public void getFields() throws Exception{
        String uri = "/cinema/getFields";

        String mvcResult=mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("cinemaId","1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("mvcResult="+mvcResult);
    }

    /*
        获取影厅详情
     */
    @Test
    public void getFieldInfo() throws Exception{

        Map<String,String> paramMap = Maps.newHashMap();
        paramMap.put("cinemaId","1");
        paramMap.put("fieldId","1");

        String contentStr = JSONObject.toJSONString(paramMap);
        String uri = "/cinema/getFieldInfo";

        String mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                                    .content(contentStr)).andDo(MockMvcResultHandlers.print())
                            .andExpect(status().isOk())
                            .andReturn().getResponse().getContentAsString();

        System.out.println("mvcResult="+mvcResult);
    }

    /*
        获取影院查询条件
     */
    @Test
    public void getCondition() throws Exception{
        String uri = "/cinema/getCondition";

        String mvcResult=mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("mvcResult="+mvcResult);
    }


    /*
        获取影院查询条件
     */
    @Test
    public void getCinemas() throws Exception{
        String uri = "/cinema/getCinemas";

        String mvcResult=mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("mvcResult="+mvcResult);
    }

}
