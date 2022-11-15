package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int inputAmount() {
        String amount = Console.readLine();
        if(!Validator.isNumeric(amount) || !Validator.isThousands(amount)) {
           return -1;
        }
        return Integer.parseInt(amount);
    }
}
