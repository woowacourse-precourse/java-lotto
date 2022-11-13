package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInterface {
    private static final String INPUT_MONEY_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
    private static final String PUBLISH_LOTTOS_ANNOUNCEMENT = "개를 구매했습니다.";

    public static String getInputMoney() {
        System.out.println(INPUT_MONEY_ANNOUNCEMENT);
        String inputMoneyRaw = Console.readLine();
        Validator.checkInputMoney(inputMoneyRaw);
        System.out.println();
        return inputMoneyRaw;
    }

    public static void announceCountOfLottosPublished(int countOfLottosPurchased) {
        System.out.println(countOfLottosPurchased + PUBLISH_LOTTOS_ANNOUNCEMENT);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
