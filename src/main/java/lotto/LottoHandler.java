package lotto;

import type.LottoGrade;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoMachine.*;
import static type.LottoGrade.*;

public class LottoHandler {

    private static final Integer FIRST_PRIZE_MONEY = 2 * (10 ^ 9);
    private static final Integer SECOND_PRIZE_MONEY = 3 * (10 ^ 7);
    private static final Integer THIRD_PRIZE_MONEY = 15 * (10 ^ 5);
    private static final Integer FOURTH_PRIZE_MONEY = 5 * (10 ^ 4);
    private static final Integer FIFTH_PRIZE_MONEY = 5 * (10 ^ 3);

    public static List<Lotto> getLottos(Integer purchaseAmount) {
        List<List<Integer>> multipleLottoNumbers = createMultipleLottoNumbers(purchaseAmount);
        List<Lotto> lottos = multipleLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        return lottos;
    }

    public static Long getRateOfReturn(Map<LottoGrade, Integer> resultOfLotto, Integer purchaseAmount) {
        Long totalMoney = 0L;
        for (LottoGrade lottoGrade: resultOfLotto.keySet()) {
            Integer eachNumber = resultOfLotto.get(lottoGrade);
            if (lottoGrade == FIRST) totalMoney += (FIRST_PRIZE_MONEY * eachNumber);
            if (lottoGrade == SECOND) totalMoney += (SECOND_PRIZE_MONEY * eachNumber);
            if (lottoGrade == THIRD) totalMoney += (THIRD_PRIZE_MONEY * eachNumber);
            if (lottoGrade == FOURTH) totalMoney += (FOURTH_PRIZE_MONEY * eachNumber);
            if (lottoGrade == FIFTH) totalMoney += (FIFTH_PRIZE_MONEY * eachNumber);
        }
        return Long.valueOf(Math.round(totalMoney / purchaseAmount * 100));
    }

    public static Map<LottoGrade, Integer> getResultOfLotto(String bonusNumber, List<Integer> winningNumbers, List<Lotto> lottos) {
        Map<LottoGrade, Integer> lottoGradeInfo = new HashMap<>();
        for (Lotto lotto : lottos) {
            Integer numberOfMatches = lotto.countNumbersIncluded(winningNumbers);
            Boolean containsBonusNumber = lotto.containsBonusNumber(Integer.valueOf(bonusNumber));
            LottoGrade lottoGrade = lotto.getLottoGrade(numberOfMatches, containsBonusNumber);
            lottoGradeInfo.merge(lottoGrade, 1, Integer::sum);
        }
        return lottoGradeInfo;
    }

    public static List<Integer> getWinningNumbers(String inputNumbers) {
        return Arrays.asList(inputNumbers.split(",")).stream()
                .map(inputNumber -> Integer.valueOf(inputNumber))
                .collect(Collectors.toList());
    }
}
