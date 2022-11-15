package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String scanWith(Messages Message) {
        System.out.println(Message.getMessage());

        return scanString();
    }

    public String scanString() {
        return Console.readLine();
    }
}
