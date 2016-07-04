package com.spring.cas.client1.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring-root.xml", "file:src/main/resources/spring-servlet.xml"})
/**
 * mockmvc support only from version 3.2 spring
 * @author sotheareth.ham
 *
 */
public class UploadFileTest {
	
	@Autowired
    WebApplicationContext wac; // cached
	
	private MockMvc mockMvc;

    @Autowired
    MockServletContext servletContext; // cached

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;

    @Autowired
    MockHttpServletResponse response;

    @Autowired
    ServletWebRequest webRequest;
    
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void uploadFileTest() throws Exception{
    	MockMultipartFile firstFile = new MockMultipartFile("name", "test.txt", "text/plain", "some xml".getBytes());
    	
//    	mockMvc.perform(get("/file")).andExpect(status().isOk());
    	
    	mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file/upload.html")
    			.file(firstFile)
    			.param("name", "Hello world"))
    			.andExpect(status().is(302));
    }
	

}
