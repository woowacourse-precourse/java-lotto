package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoView {
    private LottoView() {

    }

    public static String printMessage(String message) {
        return message;
    }

    public static int inputMoney() {
        String input = readLine();
        return Integer.parseInt(input);
    }
}
