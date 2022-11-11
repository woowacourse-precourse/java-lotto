package lotto.infrastructure;

import static lotto.common.message.ExceptionMessage.ERROR_CODE;
import static lotto.common.message.ExceptionMessage.GAME_MONEY_TYPE_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Generator;

public class GeneratorImpl implements Generator {


    @Override
    public String[] numberSeparator(String str) {
        return str.split(",");
    }

    @Override
    public int generateMoney(String moneyUnChangedType) {
        try {
            int money = Integer.parseInt(moneyUnChangedType);
            return money;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_CODE + GAME_MONEY_TYPE_EXCEPTION_MESSAGE);
        }
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
            moneyIsDigit(aChar);
        }
    }

    private void moneyIsDigit(char aChar) {
        if (Character.isDigit(aChar) == false) {
            throw new IllegalArgumentException(ERROR_CODE + GAME_MONEY_TYPE_EXCEPTION_MESSAGE);
        }
    }
}
