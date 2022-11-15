package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static lotto.infra.port.inbound.StandardInput.readLine;
import static lotto.infra.port.outbound.StandardOutput.println;

public class InputView {

    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ONLY_NUMBER_ERROR_MESSAGE = "숫자만을 입력하실 수 있습니다.";
    private static final String EMPTY_STRING = "";
    private static final String SPLITTER = ",";

    public static Money inputPurchaseMoney() {
        println(INPUT_PURCHASE_MONEY_MESSAGE);

        int input = inputNumber();
        println(EMPTY_STRING);

        return Money.valueOf(input);
    }

    public static Lotto inputWinningLottoNumber() {
        println(INPUT_WINNING_NUMBER_MESSAGE);

        List<Integer> inputNumbers = toIntegers(readLine());
        println(EMPTY_STRING);

        return new Lotto(inputNumbers);
    }

    public static int inputBonusNumber() {
        println(INPUT_BONUS_NUMBER_MESSAGE);

        int bonusNumber = inputNumber();
        println(EMPTY_STRING);

        return bonusNumber;
    }

    private static int inputNumber() {
        try {
            return parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
        }
    }

    private static List<Integer> toIntegers(final String input) {
        return stream(input.split(SPLITTER))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
