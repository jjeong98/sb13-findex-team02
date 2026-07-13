package com.findex.team02.indexInfo.mapper;

import com.findex.team02.indexInfo.dto.response.IndexInfoDto;
import com.findex.team02.indexInfo.entity.IndexInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IndexInfoMapper {

    IndexInfoDto toDto(IndexInfo index);

    List<IndexInfoDto> toDto(List<IndexInfo> indexInfos);

}
