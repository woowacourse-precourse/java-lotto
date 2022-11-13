package lotto.Domain;

import lotto.Input.PrintError;

public class Money {
    private final int userlottonum;

    public Money(String userInput){
        int convertedUserInput = validate(userInput);
        this.userlottonum = afterCalculate(convertedUserInput);
    }

    public int validate(String userInput) throws IllegalArgumentException {
        int userInputNum;
        try {
            userInputNum = Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException((PrintError.NOT_A_NUMBER.getMessage()));
        }
        return userInputNum;
    }

    public int afterCalculate(int convertedUserInput) throws IllegalArgumentException {

        if (convertedUserInput % 1000 != 0) {
            throw new IllegalArgumentException(PrintError.OUT_OF_MONEY_UNIT.getMessage());
        }
        return convertedUserInput/1000;
    }

    public int getUserlottonum() {
        return userlottonum;
    }
}
