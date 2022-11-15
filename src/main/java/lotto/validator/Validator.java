package lotto.validator;

import java.util.List;

public class Validator {
    public static void checkPurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 수를 입력하세요.");
        }
    }

    public static void checkWinningNumber(String winningNumberInput) {
        if (winningNumberInput.contains(",") == false) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표로 구분해주세요.");
        } else if (winningNumberInput.contains(" ") == true) {
            throw new IllegalArgumentException("[ERROR] 공백을 포함할 수 없습니다.");
        }
    }

    public static void checkWinningNumberCount(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 수를 입력해주세요.");
        }
    }
}
