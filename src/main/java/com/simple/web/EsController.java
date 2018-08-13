package com.simple.web;

import org.springframework.web.bind.annotation.*;

/**
 * Created by songyigui on 2018/2/28.
 */
@RestController
public class EsController {

//    @Autowired
//    private ElasticsearchOperations elasticsearchOperations;

//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;

//    @GetMapping("/elastic/details")
//    public ResponseEntity<Map<String, String>> getEsInfo() {
//        Client client = elasticsearchOperations.getClient();
//        Map<String, String> asMap = client.settings().getAsMap();
//        return ResponseEntity.ok(asMap);
//    }
//
//    @PutMapping("/elastic/clear-indices")
//    public void cleanIndices() {
//        elasticsearchTemplate.deleteIndex(Movie.class);
//        elasticsearchTemplate.createIndex(Movie.class);
//        elasticsearchTemplate.putMapping(Movie.class);
//        elasticsearchTemplate.refresh(Movie.class);
//    }
}
