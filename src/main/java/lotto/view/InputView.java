package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputMoneyValidator;

import static lotto.view.InputView.Message.*;

public class InputView {

    enum Message {
        INPUT_MONEY("구입금액을 입력해 주세요."),
        INPUT_LOTTO("당첨 번호를 입력해 주세요."),
        INPUT_BONUS("보너스 번호를 입력해 주세요.");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static int inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());

        String inputMoney = Console.readLine();

        validateInteger(inputMoney);
        InputMoneyValidator.validateInputMoney(inputMoney);
        int moneyInt = Integer.parseInt(inputMoney);
        return moneyInt;
    }

    private static int validateInteger(String inputMoney) {
        try{
            return Integer.parseInt(inputMoney);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자 형식이어야 합니다.");
        }
    }
}
