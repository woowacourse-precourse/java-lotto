package lotto;

import static lotto.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UI {
    public static User getUser() {
        System.out.println(MESSAGE_INIT_LOTTO_START);
        String money = Console.readLine();
        System.out.println();
        User user = new User(money);
        System.out.println((user.money / 1000) + MESSAGE_INIT_LOTTO_FINISH);
        printUserLotto(user.userLotto);
        return user;
    }

    public static void printUserLotto(List<Lotto> userNumbers) {
        for(Lotto lotto : userNumbers) {
            List<Integer> tempNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(tempNumbers);
            System.out.println(tempNumbers);
        }
        System.out.println();
    }

    public static Lotto getLottoNumbers() {
        System.out.println(MESSAGE_INSERT_LOTTO_NUMBER);
        String inputNumbers = Console.readLine();
        System.out.println();

        List<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int getBonusNumber() {
        System.out.println(MESSAGE_INSERT_BONUS_NUMBER);
        String inputNumber = Console.readLine();
        System.out.println();
        return Integer.parseInt(inputNumber);
    }

    public static void printTotalResult(int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Result result : Result.values()) {
            System.out.println(result.text() + result.count() + "개");
        }
        double ror = Rank.calculateRateOfReturn(money);
        System.out.println(MESSAGE_RATE_OF_RETURN_INIT + String.format("%.1f", ror) + MESSAGE_RATE_OF_RETURN_FINAL);
    }
}
