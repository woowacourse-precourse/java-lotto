package lotto.exception;

import java.util.List;
import java.util.Set;

public class InputException {
    public static void validatePurchaseAmount(String data) {
        String[] convertedData = data.split("");
        for (String d : convertedData) {
            if (!Character.isDigit(d.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 입력된 금액이 숫자가 아닙니다.");
            }
        }
        if (Integer.valueOf(data) == 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 0원보다는 커야 합니다.");
        }
        if (Integer.valueOf(data) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 1000원 단위로 나눠 떨어져야 합니다.");
        }
    }

    public static void validateWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자의 개수가 6개가 아닙니다.");
        }
        if (Set.copyOf(winningNumber).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
        }
        for (Integer number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 입력 숫자 범위를 벗어났습니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 입력 숫자 범위를 벗어났습니다.");
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 이미 당첨 번호에 있는 숫자 입니다.");
        }
    }
}
