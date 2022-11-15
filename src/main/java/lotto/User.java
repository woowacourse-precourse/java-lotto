package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Message.*;
import static lotto.Message.BETWEEN_NUMBER;

public class User {
    public int inputMoney() {
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INVALID_NUMBER.getMessage());
        }
        return money;
    }
    public List<Integer> userLotto(String str) {
        if (!(str.contains(","))) {
            throw new IllegalArgumentException(ERROR_USER_INPUT.getMessage());
        }
        String userLottos[] = str.split(",");
        List<Integer> userInput = Arrays.stream(userLottos).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if (userInput.size() != 6) {
            throw new IllegalArgumentException(ERROR_INPUT_COUNT.getMessage());
        }
        return userInput;
    }

    public int getBonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(BETWEEN_NUMBER.getMessage());
        }
        return bonusNumber;
    }
}
