package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    int lottoCount;

    public int inputPrice() {
        String amount = Console.readLine();
        if(!Validator.isNumeric(amount) || !Validator.isThousands(amount)) {
           return -1;
        }
        lottoCount = Integer.parseInt(amount) / 1000;
        return lottoCount;
    }
}
