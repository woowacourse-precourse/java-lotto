package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int LOTTO_AMOUNT = 1000;

    public static int findLottoCountByMoney(int money) {
        return money / LOTTO_AMOUNT;
    }

    private static void validateMoney(String money) {
        String expression = "^[0-9]+$";
        if (!money.matches(expression)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }

        if (Integer.parseInt(money) % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 " + LOTTO_AMOUNT + "로 나누어 떨어지지 않습니다.");
        }
    }

    public static int enterToBuyLottoForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    public static Lotto createLottoWithRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }

    public static WinningLotto createWinningLottoWithEnterNumbers() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String enterNumbers = Console.readLine();
        List<Integer> numbers = Arrays.stream(enterNumbers.split(","))
            .mapToInt(Integer::parseInt)
            .boxed()
            .sorted()
            .collect(Collectors.toList());

        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningLotto(new Lotto(numbers), bonusNumber);
    }
}
