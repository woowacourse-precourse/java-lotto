package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Error;
import lotto.domain.Lottery;

public class InputViewConsole implements InputView {
    private static final String NUMERIC_PATTERN = "^[0-9]+$";
    private static final String WINNING_NUMBERS_SEPARATOR = ",";

    @Override
    public int askPurchaseAmount() {
        String userInput = Console.readLine();
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
        }
        int purchaseAmount = Integer.parseInt(userInput);

        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_ZERO.getMessage());
        }
        if (purchaseAmount % Lottery.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_NOT_DIVIDE_LOTTERY_PRICE.getMessage());
        }
        return purchaseAmount;
    }

    @Override
    public List<Integer> askWinningNumbers() {
        String userInput = Console.readLine();
        String[] splitInputs = userInput.split(WINNING_NUMBERS_SEPARATOR);
        containOnlyNumber(splitInputs);
        return mapToIntegerList(splitInputs);
    }

    @Override
    public Integer askBonusNumber() {
        String userInput = Console.readLine();
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_IS_NOT_NUMERIC.getMessage());
        }
        return Integer.valueOf(userInput);
    }

    private void containOnlyNumber(String[] splitInputs) {
        for (String numString : splitInputs) {
            if (!numString.matches(NUMERIC_PATTERN)) {
                throw new IllegalArgumentException(Error.LOTTO_NUMBER_IS_NOT_NUMERIC.getMessage());
            }
        }
    }

    private List<Integer> mapToIntegerList(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
