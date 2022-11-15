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
        if (inputNumbers.length != Lotto.numberCount) {
            throw new IllegalArgumentException();
        }
    }

    public void validAllNumberRange(List<Integer> winningNumbers, int bonusNumber) {
        for (int winningNumber : winningNumbers) {
            validOneNumberRange(winningNumber);
        }
        validOneNumberRange(bonusNumber);
    }
    public void validOneNumberRange(int number) {
        if (number < Lotto.numberMinRage || number > Lotto.numberMaxRage) {
            throw new IllegalArgumentException();
        }
    }
    public String[] separateByComma(String inputNumbers) {
        return inputNumbers.split(",");
    }
}
