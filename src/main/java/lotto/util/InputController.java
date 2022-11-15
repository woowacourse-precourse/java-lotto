package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    public Integer getBuyAmount(String strNumber) {
        if (!validateInteger(strNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 입력되지 않았습니다.");
        }
        Integer number = Integer.parseInt(strNumber);
        if (!validatethousand(number)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력되지 않았습니다. ");
        }
        return number;
    }

    public List<Integer> getWinNumbers(String Numbers) {

        String[] strWinNumbers = Numbers.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (int i = 0; i < strWinNumbers.length; i++) {
            if (!validateInteger(strWinNumbers[i])) {
                throw new IllegalArgumentException("[ERROR] 숫자가 입력되지 않았습니다.");
            }
            winNumbers.add(Integer.parseInt(strWinNumbers[i]));
        }
        return winNumbers;
    }

    public Integer getBonusNumber(String strNumber, List<Integer> winNumbers) {
        if (!validateInteger(strNumber)) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
        Integer number = Integer.parseInt(strNumber);
        validateDupliWithWinNum(number, winNumbers);
        return number;
    }


    private void validateDupliWithWinNum(Integer number, List<Integer> winNumbers) {
        if (winNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 숫자가 입력되었습니다.");
        }

    }

    private boolean validateInteger(String strNumber) {
        if (strNumber.matches("-?\\d+")) {
            return true;
        }
        return false;
    }

    private boolean validatethousand(Integer number) {
        int valNumber = number / 1000 * 1000;
        if (valNumber == number) {
            return true;
        }
        return false;
    }
}
