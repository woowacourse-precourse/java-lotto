package lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Result {

    private final Map<LottoRanking, Integer> result;

    public Result(EnumMap<LottoRanking, Integer> winningResult) {
        this.result = new EnumMap<>(winningResult);
    }


}