package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validation {

    // 숫자만 입력했는지 검증
    public static void isDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }
    // 1000원 단위로 입력했는지 검증
    public static void isThousandUnit(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }
    // 로또 구입 금액을 검증
    public static void validateLottoPurchaseAmount(String purchaseAmount) {
        isDigit(purchaseAmount);
        isThousandUnit(Long.parseLong(purchaseAmount));
    }

    // 1~45 사이의 숫자인지 검증
    public static void isRightLottoNumber(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해 주세요.");
        }
    }
    // 당첨번호가 중복되지 않는지 검증
    public static void isDuplicatedWinningNumbers(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumbers.stream().filter(n -> n.equals(winningNumber)).count() != 1) {
                throw new IllegalArgumentException("[ERROR] 당첨번호가 중복되지 않게 입력해 주세요");
            }
        }
    }
    // 번호를 쉼표로 구분했는지 검증
    public static void isSplitedWithComma(String winningNumbersWithComma) {
        if (winningNumbersWithComma.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉼표로 구분해서 입력해 주세요");
        }
    }

}






