package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static int inputPurchaseMoney() {
        String money = Console.readLine();
        return stringToIntMoney(money);
    }

    public static int stringToIntMoney(String money) {
        try {
            int input = Integer.parseInt(money);
            checkValidation(input);
            return input / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public static void checkValidation(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력하세요.");
        }
    }

    public static Lotto inputWinningNumber() {
        String winning = Console.readLine();
        List<Integer> winningLotto = Stream.of(winning.split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return Lotto.createWinningLotto(winningLotto);
    }
}
