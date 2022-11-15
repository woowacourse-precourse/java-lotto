package domain;

import dto.LottoDto;
import dto.ResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    public static final int LOTTO_PRICE = 1000;
    private Map<LottoRank, Integer> statistics;

    public Result() {
        statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rating : LottoRank.values()) {
            statistics.put(rating, 0);
        }
    }

    public ResultDto sendDto() {
        return new ResultDto(statistics);
    }
    public void increment(LottoRank rank) {
        Integer value = statistics.get(rank);
        statistics.put(rank, ++value);
    }

    public Float calcEarningRate() {
        float sum = 0;
        float totalLottos = 0;

        for (Map.Entry<LottoRank, Integer> pair : statistics.entrySet()) {
            LottoRank rank = pair.getKey();
            Integer number = pair.getValue();
            totalLottos += number;
            sum += rank.money * number;
        }
        totalLottos *= LOTTO_PRICE;

        return sum/totalLottos;
    }
}
