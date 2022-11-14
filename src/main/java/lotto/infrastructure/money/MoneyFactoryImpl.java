package lotto.infrastructure.money;

import lotto.domain.money.service.MoneyFactory;
import lotto.global.message.ErrorMessage;
import org.junit.platform.commons.util.StringUtils;

public class MoneyFactoryImpl implements MoneyFactory {

    @Override
    public Integer convertStringToInteger(String inputMoney) {
        if (StringUtils.isBlank(inputMoney)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INPUT_MONEY);
        }
        try {
            return Integer.parseInt(inputMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER);
        }
    }
}
