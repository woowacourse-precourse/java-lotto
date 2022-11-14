package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ExceptionConstant;
import lotto.service.CalculatorLottoType;
import lotto.constant.LottoConstant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    static int bonusNumber;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoException.exceptionLottoNumberOutOfRange(numbers);
        LottoException.exceptionLottoByDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(LottoConstant.ERROR_MESSAGE + "로또 번호 개수는 6개여야 합니다.");
            throw e;
        }
    }

    // TODO: 추가 기능 구현
    public void enterBonusNumber() {
        String bonusNumberInput = Console.readLine();
        bonusNumber = LottoException.exceptionInvalidBonusNumber(bonusNumberInput);
        LottoException.exceptionBonusNumberOutOfRange(bonusNumber);
        LottoException.exceptionBonusNumberByDuplicatedLotto(numbers, bonusNumber);
    }

    public void processLotto(List<List<Integer>> userLottos, int purchasePrice) {
        HashMap<Integer, Integer> matchingPair = createLottoHashSet();
        calculateWinningStatistics(userLottos, bonusNumber, matchingPair);
        printWinningStatistics(matchingPair, purchasePrice);
    }

    public HashMap<Integer, Integer> createLottoHashSet() {
        return new HashMap<>(LottoConstant.LOTTO_WINNING_SIZE) {
            {
                for (int i = 3; i <= 7; i++) {
                    put(i, 0);
                }
            }
        };
    }

    private void printWinningStatistics(HashMap<Integer, Integer> matchingPair, int purchasePrice) {
        System.out.println(LottoConstant.THREE_MATCHING + " - " + matchingPair.get(3) + "개");
        System.out.println(LottoConstant.FOUR_MATCHING + " - " + matchingPair.get(4) + "개");
        System.out.println(LottoConstant.FIVE_MATCHING + " - " + matchingPair.get(5) + "개");
        System.out.println(LottoConstant.FIVE_MATCHING_WITH_BONUS_NUM + " - " + matchingPair.get(7) + "개");
        System.out.println(LottoConstant.SIX_MATCHING + " - " + matchingPair.get(6) + "개");

        printTotalYield(purchasePrice, matchingPair);
    }

    private void printTotalYield(double purchasePrice, HashMap<Integer, Integer> matchingPair) {
        double yield = calculateTotalYield(purchasePrice, matchingPair);
        System.out.println(LottoConstant.TOTAL_YIELD + String.format("%.1f", yield) + "%입니다.");
    }

    private double calculateTotalYield(double purchasePrice, HashMap<Integer, Integer> matchingPair) {
        int sum = 0;
        for (CalculatorLottoType type : CalculatorLottoType.values()) {
            sum += matchingPair.get(type.getMatchingCount()) * type.getMatchingCountMoney();
        }
        return (double) sum * LottoConstant.YIELD_OPERAND / purchasePrice;
    }

    private void calculateWinningStatistics(List<List<Integer>> userLottos, int bonusNumber, HashMap<Integer, Integer> matchingPair) {
        for (List<Integer> userLotto : userLottos) {
            int matchingCount = getMatchingCountByUserLottos(userLotto);
            setPairWithMatchingLottoNumber(bonusNumber, matchingPair, userLotto, matchingCount);
        }
    }

    private void setPairWithMatchingLottoNumber(int bonusNumber, HashMap<Integer, Integer> matchingPair, List<Integer> userLotto, int matchingCount) {
        if (matchingCount >= 3 && matchingCount <= 6) {
            if (matchingCount == 5 && userLotto.contains(bonusNumber)) {
                matchingPair.replace(7, matchingPair.get(7) + 1);
            } else {
                matchingPair.replace(matchingCount, matchingPair.get(matchingCount) + 1);
            }
        }
    }

    private int getMatchingCountByUserLottos(List<Integer> userLotto) {
        int matchingCount = 0;
        for (Integer number : numbers) {
            if (userLotto.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }
}