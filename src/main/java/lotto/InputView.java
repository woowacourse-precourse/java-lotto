package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public enum Message {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        LOTTO_ANSWER_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String label;

        Message(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }

    }
    private static int inputNum() {
        String number = Console.readLine();
        return  Integer.parseInt(number);
    }
    public static int inputMoney() {
        System.out.println(Message.PURCHASE_AMOUNT.label());
        return inputNum();
    }

    public static int inputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER.label());
        return inputNum();
    }
}
