package com.findex.team02.sync.service;

import com.findex.team02.indexdata.entity.IndexData;
import com.findex.team02.global.type.SourceType;
import com.findex.team02.indexdata.repository.IndexDataRepository;
import com.findex.team02.indexinfo.entity.IndexInfo;
import com.findex.team02.sync.dto.response.OpenApiItemDto;
import com.findex.team02.sync.entity.SyncJob;
import com.findex.team02.sync.entity.SyncJobResult;
import com.findex.team02.sync.entity.SyncJobType;
import com.findex.team02.sync.repository.SyncJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class IndexDataSyncExecutor {

    private final IndexDataRepository indexDataRepository;
    private final SyncJobRepository syncJobRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SyncJob syncOne(IndexInfo indexInfo, LocalDate targetDate, OpenApiItemDto item, String worker) {
        saveOrUpdateIndexData(indexInfo, targetDate, item);
        return saveSyncJob(indexInfo, targetDate, worker, SyncJobResult.SUCCESS);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SyncJob saveFailure(IndexInfo indexInfo, LocalDate targetDate, String worker) {
        return saveSyncJob(indexInfo, targetDate, worker, SyncJobResult.FAILED);
    }

    private void saveOrUpdateIndexData(IndexInfo indexInfo, LocalDate targetDate, OpenApiItemDto item) {
        indexDataRepository
                .findByIndexInfoAndBaseDate(indexInfo, targetDate)
                .map(indexData -> updateIndexData(indexData, item))
                .orElseGet(() -> createIndexData(indexInfo, targetDate, item));
    }

    private IndexData updateIndexData(IndexData indexData, OpenApiItemDto item) {
        indexData.update(
                toBigDecimal(item.mkp()),
                toBigDecimal(item.clpr()),
                toBigDecimal(item.hipr()),
                toBigDecimal(item.lopr()),
                toBigDecimal(item.vs()),
                toBigDecimal(item.fltRt()),
                toLong(item.tvol()),
                toLong(item.tamt()),
                toLong(item.mktcap())
        );
        return indexData;
    }

    private IndexData createIndexData(IndexInfo indexInfo, LocalDate targetDate, OpenApiItemDto item) {
        IndexData indexData = IndexData.builder()
                .indexInfo(indexInfo)
                .baseDate(targetDate)
                .sourceType(SourceType.OPEN_API)
                .marketPrice(toBigDecimalOrZero(item.mkp()))
                .closingPrice(toBigDecimalOrZero(item.clpr()))
                .highPrice(toBigDecimalOrZero(item.hipr()))
                .lowPrice(toBigDecimalOrZero(item.lopr()))
                .versus(toBigDecimalOrZero(item.vs()))
                .fluctuationRate(toBigDecimalOrZero(item.fltRt()))
                .tradingQuantity(toLongOrZero(item.tvol()))
                .tradingPrice(toLongOrZero(item.tamt()))
                .marketTotalAmount(toLongOrZero(item.mktcap()))
                .build();

        return indexDataRepository.save(indexData);
    }

    private BigDecimal toBigDecimal(String value) {
        return (value == null || value.isBlank()) ? null : new BigDecimal(value);
    }

    private Long toLong(String value) {
        return (value == null || value.isBlank()) ? null : Long.parseLong(value);
    }

    // index_data의 수치 컬럼은 전부 NOT NULL이라 신규 생성 시에는 null을 허용할 수 없음.
    // Open API가 일부 지수(시가총액 미산출 등)에 대해 빈 값을 내려주는 경우 0으로 대체
    private BigDecimal toBigDecimalOrZero(String value) {
        BigDecimal parsed = toBigDecimal(value);
        return parsed == null ? BigDecimal.ZERO : parsed;
    }

    private Long toLongOrZero(String value) {
        Long parsed = toLong(value);
        return parsed == null ? 0L : parsed;
    }

    private SyncJob saveSyncJob(IndexInfo indexInfo, LocalDate targetDate, String worker, SyncJobResult result) {
        return syncJobRepository.save(
                SyncJob.builder()
                        .indexInfo(indexInfo)
                        .targetDate(targetDate)
                        .worker(worker)
                        .jobType(SyncJobType.INDEX_DATA)
                        .result(result)
                        .jobTime(LocalDateTime.now())
                        .build()
        );
    }
}
