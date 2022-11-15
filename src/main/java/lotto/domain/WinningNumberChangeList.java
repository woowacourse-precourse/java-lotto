package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WinningNumberChangeList {
    private final String winningNumbers;

    public WinningNumberChangeList(String winningNumbers) {
        //validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(String numbers) {
        if (numbers.length() != 11) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> changeNumberToList() {
        int[] winNumArray = Stream.of(winningNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> changeWinNumList = new ArrayList<>();
        for(int i = 0; i < winNumArray.length; i++) {
            changeWinNumList.add(winNumArray[i]);
        }
        return changeWinNumList;
    }
}
