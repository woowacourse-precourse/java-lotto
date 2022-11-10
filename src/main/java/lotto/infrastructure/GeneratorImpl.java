package lotto.infrastructure;

import static lotto.common.message.ExceptionMessage.ERROR_CODE;
import static lotto.common.message.ExceptionMessage.GAME_MONEY_TYPE_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.message.ExceptionMessage;
import lotto.domain.Generator;
import org.assertj.core.internal.ErrorMessages;

public class GeneratorImpl implements Generator {


    @Override
    public String[] numberSeparator(String str) {
        return str.split(",");
    }

    @Override
    public int generateMoney() {
        String moneyUnChangedType = Console.readLine();

        validation(moneyUnChangedType);
        return Integer.parseInt(moneyUnChangedType);
    }

    @Override
    public String generateLotto() {
        return Console.readLine();
    }

    @Override
    public String generateBonusLottoNumber() {
        return Console.readLine();
    }

    private void validation(String moneyUnChangedType) {
        char[] chars = moneyUnChangedType.toCharArray();
        for (char aChar : chars) {
            isNotDigit(aChar);
        }
    }

    private void isNotDigit(char aChar) {
        if (!Character.isDigit(aChar)) {
            throw new IllegalArgumentException(ERROR_CODE + GAME_MONEY_TYPE_EXCEPTION_MESSAGE);
        }
    }
}
