package lotto.Domain;

import lotto.Input.PrintError;

public class Money {
    private final int userlottonum;
    public Money(String userInput){
        this.userlottonum = validate(userInput);
    }

    public int validate(String userInput) throws IllegalArgumentException {
        IllegalArgument illegalArgument = new IllegalArgument();

        if(!userInput.matches("[+-]?\\d*(\\.\\d+)?")){
            throw illegalArgument.withMessage(PrintError.NOT_A_NUMBER.getMessage());
        }
        int convertedUserInput = Integer.parseInt(userInput);;

        if (convertedUserInput % 1000 != 0) {
            throw illegalArgument.withMessage(PrintError.OUT_OF_MONEY_UNIT.getMessage());
        }
        return convertedUserInput/1000;
    }

    public int getUserlottonum() {
        return userlottonum;
    }
}
