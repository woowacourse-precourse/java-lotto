package lotto.lottoCashier;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constants.ExceptionMessage.*;
import static lotto.constants.LottoConstants.PRICE_OF_LOTTO;

public class LottoCashierImpl implements LottoCashier{
    @Override
    public int receiveMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyAsString = Console.readLine();
        validateMoney(moneyAsString);
        int moneyAsInt = Integer.parseInt(moneyAsString);
        return moneyAsInt;
    }

    private void validateMoney(String inputMoney) {
        int moneyAsInt;
        try {
            moneyAsInt = Integer.parseInt(inputMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
        if(moneyAsInt <= 0) {
            throw new IllegalArgumentException(NOT_OVER_0);
        }
    }

    @Override
    public int calculateNumberOfLottos(int money) {
        if(money % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE);
        }
        return money / PRICE_OF_LOTTO;
    }

    @Override
    public void printNumberPurchased(int numberOfLottoBought) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLottoBought);
    }
}
