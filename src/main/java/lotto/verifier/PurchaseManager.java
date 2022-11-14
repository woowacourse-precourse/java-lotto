package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseManager {

    public int askAmountOfMoney() throws IllegalArgumentException{
        String input = Console.readLine();

        validateInput(input);

        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if(!isDigit(input)) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        if(isThousandUnit(input)) {
            throw new IllegalArgumentException("천원 단위로 입력해야 합니다. ex) 14000");
        }
    }

    private boolean isDigit(String input) {
        return true;
    }

    private boolean isThousandUnit(String input) {
        return true;
    }
}
