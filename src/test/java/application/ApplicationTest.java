package application;

import com.simple.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

/**
 * Created by songyigui on 2018/2/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void before() {
//        elasticsearchTemplate.deleteIndex(Movie.class);
//        elasticsearchTemplate.createIndex(Movie.class);
//        elasticsearchTemplate.putMapping(Movie.class);
//        elasticsearchTemplate.refresh(Movie.class);

    }
}
