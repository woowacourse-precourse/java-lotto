package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Payment;

public class InputView {
    public static Payment inputPayment() {
        final String inputPayment = Console.readLine();
        return new Payment(Integer.parseInt(inputPayment));
    }
}