package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    enum LottoReward {
        MISS(0, 0),
        FIFTH(3, 5000),
        FOURTH(4, 50000),
        THIRD(5, 1500000),
        SECOND(5, 30000000),
        FIRST(6, 2000000000);

        private int matchCount;
        private int reward;

        LottoReward(final int matchCount, final int reward) {
            this.matchCount = matchCount;
            this.reward = reward;
        }
    }

    public Lotto(List<Integer> numbers) {
        HashSet<Integer> playerNumbers = Model.MakeListToSet(numbers);
        Controller.ValidatePlayerNumber(playerNumbers);
        this.numbers = numbers;

        // 로또 번호 분석
        LinkedHashMap<String, Integer> lottoResult = Model.AnalyzePlayerNumbers(numbers);

        // 당첨 통계 출력
        View.Output("당첨 통계");
        View.Output("---");
        List<String> lottoResultKeys = new ArrayList<>(lottoResult.keySet());
        List<String> lottoReward = new ArrayList<>(LottoReward.values());
        for (int i = 0; i < 5; i++) {
            String key = lottoResultKeys.get(i);
            Integer result = lottoResult.get(i);
            String reward = lottoReward.get(i);
            View.Output(key+"개 일치 ("+reward+") - "+result+"개");
        }

    }
}
