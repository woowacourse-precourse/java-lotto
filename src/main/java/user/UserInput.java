package user;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static message.ErrorMessage.*;

public class UserInput {
    public int inputMoney() {
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER.getStatus());
        }
        return money;
    }

    public List<Integer> userLotto(String str) {
        if (!(str.contains(","))) throw new IllegalArgumentException(USER_INPUT_ERROR.getStatus());

        String[] arr = str.split(",");
        List<Integer> userInput = Arrays.stream(arr).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if (userInput.size() != 6) throw new IllegalArgumentException(INPUT_COUNT_ERROR.getStatus());
        return userInput;
    }


    public int getBonusNumber(int bonusNum) {
        if (bonusNum > 45 || bonusNum < 1) throw new IllegalArgumentException(ABOVE_ELEMENT.getStatus());
        return bonusNum;
    }
}