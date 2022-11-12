package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoView {
    public String printMessage(String message) {
        return message;
    }

    public int inputMoney() {
        String input = readLine();
        return Integer.parseInt(input);
    }
}
