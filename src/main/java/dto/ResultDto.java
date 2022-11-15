package dto;

import domain.LottoRank;

import java.util.Map;

public class ResultDto {
    public Map<LottoRank, Integer> statistics;
    public  ResultDto(Map<LottoRank, Integer> statistics) {
        this.statistics = statistics;
    }
}
