package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String BUYING_PRICE = "구입금액을 입력해 주세요.";

    public String inputPrice() {
        System.out.println(BUYING_PRICE);
        return Console.readLine();
    }
}
