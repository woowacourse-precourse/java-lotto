package lotto.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int bonusNumberConversion(String inputBonusNumber) {
        int bonusNumber;

        validConsistOneNumber(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
        validOneNumberRange(bonusNumber);

        return bonusNumber;
    }

    public List<Integer> winningNumberConversion(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] separate = separateByComma(inputWinningNumber);

        validConsistNumbers(separate);

        for (int i = 0; i < separate.length; i++) {
            winningNumber.add(Integer.parseInt(separate[i]));
        }

        return winningNumber;
    }
    public void validAllWinningNumber(List<Integer> winningNumbers){
        validSixNumber(winningNumbers);
        validAllNumberRange(winningNumbers);
    }
    public void validDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> set = new HashSet<>();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        for (int i : winningNumbers) {
            if(set.contains(i)){
                throw new IllegalArgumentException();
            }
            set.add(i);
        }
    }

    public void validSixNumber(List<Integer> inputNumbers) {
        if (inputNumbers.size() != Lotto.numberCount) {
            throw new IllegalArgumentException();
        }
    }

    public void validConsistNumbers(String[] inputNumbers) {
        try {
            for (int i = 0; i < inputNumbers.length; i++) {
                Integer.parseInt(inputNumbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void validConsistOneNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void validAllNumberRange(List<Integer> inputNumbers) {
        for (int inputNumber : inputNumbers) {
            validOneNumberRange(inputNumber);
        }
    }

    public void validOneNumberRange(int inputNumber) {
        if (inputNumber < Lotto.numberMinRage || inputNumber > Lotto.numberMaxRage) {
            throw new IllegalArgumentException();
        }
    }

    public String[] separateByComma(String inputNumbers) {
        return inputNumbers.split(",");
    }
}
