package com.findex.team02.indexInfo.dto.request;

public record IndexInfoUpdateRequest (
    Integer employedItemsCount,
    String basePointInTIme,
    Integer baseIndex,
    boolean favorite
) {
}
