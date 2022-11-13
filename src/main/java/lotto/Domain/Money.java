package lotto.Domain;

import lotto.Input.PrintError;

public class Money {
    private final int userlottonum;

    public Money(String userInput){
        this.userlottonum = validateAndConvert(userInput);
    }

    public int validateAndConvert(String userInput) {
        try {
            if (Integer.parseInt(userInput) % 1000 != 0) {
                throw new IllegalArgumentException(PrintError.OUT_OF_MONEY_UNIT.getMessage());
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException((PrintError.NOT_A_NUMBER.getMessage()));
        }
        return Integer.parseInt(userInput)/1000;
    }

    public int getUserlottonum() {
        return userlottonum;
    }
}
