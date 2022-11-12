package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int LOTTO_PRICE = 1000;
    public static void validatePrice(int price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("로또 구입 금액은 0보다 커야 합니다.");
        }
        if (price / LOTTO_PRICE > 10000) {
            throw new IllegalArgumentException("한 번에 최대 만 장까지만 구매 가능합니다.");
        }
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또는 천 원 단위로만 구입 가능합니다.");
        }
    }

    public static void validateWinningNums(List<Integer> winningNums) throws IllegalArgumentException {
        if (winningNums.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        Set<Integer> winningNumsSet = new HashSet<>(winningNums);
        if (winningNums.size() != winningNumsSet.size()) {
            throw new IllegalArgumentException("로또 번호는 서로 중복되지 않아야 합니다.");
        }
        for (int num : winningNums) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonusNum, List<Integer> winningNums) throws IllegalArgumentException {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
