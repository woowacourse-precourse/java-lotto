package lotto;

import lotto.ControlLottoGame;
import camp.nextstep.edu.missionutils.Console;

public class IOManage {

    public void IOManage() {
    }

    public int inputPayment() {
        System.out.println(Message.INPUT_PAYMENT.get());
        String input = Console.readLine();
        int inputPrice = Integer.parseInt(input);

        return inputPrice;
    }
}
