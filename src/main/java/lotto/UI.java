package lotto;

import static lotto.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UI {
    public static List<Lotto> getUserNumbers() {
        System.out.println(MESSAGE_INIT_LOTTO);
        String money = Console.readLine();
        User user = new User(money);
        return user.getUserLotto();
    }

    public static void printUserLotto(List<Lotto> userNumbers) {
        for(Lotto lotto : userNumbers) {
            List<Integer> tempNumbers = lotto.getNumbers();
            Collections.sort(tempNumbers);
            System.out.println(tempNumbers);
        }
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
