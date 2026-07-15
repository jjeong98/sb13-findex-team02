package com.findex.team02.indexdata.controller;

import com.findex.team02.indexdata.dto.response.IndexPerformanceRankDto;
import com.findex.team02.indexdata.entity.PerformancePeriodType;
import com.findex.team02.indexdata.service.IndexPerformanceRankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 지수 성과 랭킹 API 컨트롤러
 *
 * 사용자가 특정 지수를 기준으로 기간별 성과 랭킹을 조회할 수 있도록 한다.
 * 예시 요청:
 * GET /api/index-data/performance/rank?indexInfoId=17&periodType=DAILY&limit=10
 */
@RestController
@RequiredArgsConstructor
public class IndexPerformanceRankController {

    /**
     * 지수 성과 랭킹 조회 비즈니스 로직을 담당하는 서비스
     */
    private final IndexPerformanceRankService indexPerformanceRankService;

    /**
     * 지수 성과 랭킹 조회 API
     *
     * 특정 지수(indexInfoId)를 기준으로 기간별 성과 랭킹을 조회한다.
     *
     * @param indexInfoId 기준이 되는 지수 정보 ID
     * @param periodType 성과를 비교할 기간 타입
     *                   기본값은 DAILY
     *                   예: DAILY, WEEKLY, MONTHLY 등
     * @param limit 조회할 랭킹 개수
     *              기본값은 10
     * @return 지수 성과 랭킹 응답 DTO 목록
     */
    @GetMapping("/api/index-data/performance/rank")
    public List<IndexPerformanceRankDto> getPerformanceRank(
            @RequestParam Long indexInfoId,
            @RequestParam(defaultValue = "DAILY") PerformancePeriodType periodType,
            @RequestParam(defaultValue = "10") Integer limit
    ) {
        // 서비스 계층에 성과 랭킹 조회를 위임한다.
        return indexPerformanceRankService.getPerformanceRank(indexInfoId, periodType, limit);
    }
}