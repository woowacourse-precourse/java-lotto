package lotto.view;

import static lotto.model.InputErrorMessage.INVALID_FORMAT_MONEY;
import static lotto.model.InputErrorMessage.MONEY_IS_NOT_DIVIDED;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Constant;

public class LottoInputView {
    private final static String INPUT_MONEY_OF_LOTTO = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";

    public String getLottoAmount() {
        System.out.println(INPUT_MONEY_OF_LOTTO);
        String lottoMoney = Console.readLine();
        validateMoney(lottoMoney);
        validateMoneyIsDivided(lottoMoney);
        return lottoMoney;
    }

    public String getLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public void validateMoney(String uncheckedMoney) {
        if(!isNumberString(uncheckedMoney)) {
            throw new IllegalArgumentException(INVALID_FORMAT_MONEY.getErrorMessage());
        }
    }

    public boolean isNumberString(String uncheckedInput) {
        for (int i = 0; i < uncheckedInput.length(); i++) {
            char uncheckedCharacter = uncheckedInput.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }

    public void validateMoneyIsDivided(String uncheckedMoney) {
        int money = Integer.parseInt(uncheckedMoney);
        if(money % Constant.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_IS_NOT_DIVIDED.getErrorMessage());
        }
    }
}
