package view;

import camp.nextstep.edu.missionutils.Console;
import view.message.Message;

public class Input {

    public String inputAmount() {
        System.out.println(Message.TOTAL_FUND.getValue());
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(Message.INPUT_LOTTO_NUMBER.getValue());
        return Console.readLine();
    }
}
