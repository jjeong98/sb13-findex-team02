package com.findex.team02.indexInfo.controller;

import com.findex.team02.indexInfo.service.IndexInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/index-infos")
public class IndexInfoController {

    private final IndexInfoService indexInfoService;

    // 지수 정보 목록 조회
//    @GetMapping("/")
//    public ResponseEntity<> getIndexInfos(@RequestParam(required = false) String indexClassification,
//                                          @RequestParam(required = false) String indexName,
//                                          @RequestParam(required = false) Boolean favorite,
//                                          @RequestParam(required = false) Long idAfter,
//                                          @RequestParam(required = false) String cursor,
//                                          @RequestParam(defaultValue = "indexClassification") String sortField,
//                                          @RequestParam(defaultValue = "asc") String sortDirection,
//                                          @RequestParam(defaultValue = "10") Integer size) {
//
//
//    }

}
