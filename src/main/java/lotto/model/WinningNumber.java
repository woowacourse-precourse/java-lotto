package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.model.Lotto.*;

public class WinningNumber {
    private List<Integer> winningNumber;

    public WinningNumber(String winningNumberString) {

        validate(winningNumberString);
    }

    private void validate(String winningListString) {
        winningNumber = new ArrayList<>();
        String[] split = winningListString.split(LOTTO_DELIMITER);
        Set<Integer> lottoNumberSet = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            int number = validateNumber(split[i]);
            winningNumber.add(number);
            lottoNumberSet.add(number);
        }
        if (lottoNumberSet.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public int validateNumber(String numberString) {
        int number = 0;
        number = Integer.parseInt(numberString);
        if (!(number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public List<Integer> getWinningNumber() {

        return winningNumber;
    }
}
