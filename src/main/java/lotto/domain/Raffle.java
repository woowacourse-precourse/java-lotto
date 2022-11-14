package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Raffle {

    public String inputWinningNumber() {
        String userInput = Console.readLine();
        return userInput;
    }

    public List<Integer> setWinningNumber(String userInput) {
        List<Integer> winningNumber = new ArrayList<>();
        for(String number : userInput.split(",")){
            winningNumber.add(Integer.valueOf(number));
        }
        return winningNumber;
    }
}
