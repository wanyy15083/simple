package test;

import com.simple.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;


/**
 * Created by bj-s2-w1631 on 18-7-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootWebTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void testController() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("name", "tom"))
                .andReturn();
        Assert.assertTrue(mvcResult.getResponse().getStatus() == 200);
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}