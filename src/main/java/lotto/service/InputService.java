package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {

    private static final String WINNING_NUMBER_INPUT_FORMAT = "^[0-9]+(,[0-9]+){5}";

    public List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = readLine();
        validateWinningNumbersFormat(input);
        return convertToIntegerList(input);
    }

    void validateWinningNumbersFormat(String input) {
        if (!input.matches(WINNING_NUMBER_INPUT_FORMAT)) {
            throw new IllegalArgumentException("당첨 번호의 입력 형식에 맞지 않습니다. 입력형식 예시: 1,2,3,4,5,6");
        }
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public Integer getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = readLine();
        int purchasedAmount = getInteger(input);
        validatePurchaseAmount(purchasedAmount);
        return purchasedAmount;
    }

    void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                String.format("로또는 %d원 단위로만 구매할 수 있습니다.", LOTTO_PRICE));
        }
    }

    public Integer getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = readLine();
        return getInteger(input);
    }

    static Integer getInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }
}
