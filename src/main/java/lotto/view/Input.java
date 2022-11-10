package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Input {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBERS_SPLIT_REGEX = ",";

    public Money inputAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return readLindToAmount();
    }

    public Lotto inputWinnerLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return new Lotto(Arrays.stream(splitReadLine())
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList()));
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private static String[] splitReadLine() {
        return Console.readLine().split(WINNER_NUMBERS_SPLIT_REGEX);
    }

    private static Money readLindToAmount() {
        return new Money(Console.readLine());
    }

}
