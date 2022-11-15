package lotto.domain;


import java.util.List;

public class LottoWinningNumber {
    public void validConsistNumber(String[] inputNumbers) {
        try {
            for (int i = 0; i < inputNumbers.length; i++) {
                Integer.parseInt(inputNumbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void validSixNumber(String[] inputNumbers) {
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException();
        }
    }
}
