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
        FIFTH(5, 5_000),
        FOURTH(4, 50_000),
        THIRD(3, 1_500_000),
        SECOND(2, 30_000_000),
        FIRST(1, 2_000_000_000);

        private int rank;
        private int reward;

        LottoReward(final int rank, final int reward) {
            this.rank = rank;
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
