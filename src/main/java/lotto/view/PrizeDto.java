package lotto.view;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import lotto.type.Prize;

public class PrizeDto {
    private List<Prize> prizes;
    private Double yield;

    public PrizeDto(List<Prize> prizes, Double yield) {
        this.prizes = prizes;
        this.yield = yield;
    }

    public Map<Prize, Long> groupByPrizes() {
        return prizes.stream()
                .collect(groupingBy(prize -> prize, counting()));
    }

    public Double getYield() {
        return yield;
    }
}
