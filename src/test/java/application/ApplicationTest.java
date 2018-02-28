package application;

import com.simple.Application;
import com.simple.model.Movie;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by songyigui on 2018/2/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void before() {
        elasticsearchTemplate.deleteIndex(Movie.class);
        elasticsearchTemplate.createIndex(Movie.class);
        elasticsearchTemplate.putMapping(Movie.class);
        elasticsearchTemplate.refresh(Movie.class);

    }
}
