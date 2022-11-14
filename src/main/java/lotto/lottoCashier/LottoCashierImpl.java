package lotto.lottoCashier;

import camp.nextstep.edu.missionutils.Console;

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
    public int calculateNumberOfLottos() {
        return 0;
    }

    @Override
    public void printNumberPurchased() {

    }
}
