package lotto.lottoCashier;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constants.Constants.PRICE_OF_LOTTO;

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
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야합니다.");
        }
        if(moneyAsInt <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 값을 입력해야합니다.");
        }
    }

    @Override
    public int calculateNumberOfLottos(int money) {
        if(money % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 가격으로 정확히 나눠떨어지는 값을 입력하세요. 로또 가격: " + PRICE_OF_LOTTO);
        }
        return money / PRICE_OF_LOTTO;
    }

    @Override
    public void printNumberPurchased(int numberOfLottoBought) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLottoBought);
    }
}
