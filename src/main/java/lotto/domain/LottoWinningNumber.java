package lotto.domain;


import lotto.domain.enums.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validAllWinningNumber(winningNumbers);
        validAllBonusNumber(bonusNumber);
        validDuplicateNumber(winningNumbers, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static int bonusNumberConversion(String inputBonusNumber) {
        int bonusNumber;

        validConsistOneNumber(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);

        return bonusNumber;
    }

    public static List<Integer> winningNumberConversion(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] separate = separateByComma(inputWinningNumber);

        validConsistNumbers(separate);

        for (int i = 0; i < separate.length; i++) {
            winningNumber.add(Integer.parseInt(separate[i]));
        }

        return winningNumber;
    }
    public static String[] separateByComma(String inputNumbers) {
        return inputNumbers.split(",");
    }

    public void validDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> set = new HashSet<>();
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ExceptionMessage.DUPLICATE_NUMBER);
            throw new IllegalArgumentException();
        }
        for (int i : winningNumbers) {
            if(set.contains(i)){
                System.out.println(ExceptionMessage.DUPLICATE_NUMBER);
                throw new IllegalArgumentException();
            }
            set.add(i);
        }
    }
    public void validAllWinningNumber(List<Integer> winningNumbers){
        validSixNumber(winningNumbers);
        validAllNumberRange(winningNumbers);
    }

    public void validSixNumber(List<Integer> inputNumbers) {
        if (inputNumbers.size() != Lotto.numberCount) {
            System.out.println(ExceptionMessage.NOT_NUMBER_SIZE);
            throw new IllegalArgumentException();
        }
    }

    public static void validConsistNumbers(String[] inputNumbers) {
        try {
            for (int i = 0; i < inputNumbers.length; i++) {
                Integer.parseInt(inputNumbers[i]);
            }
        } catch (Exception e) {
            System.out.println(ExceptionMessage.NOT_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public void validAllNumberRange(List<Integer> inputNumbers) {
        for (int inputNumber : inputNumbers) {
            validOneNumberRange(inputNumber);
        }
    }

    public void validAllBonusNumber(int bonusNumber) {
        validOneNumberRange(bonusNumber);
    }

    public static void  validConsistOneNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (Exception e) {
            System.out.println(ExceptionMessage.NOT_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public void validOneNumberRange(int inputNumber) {
        if (inputNumber < Lotto.numberMinRage || inputNumber > Lotto.numberMaxRage) {
            System.out.println(ExceptionMessage.NOT_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }
}
