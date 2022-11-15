package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int PRICE_OF_A_LOTTO = 1000;
    private static final int PAYMENT_LIMIT = 200000;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUMBER_OF_LOTTO_NUMS = 6;
    public static void validatePrice(int price) throws IllegalArgumentException {
        if (price > PAYMENT_LIMIT) {
            throw new IllegalArgumentException("1회 구매 한도는 「복권 및 복권기금법」에 따라 20만원을 초과할 수 없습니다.");
        }

        if ((price % PRICE_OF_A_LOTTO) != 0) {
            throw new IllegalArgumentException("로또는 천 원 단위로만 구입 가능합니다.");
        }
    }

    public static void validateWinningNums(List<Integer> winningNums) throws IllegalArgumentException {
        if (winningNums.size() != NUMBER_OF_LOTTO_NUMS) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> winningNumsSet = new HashSet<>(winningNums);
        if (winningNums.size() != winningNumsSet.size()) {
            throw new IllegalArgumentException("로또 번호는 서로 중복되지 않아야 합니다.");
        }

        int outOfRangeCount = (int) winningNums.stream().filter((num) -> num > MAX_NUM || num < MIN_NUM).count();
        if (outOfRangeCount != 0) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNum, List<Integer> winningNums) throws IllegalArgumentException {
        if (bonusNum < MIN_NUM || bonusNum > MAX_NUM) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

    }
}
