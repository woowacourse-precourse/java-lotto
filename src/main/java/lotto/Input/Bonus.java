package lotto.Input;


import java.util.List;

public class Bonus {
    private final int number;
    private final List<Integer> sixNum;

    public Bonus(int number, List<Integer> sixNum) {
        validateOverlap(number, sixNum);
        validateOutOfRange(number);
        this.number = number;
        this.sixNum = sixNum;
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

}
