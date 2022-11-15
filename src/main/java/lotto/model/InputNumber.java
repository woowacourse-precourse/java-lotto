package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Error;

import java.util.*;

public class InputNumber {
    public static List<Integer> winNumbers;
    public static int bonusNumber;

    public static List<Integer> getWinNumbers() throws IllegalArgumentException{
        String playerInput = Console.readLine();
        toMakeWinNumbers(playerInput);
        Collections.sort(winNumbers);
        duplicatedNumbers(winNumbers);
        numberRangeCheck(winNumbers);
        return winNumbers;
    }

    public static int getBonusNumber() throws IllegalArgumentException{
        String playerInput = Console.readLine();
        validateNumbers(playerInput);
        bonusNumber = Integer.parseInt(playerInput);
        duplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private static void toMakeWinNumbers(String playerInput){
        List<String> beforeCheck = Arrays.asList((playerInput.replace(" ", "")).split(","));
        winNumbers = new ArrayList<>();
        for (int i = 0; i < beforeCheck.size(); i++) {
            validateNumbers(beforeCheck.get(i));
            winNumbers.add(Integer.parseInt(beforeCheck.get(i)));
        }
    }

    private static void duplicatedNumbers(List<Integer> winNumbers) throws IllegalArgumentException{
        HashSet<Integer> duplicate = new HashSet<>(winNumbers);
        if (duplicate.size() != 6) {
            throw new IllegalArgumentException(Error.DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void numberRangeCheck(List<Integer> winNumbers) throws IllegalArgumentException{
        for (int i = 0; i < winNumbers.size(); i++) {
            if (winNumbers.get(i) < 0 || winNumbers.get(i) > 45) {
                throw new IllegalArgumentException(Error.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static boolean validateNumbers(String playerInput) throws IllegalArgumentException{
        try {
            Integer.parseInt(playerInput);
            return true;
        } catch (Exception ex) {
            throw new IllegalArgumentException("[ERROR]숫자가 아닌 값을 포함하고 있습니다.");
        }
    }

    private static void duplicateBonusNumber(int bonusNumber) throws IllegalArgumentException{
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]보너스 숫자와 이미 입력한 당첨번호는 중복될 수 없습니다.");
        }
    }
}
