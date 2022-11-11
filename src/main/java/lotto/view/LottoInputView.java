package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputErrorMessage;

public class LottoInputView {
    private final static String INPUT_MONEY_OF_LOTTO = "구입금액을 입력해 주세요.";

    public void getLottoAmount() {
        System.out.println(INPUT_MONEY_OF_LOTTO);
        String lottoMoney = Console.readLine();
        validateMoney(lottoMoney);
    }

    public void validateMoney(String uncheckedMoney) {
        if(!isNumberString(uncheckedMoney)) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_FORMAT_MONEY.getErrorMessage());
        }
    }

    public boolean isNumberString(String uncheckedMoney) {
        for (int i = 0; i < uncheckedMoney.length(); i++) {
            char uncheckedCharacter = uncheckedMoney.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return false;
    }
}
