package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {

    private static int playerMoney;
    private final List<Integer> answerNumbers = new ArrayList<>();

    public int getMoney() {
        return playerMoney;
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    public void inputMoney() {
        String stringPlayerMoney = Console.readLine();
        playerMoney = Integer.parseInt(stringPlayerMoney);
    }

    public void inputAnswerNumbers() {
        String answerStrings = Console.readLine();
        String[] answerList = answerStrings.split(",");
        for (String stringIndex : answerList) {
            answerNumbers.add(Integer.parseInt(stringIndex));
        }
    }
}
