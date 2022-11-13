package lotto.view;

import static lotto.model.InputErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER;
import static lotto.model.InputErrorMessage.INVALID_FORMAT_MONEY;
import static lotto.model.InputErrorMessage.INVALID_LOTTO_NUMBERS;
import static lotto.model.InputErrorMessage.MONEY_IS_NOT_DIVIDED;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.model.Constant;

public class LottoInputView {
    private final static String INPUT_MONEY_OF_LOTTO = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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
        validateInputIsNumberFormat(lottoNumbers);
        return lottoNumbers;
    }

    public String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        validateBonusIsNumber(bonusNumber);
        return bonusNumber;
    }

    public void validateMoney(String uncheckedMoney) {
        if(!isNumberString(uncheckedMoney)) {
            throw new IllegalArgumentException(INVALID_FORMAT_MONEY.getErrorMessage());
        }
    }

    public boolean isNumberString(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            return false;
        }
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

    public void validateInputIsNumberFormat(String uncheckedInput) {
        String uncheckedNumbers = Arrays.toString(uncheckedInput.split(","));
        boolean isNumber = isNumberString(uncheckedNumbers);
        if(!isNumber) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getErrorMessage());
        }
    }

    public void validateBonusIsNumber(String uncheckedInput) {
        if(!isNumberString(uncheckedInput)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_NUMBER.getErrorMessage());
        }
    }
}
