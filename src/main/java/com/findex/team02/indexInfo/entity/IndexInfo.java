package com.findex.team02.indexInfo.entity;

import com.findex.team02.global.entity.BaseEntity;
import com.findex.team02.global.entity.SourceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class IndexInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String indexClassification;
    private String indexName;
    private Integer employedItemsCount;
    private LocalDateTime basePointInTime;
    private Integer baseIndex;
    private SourceType sourceType;
    private boolean favorite;

}
