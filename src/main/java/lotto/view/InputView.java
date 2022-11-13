package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PaymentAmountDto;
import lotto.controller.dto.WinnerNumberDto;

public class InputView {

    private static final String PAYMENT_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String WINNER_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static PaymentAmountDto inputPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT);
        return new PaymentAmountDto(Console.readLine());
    }

    public static WinnerNumberDto inputWinnerNumber() {
        System.out.println(WINNER_NUMBER);
        String winnerNumber = Console.readLine();
        System.out.println(BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return new WinnerNumberDto(winnerNumber, bonusNumber);
    }

}
