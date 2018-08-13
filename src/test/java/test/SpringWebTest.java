package test;

import org.hamcrest.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;


/**
 * Created by bj-s2-w1631 on 18-7-25.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
//@ContextConfiguration("my-servlet-context.xml")
public class SpringWebTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void testController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/user")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("name", "tom"))
//                .accept(MediaType.APPLICATION_JSON)
//                .andExpect(view().name("page"))
//                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
//                .andExpect(model().attribute("msg", exp_str)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("SUCCESS")));
    }
}
