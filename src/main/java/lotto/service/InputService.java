package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {

    private static final String winningNumberFormat = "^[0-9]+(,[0-9]+){5}";

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        validateWinningNumbersFormat(input);
        return convertToIntegerList(input);
    }

    private void validateWinningNumbersFormat(String input) {
        if (!input.matches(winningNumberFormat)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public Integer getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchasedAmount = getInteger();
        validatePurchaseAmount(purchasedAmount);
        return purchasedAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                String.format("로또는 %d원 단위로만 구매할 수 있습니다.", LOTTO_PRICE));
        }
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getInteger();
    }

    private static Integer getInteger() {
        String input = readLine();
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }
}
