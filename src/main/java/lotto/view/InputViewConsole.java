package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lottery;

public class InputViewConsole implements InputView {
    //TODO : ERROR 메세지 ENUM 으로 분리하기
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ILLEGAL_PURCHASE_AMOUNT = "로또 구입 금액은 1,000원 단위여야 합니다.";
    private static final String WINNING_NUMBER_IS_NOT_NUMERIC = "당첨번호는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_IS_NOT_NUMERIC = "보너스 번호는 숫자여야 합니다.";
    private static final String NUMERIC_PATTERN = "^[0-9]+$";

    @Override
    public int askPurchaseAmount() {
        String userInput = Console.readLine();
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입금액은 숫자형식이어야 합니다.");
        }
        int purchaseAmount = Integer.parseInt(userInput);

        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 구입 금액은 0원보다 커야합니다.");
        }
        if (purchaseAmount % Lottery.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ILLEGAL_PURCHASE_AMOUNT);
        }
        return purchaseAmount;
    }

    @Override
    public List<Integer> askWinningNumbers() {
        String userInput = Console.readLine();
        String[] splitInputs = userInput.split(",");
        containOnlyNumber(splitInputs);
        return mapToIntegerList(splitInputs);
    }

    @Override
    public Integer askBonusNumber() {
        String userInput = Console.readLine();
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_IS_NOT_NUMERIC);
        }
        return Integer.valueOf(userInput);
    }

    private void containOnlyNumber(String[] splitInputs) {
        for (String numString : splitInputs) {
            if (!numString.matches(NUMERIC_PATTERN)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_IS_NOT_NUMERIC);
            }
        }
    }

    private List<Integer> mapToIntegerList(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
