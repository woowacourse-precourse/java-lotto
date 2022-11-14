package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

import java.util.ArrayList;
import java.util.List;

public class Raffle {

    public String inputWinningNumber() {
        System.out.println(Message.INPUT_WINNING);
        String userInput = Console.readLine();
        return userInput;
    }

    public List<Integer> setWinningNumber(String userInput) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : userInput.split(",")) {
            winningNumber.add(Integer.valueOf(number));
        }
        return winningNumber;
    }

    public int inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS);
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public int compareNumbers(List<Integer> lotto, List<Integer> winningNumber) {
        int count = 0;
        for (int number = 0; number < 6; number++) {
            if (winningNumber.contains(lotto.get(number))) {
                count++;
            }
        }
        return count;
    }
}
