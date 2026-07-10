package com.findex.team02.indexInfo.dto.request;

import java.time.LocalDateTime;

public record IndexInfoCreateRequest (
    String indexClassification,
    String indexName,
    Integer employedItemsCount,
    LocalDateTime basePointInTime,
    Integer baseIndex,
    boolean favorite
) {
}
