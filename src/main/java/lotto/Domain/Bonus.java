package lotto.Domain;


import lotto.Input.PrintError;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(String bonus, List<Integer> sixNum) {
        int number;
        try {
            number = Integer.parseInt(bonus);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(PrintError.NOT_A_NUMBER.getMessage());
        }

        validateOverlap(number, sixNum);
        validateOutOfRange(number);
        this.number = number;
    }


    private void validateOverlap(int inputNumber, List<Integer> sixNum) {
        for(Integer lottoNum : sixNum) {
            if(inputNumber == lottoNum) {
                throw new IllegalArgumentException(PrintError.OVERLAP_WITH_LOTTONUM.getMessage());
            }
        }
    }

    private void validateOutOfRange(int number) {
        if(number<1 || 45<number) {
            throw new IllegalArgumentException(PrintError.OUT_OF_NUMBER_RANGE.getMessage());
        }
    }
    public int getNumber() {
        return number;
    }
}
