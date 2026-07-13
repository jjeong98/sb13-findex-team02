package com.findex.team02.indexInfo.repository;

import com.findex.team02.indexInfo.dto.request.IndexInfoSearchRequest;
import com.findex.team02.indexInfo.entity.IndexInfo;

import java.util.List;

public interface IndexInfoRepositoryCustom {

    List<IndexInfo> findAllByCondition (IndexInfoSearchRequest request);

}
