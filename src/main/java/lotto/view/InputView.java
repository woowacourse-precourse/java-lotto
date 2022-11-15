package lotto.view;

import static lotto.utils.Constant.BONUS_NUMBER;
import static lotto.utils.Constant.PAYMENT_AMOUNT;
import static lotto.utils.Constant.WINNER_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PaymentAmountDto;
import lotto.controller.dto.WinnerNumberDto;

public class InputView {


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
