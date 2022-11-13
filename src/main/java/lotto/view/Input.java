package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Input {

    private static final String REQUEST_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBERS_SPLIT_REGEX = ",";
    private static final String REQUST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String REQUEST_WINNER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static Money inputMoney() {
        System.out.println(REQUEST_PURCHASE_MONEY_MESSAGE);
        return readLindToMoney();
    }

    public static Lotto inputWinnerLotto() {
        System.out.println(REQUEST_WINNER_NUMBERS_MESSAGE);
        return new Lotto(Arrays.stream(splitReadLine())
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList()));
    }

    public static int inputBonusNumber() {
        System.out.println(REQUST_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static String[] splitReadLine() {
        return Console.readLine().split(WINNER_NUMBERS_SPLIT_REGEX);
    }

    private static Money readLindToMoney() {
        return new Money(Console.readLine());
    }

}
