package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseManager {

    public int askAmountOfMoney() throws IllegalArgumentException{
        String input = Console.readLine();

        validateInput(input);

        return Integer.parseInt(input);
    }

    private boolean validateInput(String input) {
        return true;
    }

    private boolean isDigit(String input) {
        return true;
    }

    private boolean isThousandUnit(String input) {
        return true;
    }
}
