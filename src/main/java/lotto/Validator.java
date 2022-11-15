package lotto;

import static lotto.Constants.COUNT_NUM;
import static lotto.Constants.ERROR;
import static lotto.Constants.UNIT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void checkPurchaseAmount(String purchaseAmount) {
        int userPurchaseAmount = checkNumber(purchaseAmount);
        if (!isDivide(userPurchaseAmount, UNIT)) {
            throw new IllegalArgumentException(ERROR + UNIT + "원 단위로 구입이 가능합니다");
        }
    }

    public static int checkNumber(String input){
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "숫자를 입력해주세요");
        }
        return number;
    }

    public static boolean isDivide(int userPurchaseAmount, int unit) {
        if ((userPurchaseAmount % unit) == 0) {
            return true;
        }
        return false;
    }

    public static void validateWinningNumber(List<Integer> winningNumbers){
        Validator.checkLottoSize(winningNumbers);
        Validator.checkDuplicate(winningNumbers);
        Validator.checkOutOfRange(winningNumbers);
    }

    public static void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != COUNT_NUM) {
            throw new IllegalArgumentException(ERROR + "로또 번호의 개수가" + COUNT_NUM + "개가 아닙니다");
        }
    }

    public static void checkDuplicate(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR + "로또 번호에 중복된 숫자가 있습니다");
        }
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> eliminateDuplication = new HashSet<>(numbers);
        if (numbers.size() != eliminateDuplication.size()) {
            return true;
        }
        return false;
    }

    public static void checkOutOfRange(List<Integer> numbers) {
        for (int cnt = 0; cnt < COUNT_NUM; cnt++) {
            if (isOutOfRange(numbers.get(cnt))) {
                throw new IllegalArgumentException(ERROR + "당첨 번호가 범위를 벗어났습니다");
            }
        }
    }

    public static boolean isOutOfRange(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }

    public static void validateBonusNumber(String bonusNumber){
        if (bonusNumber.length() != 1) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 1개입니다");
        }
        if (isOutOfRange(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR + "보너스 번호가 범위를 벗어났습니다");
        }
    }
}
