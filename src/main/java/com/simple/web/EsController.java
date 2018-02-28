package com.simple.web;

import com.simple.model.Movie;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by songyigui on 2018/2/28.
 */
@RestController
public class EsController {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/elastic/details")
    public ResponseEntity<Map<String, String>> getEsInfo() {
        Client client = elasticsearchOperations.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        return ResponseEntity.ok(asMap);
    }

    @PutMapping("/elastic/clear-indices")
    public void cleanIndices() {
        elasticsearchTemplate.deleteIndex(Movie.class);
        elasticsearchTemplate.createIndex(Movie.class);
        elasticsearchTemplate.putMapping(Movie.class);
        elasticsearchTemplate.refresh(Movie.class);
    }
}
