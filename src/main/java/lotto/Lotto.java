package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class Lotto{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void calculatorMatchingNumbers(List<List<Integer>> userLottos, int bonusNumber) {
        HashMap<Integer, Integer> matchingPair = new HashMap<>(5){{
                put(3, 0);
                put(4, 0);
                put(5, 0);
                put(7, 0); // 5개 일치 + 보너스 번호
                put(6, 0);
        }};

        for (List<Integer> userLotto : userLottos) {
            int matchingCount = 0;
            for (Integer number : numbers) {
                if (userLotto.contains(number)) {
                    matchingCount++;
                }
            } if (matchingCount >= 3 && matchingCount <= 6) {
                if (matchingCount == 5 && userLotto.contains(bonusNumber)) {
                    matchingPair.replace(7, matchingPair.get(7) + 1);
                } else {
                    matchingPair.replace(matchingCount, matchingPair.get(matchingCount) + 1);
                }
            }
        }
        System.out.println(Constant.THREE_MATCHING + " - " + matchingPair.get(3) + "개");
        System.out.println(Constant.FOUR_MATCHING + " - " + matchingPair.get(4) + "개");
        System.out.println(Constant.FIVE_MATCHING + " - " + matchingPair.get(5) + "개");
        System.out.println(Constant.FIVE_MATCHING_WITH_BONUS_NUM + " - " + matchingPair.get(7) + "개");
        System.out.println(Constant.SIX_MATCHING + " - " + matchingPair.get(6) + "개");

        //System.out.println(Constant.TOTAL_YIELD + " " + + "%입니다.");
    }
}
/**
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */