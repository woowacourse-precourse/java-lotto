package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    public List<Integer> creteWinningNumbers(String winningNumber) {
        List<Integer> winningLottery = new ArrayList<>();
        String[] numberArrays = winningNumber.split(",");
        int numberArraysLength = numberArrays.length;
        for (int i = 0; i < numberArraysLength; i++) {
            int number = Integer.parseInt(numberArrays[i]);
            winningLottery.add(number);
        }
        return winningLottery;
    }
}