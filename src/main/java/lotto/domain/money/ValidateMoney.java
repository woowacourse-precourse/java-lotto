package lotto.domain.money;

import lotto.exception.LottoException;
import lotto.setting.Setting;

public class ValidateMoney {
    public void validate(String money){
        validateInputMoneyIsAllNumber(money);
        validateInputMoneyIsRightUnit(money);
    }

    private void validateInputMoneyIsAllNumber(String money){
        if(!money.matches("\\d+")){
            throw new LottoException("구입 금액은 2의 63승 이하의 숫자이어야합니다.");
        }
    }

    private void validateInputMoneyIsRightUnit(String money){
        if(Math.toIntExact(Long.parseLong(money) % Setting.LOTTO_PRICE_PER_ONE) != 0){
            throw new LottoException("구입 금액은 "+ Setting.LOTTO_PRICE_PER_ONE +"원 단위입니다.");
        }
    }

    public Long validatedMoneyToLong(String money){
        return Long.parseLong(money);
    }
}
