package com.findex.team02.indexInfo.controller;

import com.findex.team02.indexInfo.dto.request.IndexInfoSearchRequest;
import com.findex.team02.indexInfo.dto.response.CursorPageResponseIndexInfoDto;
import com.findex.team02.indexInfo.service.IndexInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/index-infos")
public class IndexInfoController {

    private final IndexInfoService indexInfoService;

    // 지수 정보 목록 조회
    @GetMapping
    public ResponseEntity<CursorPageResponseIndexInfoDto> getIndexInfos(@ModelAttribute IndexInfoSearchRequest request) {
        CursorPageResponseIndexInfoDto response = indexInfoService.getIndexInfos(request);

        return ResponseEntity.ok(response);
    }

}
