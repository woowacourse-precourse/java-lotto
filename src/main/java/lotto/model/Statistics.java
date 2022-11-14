package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    // 당첨 갯수와 상을 모아두는 변수
    int PRIZE1 = 0, PRIZE2 = 0, PRIZE3 = 0, PRIZE4 = 0, PRIZE5 = 0;

    // 당첨 여부를 확인하는 매서드 checkPrize
    public void checkPrizeQuantity(List<Integer> answerLottoNumbers, int bounsNumber, List<Lotto> myLottoNumberBundle) {
        // 몇개 맞는지 확인
        for (Lotto lottoNumbers : myLottoNumberBundle) {
            Map<String, Integer> matchNumberCount = checkMatchNumbersCount(answerLottoNumbers, bounsNumber,
                lottoNumbers);
            int matchCount = matchNumberCount.get("matchCount");
            int bonusCount = matchNumberCount.get("bonusCount");
            // 이게 무슨 상인지 확인
            updatePrizeQuantity(matchCount, bonusCount);
        }
        // System.out.println(PRIZE1 + " " + PRIZE2 + " " + PRIZE3 + " " + PRIZE4 + " " + PRIZE5);

    }

    public int myStat(int receivedMoney) {
        // 당첨금액 합계 구하고 통계내기
        int totalReward = PrizeType.PRIZE1.getReward() * PRIZE1 + PrizeType.PRIZE2.getReward() * PRIZE2
            + PrizeType.PRIZE3.getReward() * PRIZE3 + PrizeType.PRIZE4.getReward() * PRIZE4
            + PrizeType.PRIZE5.getReward() * PRIZE5;

        return totalReward / receivedMoney;
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
}
