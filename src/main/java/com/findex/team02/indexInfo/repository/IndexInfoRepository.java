package com.findex.team02.indexInfo.repository;

import com.findex.team02.indexInfo.entity.IndexInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IndexInfoRepository extends JpaRepository<IndexInfo, Long>, IndexInfoRepositoryCustom {

}
