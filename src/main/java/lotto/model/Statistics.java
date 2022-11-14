package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    int PRIZE1 = 0, PRIZE2 = 0, PRIZE3 = 0, PRIZE4 = 0, PRIZE5 = 0;

    public Map<String, Integer> checkPrizeQuantity(List<Integer> answerLottoNumbers, int bounsNumber,
        List<Lotto> myLottoNumberBundle) {
        for (Lotto lottoNumbers : myLottoNumberBundle) {
            Map<String, Integer> matchNumberCount = checkMatchNumbersCount(answerLottoNumbers, bounsNumber,
                lottoNumbers);
            int matchCount = matchNumberCount.get("matchCount");
            int bonusCount = matchNumberCount.get("bonusCount");
            updatePrizeQuantity(matchCount, bonusCount);
        }
        return createPrizeMap();
    }

    public float myStat(int receivedMoney) {
        // 당첨금액 합계 구하고 통계내기
        int totalReward = PrizeType.PRIZE1.getReward() * PRIZE1 + PrizeType.PRIZE2.getReward() * PRIZE2
            + PrizeType.PRIZE3.getReward() * PRIZE3 + PrizeType.PRIZE4.getReward() * PRIZE4
            + PrizeType.PRIZE5.getReward() * PRIZE5;

        return ((float)totalReward / receivedMoney) * 100;
    }

    private Map<String, Integer> checkMatchNumbersCount(List<Integer> answerLottoNumbers, int bounsNumber,
        Lotto lottoNumbers) {
        List<Integer> value = new ArrayList<>(lottoNumbers.getNumbers());
        value.removeAll(answerLottoNumbers);

        int matchCount = answerLottoNumbers.size() - value.size();
        int bonusCount = 0;
        if (matchCount == 5)
            if (value.get(0) == bounsNumber)
                bonusCount = 1;
        HashMap<String, Integer> matchNumbersCount = new HashMap<>();
        matchNumbersCount.put("matchCount", matchCount);
        matchNumbersCount.put("bonusCount", bonusCount);
        return matchNumbersCount;
    }

    public void updatePrizeQuantity(int matchCount, int bounsCount) {
        PrizeType prizeType = PrizeType.getRank(matchCount, bounsCount);
        if (prizeType == PrizeType.PRIZE1)
            PRIZE1++;
        if (prizeType == PrizeType.PRIZE2)
            PRIZE2++;
        if (prizeType == PrizeType.PRIZE3)
            PRIZE3++;
        if (prizeType == PrizeType.PRIZE4)
            PRIZE4++;
        if (prizeType == PrizeType.PRIZE5)
            PRIZE5++;
    }

    public Map<String, Integer> createPrizeMap() {
        return Map.of(
            "PRIZE1", PRIZE1,
            "PRIZE2", PRIZE2,
            "PRIZE3", PRIZE3,
            "PRIZE4", PRIZE4,
            "PRIZE5", PRIZE5
        );
    }
}
