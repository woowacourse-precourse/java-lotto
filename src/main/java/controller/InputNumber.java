package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputNumber {
    private static final int WINNING_NUMBER_LENGTH = 6;
    private static final int BONUS_NUMBER_LENGTH = 1;

    public static List<Integer> parseWinningNumber(String userInput) {
        List<String> parsedString = new ArrayList<>(Arrays.asList(userInput.split("\\s*,\\s*")));
        List<Integer> winningNumber = new ArrayList<>();
        for (String parsed : parsedString) {
            winningNumber.add(Integer.parseInt(parsed));
        }
        if (isAppropriateLength(winningNumber)) {
            return winningNumber;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
    }

    public static List<Integer> parseBonusNumber(String userInput) {
        List<Integer> bonusNumber = new ArrayList<>();
        List<String> parsedString = new ArrayList<>(Arrays.asList(userInput.split("\\s*,\\s*")));
        for (String parsed : parsedString) {
            bonusNumber.add(Integer.parseInt(parsed));
        }
        if (isAppropriateBonusLength(bonusNumber)) {
            return bonusNumber;
        }
        throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
    }

    static boolean isAppropriateLength(List<Integer> winningNumber) throws IllegalArgumentException {
        if (winningNumber.size() != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
        return true;
    }

    static boolean isAppropriateBonusLength(List<Integer> bonusNumber) throws IllegalArgumentException {
        if (bonusNumber.size() != BONUS_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
        }
        return true;
    }

    public static List<Integer> getIntegratedWinningNumber(List<Integer> winningNumber, List<Integer> bonusNumber) {
        List<Integer> integratedWinningNumber = new ArrayList<>();
        integratedWinningNumber.addAll(winningNumber);
        integratedWinningNumber.addAll(bonusNumber);
        if (!isDuplicate(integratedWinningNumber)) {
            return integratedWinningNumber;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

    static boolean isDuplicate(List<Integer> integratedWinningNumber) throws IllegalArgumentException {
        Set<Integer> duplicationCheck = new HashSet<>(integratedWinningNumber);
        if (duplicationCheck.size() == integratedWinningNumber.size()) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

}
