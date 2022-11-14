package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

import java.util.ArrayList;
import java.util.List;

public class RaffleNumber {

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
}
