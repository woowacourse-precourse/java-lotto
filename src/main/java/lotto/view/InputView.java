package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static lotto.infra.port.inbound.StandardInput.readLine;
import static lotto.infra.port.outbound.StandardOutput.println;

public class InputView {

    public static Money inputPurchaseMoney() {
        println("구입금액을 입력해 주세요.");

        int input = inputNumber();
        println("");

        return Money.valueOf(input);
    }

    public static Lotto inputWinningLottoNumber() {
        println("당첨 번호를 입력해 주세요.");

        List<Integer> inputNumbers = toIntegers(readLine());
        println("");

        return new Lotto(inputNumbers);
    }

    public static int inputBonusNumber() {
        println("보너스 번호를 입력해 주세요.");

        int bonusNumber = inputNumber();
        println("");

        return bonusNumber;
    }

    private static int inputNumber() {
        return parseInt(readLine());
    }

    private static List<Integer> toIntegers(final String input) {
        return stream(input.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
