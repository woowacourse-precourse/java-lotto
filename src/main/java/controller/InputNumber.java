package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumber {
    private static final int WINNING_NUMBER_LENGTH = 6;
    private static final int BONUS_NUMBER_LENGTH = 1;

    public static List<Integer> parseWinningNumber(String userInput) {
        List<String> parsedString = new ArrayList<>(Arrays.asList(userInput.split("\\s*,\\s*")));
        List<Integer> winningNumber = new ArrayList<>();
        for (String parsed : parsedString) {
            winningNumber.add(Integer.parseInt(parsed));
        }
        if(isAppropriateLength(winningNumber)){
            return winningNumber;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
    }

    public static List<Integer> parseBonusNumber(String userInput) {
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(Integer.parseInt(userInput));
        return bonusNumber;
    }

    static boolean isAppropriateLength(List<Integer> winningNumber) throws IllegalArgumentException {
        if (winningNumber.size() != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
        return true;
    }
}
