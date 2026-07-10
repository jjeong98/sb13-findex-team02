package com.findex.team02.indexInfo.dto.response;

import java.util.List;

public record CursorPageResponseIndexInfoDto (
        List<IndexInfoDto> content,
        String nextCursor,
        Long nextIdAfter,
        Integer size,
        Integer totalElements,
        boolean hasNext
) {
}
