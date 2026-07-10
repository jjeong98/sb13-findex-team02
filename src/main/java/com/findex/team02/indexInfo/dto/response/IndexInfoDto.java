package com.findex.team02.indexInfo.dto.response;

import com.findex.team02.indexInfo.entity.IndexInfo;

import java.time.LocalDateTime;

public record IndexInfoDto (
    Long id,
    String indexClassification,
    String indexName,
    Integer employedItemsCount,
    LocalDateTime basePointInTime,
    Integer baseIndex,
    boolean favorite
) {

    public static IndexInfoDto from(IndexInfo indexInfo) {
        return new IndexInfoDto(
                indexInfo.getId(),
                indexInfo.getIndexClassification(),
                indexInfo.getIndexName(),
                indexInfo.getEmployedItemsCount(),
                indexInfo.getBasePointInTime(),
                indexInfo.getBaseIndex(),
                indexInfo.isFavorite()
        );
    }

}
