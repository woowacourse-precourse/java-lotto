package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int LOTTO_AMOUNT = 1000;

    public static int findLottoCountByMoney(int money) {
        validateMoney(money);
        return money / LOTTO_AMOUNT;
    }

    private static void validateMoney(int money) {
        if (money % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 " + LOTTO_AMOUNT + "로 나누어 떨어지지 않습니다.");
        }
    }

    public static int enterToBuyLottoForMoney() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public static Lotto createLottoWithRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }

    public static WinningLotto createWinningLottoWithEnterNumbers() {
        String enterNumbers = Console.readLine();
        List<Integer> numbers = Arrays.stream(enterNumbers.split(","))
            .mapToInt(Integer::parseInt)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningLotto(new Lotto(numbers), bonusNumber);
    }
}
