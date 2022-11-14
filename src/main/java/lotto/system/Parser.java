package lotto.system;

import lotto.exception.IllegalArgument;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public int validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        purchaseAmount = purchaseAmount.replaceAll(",", "");
        if (!IllegalArgument.isNumber(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다.");
        }
        if (!IllegalArgument.isThousandWon(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(purchaseAmount);
    }

    public List<String> parseWinningNumbers(String winningNumber) throws IllegalArgumentException {
        if (!IllegalArgument.isNumber(winningNumber.replaceAll(",", ""))) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.");
        }
        return Arrays.asList(winningNumber.split(","));
    }

    public int validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        if (!IllegalArgument.isNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.");
        }
        if (!IllegalArgument.isInRange(Arrays.asList(Integer.parseInt(bonusNumber)))) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(bonusNumber);
    }
}
