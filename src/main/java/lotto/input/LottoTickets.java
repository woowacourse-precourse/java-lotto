package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class LottoTickets {

    public int getPaid() {
        String input = Console.readLine();
        int money = Integer.parseInt(input);
        return money;
    }

}
