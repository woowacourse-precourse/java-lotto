package lotto;

import type.LottoGrade;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoMachine.*;
import static type.LottoGrade.*;

public class LottoHandler {

    private static final Double FIRST_PRIZE_MONEY = 2 * Math.pow(10, 9);
    private static final Double SECOND_PRIZE_MONEY = 3 * Math.pow(10, 7);
    private static final Double THIRD_PRIZE_MONEY = 15 * Math.pow(10, 5);
    private static final Double FOURTH_PRIZE_MONEY = 5 * Math.pow(10, 4);
    private static final Double FIFTH_PRIZE_MONEY = 5 * Math.pow(10, 3);

    public static List<Lotto> getLottos(Integer purchaseAmount) {
        List<List<Integer>> multipleLottoNumbers = createMultipleLottoNumbers(purchaseAmount);
        List<Lotto> lottos = multipleLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        return lottos;
    }

    public static Double getRateOfReturn(Map<LottoGrade, Integer> resultOfLotto, Integer purchaseAmount) {
        Double totalMoney = 0D;
        for (LottoGrade lottoGrade: resultOfLotto.keySet()) {
            Integer eachNumber = resultOfLotto.get(lottoGrade);
            if (lottoGrade == FIRST) totalMoney += (FIRST_PRIZE_MONEY * eachNumber);
            if (lottoGrade == SECOND) totalMoney += (SECOND_PRIZE_MONEY * eachNumber);
            if (lottoGrade == THIRD) totalMoney += (THIRD_PRIZE_MONEY * eachNumber);
            if (lottoGrade == FOURTH) totalMoney += (FOURTH_PRIZE_MONEY * eachNumber);
            if (lottoGrade == FIFTH) totalMoney += (FIFTH_PRIZE_MONEY * eachNumber);
        }
        return Double.valueOf(totalMoney / purchaseAmount * 100);
    }

    public static Map<LottoGrade, Integer> getResultOfLotto(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        Map<LottoGrade, Integer> lottoGradeInfo = initializeLottoGrade();
        for (Lotto lotto : lottos) {
            Integer numberOfMatches = lotto.countNumbersIncluded(winningNumbers);
            Boolean containsBonusNumber = lotto.containsBonusNumber(bonusNumber);
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

    private static Map<LottoGrade, Integer> initializeLottoGrade() {
        return new HashMap<LottoGrade, Integer>(Map.of(
                FIRST, 0,
                SECOND, 0,
                THIRD, 0,
                FOURTH, 0,
                FIFTH, 0,
                NOTHING, 0
        ));
    }
}
