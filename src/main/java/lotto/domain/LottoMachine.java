package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {
    public void buy() {
        String money = Console.readLine().trim();
        validateType(money);
    }

    private void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
