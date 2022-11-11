package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String input(Messages Message) {
        System.out.println(Message.getMessage());

        return inputString();
    }

    public String inputString() {
        return Console.readLine();
    }
}
