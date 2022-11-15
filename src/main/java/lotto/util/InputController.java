package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputController {


    public Integer getBuyAmount(String strNumber) {
        if (!validateInteger(strNumber)) {
            throw new IllegalStateException("[ERROR] 숫자가 입력되지 않았습니다.");
        }
        Integer number = Integer.parseInt(strNumber);
        if (!validatethousand(number)) {
            throw new IllegalStateException("[ERROR] 1000원 단위로 입력되지 않았습니다. ");
        }
        return number;
    }

    public List<Integer> getWinNumbers(String Numbers) {

        String[] strWinNumbers = Numbers.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (int i = 0; i < strWinNumbers.length; i++) {
            if (!validateInteger(strWinNumbers[i])) {
                throw new IllegalStateException("[ERROR] 숫자가 입력되지 않았습니다.");
            }
            winNumbers.add(Integer.parseInt(strWinNumbers[i]));
        }
        return winNumbers;
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
