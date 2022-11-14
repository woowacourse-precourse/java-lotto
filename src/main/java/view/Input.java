package view;

import camp.nextstep.edu.missionutils.Console;
import view.message.Message;

public class Input {

    public String inputAmount() {
        System.out.println(Message.TOTAL_FUND.getValue());
        return Console.readLine();
    }
    
}
