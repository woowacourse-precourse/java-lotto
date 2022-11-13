package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return getMoney(Console.readLine());
    }

    public static int getMoney(String input) {
        MoneyValidator.validateMoney(input);
        int money = Integer.parseInt(input);
        System.out.println();

        return money / 1000;
    }

    public static Lotto getWinningNumber() {
        String inputNumber = Console.readLine();
        Lotto lotto = new Lotto(Stream.of(inputNumber.split("\\s*,\\s*"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));

        LottoValidator.validateWinningNumber(lotto);
        return lotto;
    }

    public static int getBonusNumber(Lotto winningNumber) {
        int BonusNumber = Integer.parseInt(Console.readLine());

        return BonusNumber;
    }
}
