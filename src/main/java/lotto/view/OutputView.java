package lotto.view;

import lotto.exception.ViewClassCreateException;

public class OutputView {
    private static final String PAYMENT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    
    private OutputView() {
        throw new ViewClassCreateException();
    }
    
    public static void printPaymentInputMessage() {
        System.out.println(PAYMENT_INPUT_MESSAGE);
    }
    
    public static void printWinningLottoNumbersInputMessage() {
        System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
    }
    
    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
}
