package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UI {
    public static void setMoney() {
        String money = Console.readLine();
        User user = new User(money);
    }

    public static Lotto getLottoNumbers() {
        String inputNumbers = Console.readLine();
        List<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int getBonusNumber() {
        String inputNumber = Console.readLine();
        return Integer.parseInt(inputNumber);
    }
}
