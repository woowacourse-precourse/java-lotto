package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    User user = new User();

    public void cashInput() {
        user.setUseCash(Integer.parseInt(Console.readLine()));
        user.setWinningNumbers(changeWinningNumbers(Console.readLine()));
        user.setBonus_number(Integer.parseInt(Console.readLine()));
    }

    public List<Integer> changeWinningNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        List<String> output = Arrays.asList(input.split(","));

        for (int i = 0; i < output.size(); i++) {
            result.add(Integer.parseInt(output.get(i)));
        }

        return result;
    }
}
