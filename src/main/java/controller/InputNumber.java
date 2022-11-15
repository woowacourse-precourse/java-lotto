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
            try {
                winningNumber.add(Integer.parseInt(parsed));
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자로 구성되어야 합니다.");
            }
        }
        isAppropriateLength(winningNumber);
        isInRange(winningNumber);
        return winningNumber;
    }

    public static List<Integer> parseBonusNumber(String userInput) {
        List<Integer> bonusNumber = new ArrayList<>();
        List<String> parsedString = new ArrayList<>(Arrays.asList(userInput.split("\\s*,\\s*")));
        for (String parsed : parsedString) {
            try {
                bonusNumber.add(Integer.parseInt(parsed));
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 구성되어야 합니다.");
            }
        }
        isAppropriateBonusLength(bonusNumber);
        isInRange(bonusNumber);
        throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
    }

    static void isAppropriateLength(List<Integer> winningNumber) throws IllegalArgumentException {
        if (winningNumber.size() != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
    }

    static void isAppropriateBonusLength(List<Integer> bonusNumber) throws IllegalArgumentException {
        if (bonusNumber.size() != BONUS_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
        }
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
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

    static void isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45 || number < 0) {
                throw new IllegalArgumentException("[ERROR] 번호는 1~45 이내여야 합니다.");
            }
        }
    }

}
