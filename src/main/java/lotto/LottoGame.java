package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public int inputMoney() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

}
