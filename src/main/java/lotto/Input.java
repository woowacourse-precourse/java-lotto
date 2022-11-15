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
        checkSeparator(winning);
        try {
            List<Integer> winningLotto = Stream.of(winning.split(","))
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            checkNumberRange(winningLotto);
            duplicateValidation(winningLotto);
            return Lotto.createWinningLotto(winningLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    private static void checkSeparator(String winning) {
        if (!winning.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 번호는 쉼표(,)를 기준으로 구분해주세요.");
        }
    }

    public static void checkNumberRange(List<Integer> winningLotto) {
        for (int i = 0; i < winningLotto.size(); i++) {
            if (!inRange(winningLotto.get(i))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static boolean inRange(int number) {
        return number >= 1 && number <= 45;
    }

    private static void duplicateValidation(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
}
