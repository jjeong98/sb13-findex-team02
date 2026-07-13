package com.findex.team02.indexInfo.service;

import com.findex.team02.indexInfo.dto.request.IndexInfoSearchRequest;
import com.findex.team02.indexInfo.dto.response.CursorPageResponseIndexInfoDto;
import com.findex.team02.indexInfo.dto.response.IndexInfoDto;

import java.util.List;

public interface IndexInfoService {

    CursorPageResponseIndexInfoDto getIndexInfos(IndexInfoSearchRequest request);

}
