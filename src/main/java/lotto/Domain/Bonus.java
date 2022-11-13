package lotto.Domain;


import lotto.Input.PrintError;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(String bonus, List<Integer> sixNum) throws IllegalArgumentException{
        this.number = convertAndValidate(bonus, sixNum);
    }

    private int convertAndValidate(String bonus, List<Integer> sixNum) throws IllegalArgumentException{
        IllegalArgument illegalArgument = new IllegalArgument();

        if(!bonus.matches("[+-]?\\d*(\\.\\d+)?")){
            throw illegalArgument.withMessage(PrintError.NOT_A_NUMBER.getMessage());
        }

        int number = Integer.parseInt(bonus);

        for(Integer lottoNum : sixNum) {
            if(number == lottoNum) { throw illegalArgument.withMessage(PrintError.OVERLAP_WITH_LOTTONUM.getMessage()); }
        }

        if(number<1 || 45<number) { throw illegalArgument.withMessage(PrintError.OUT_OF_NUMBER_RANGE.getMessage()); }
        return number;
    }


    public int getNumber() {
        return number;
    }
}
