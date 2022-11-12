package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int inputPurchase() {
        int input = Integer.parseInt(Console.readLine());
        validate(input);
        return input / 1000;
    }

    public void validate(int input) {
        if(input % 1000 !=0) {
            throw new IllegalArgumentException();
        }
    }
}
