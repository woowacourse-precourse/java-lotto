package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {

    private int playerMoney;
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
        String AnswerStrings = Console.readLine();
        List<String> answerList = Arrays.asList(AnswerStrings.split(","));
        for (int i = 0; i < 6; i++) {
            answerNumbers.add(Integer.parseInt(answerList.get(i)));
        }
    }
}
