package lotto.Domain;


import lotto.Input.PrintError;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(String bonus, List<Integer> sixNum) throws IllegalArgumentException{
        int number;
        try {
            number = Integer.parseInt(bonus);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(PrintError.NOT_A_NUMBER.getMessage());
        }

        validate(number, sixNum);
        this.number = number;
    }


    private void validate(int number, List<Integer> sixNum) throws IllegalArgumentException{
        IllegalArgument illegalArgument = new IllegalArgument();
        for(Integer lottoNum : sixNum) {
            if(number == lottoNum) {
                throw illegalArgument.withMessage(PrintError.OVERLAP_WITH_LOTTONUM.getMessage());
            }
        }

        if(number<1 || 45<number) {
            throw illegalArgument.withMessage(PrintError.OUT_OF_NUMBER_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
