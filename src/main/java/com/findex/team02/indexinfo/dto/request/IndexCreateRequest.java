package com.findex.team02.indexinfo.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class IndexCreateRequest{
  @NotBlank
  private String indexClassification; //지수 분류
  @NotBlank
  private String indexName; //지수명
  @NotNull
  private Integer employedItemsCount; //포함 종목 수
  @NotNull
  private LocalDate basePointInTime; //기준 시점
  @NotNull
  private BigDecimal baseIndex; //기준 지수
  @NotNull
  private Boolean favorite; //즐겨찾기
}
