package lotto.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoInspector extends Validation {

    public int moneyToInt(String money) {
        validateMoney(money);
        return Integer.parseInt(money);
    }

    public int bonusNumberToInt(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> winningNumberToList(String winningNumbers) {
        winningNumbers = winningNumbers.replaceAll(" ", "");
        String[] winningNumbersArray = winningNumbers.split(",");

        validateWinningNumberArray(winningNumbersArray);

        List<Integer> winningNumberList = new ArrayList<>();

        for (String winningNumber : winningNumbersArray) {
            int parsedNumber = Integer.parseInt(winningNumber);
            winningNumberList.add(parsedNumber);
        }

        Collections.sort(winningNumberList);

        return winningNumberList;
    }

    public int getRankByMatchNumberList(List<Integer> matchedNumberList, int bonusNumber) {
        int rank = 0;

        int size = matchedNumberList.size();

        if (size == 6) {
            rank = 1;
        } else if (size == 5 && matchedNumberList.contains(bonusNumber)) {
            rank = 2;
        } else if (size == 5) {
            rank = 3;
        } else if (size == 4) {
            rank = 4;
        } else if (size == 3) {
            rank = 5;
        }

        return rank;
    }

}
