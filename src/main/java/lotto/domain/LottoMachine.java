package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {
    public void buy() throws IllegalArgumentException {
        String money = Console.readLine().trim();
        validateType(money);

        int count = lottoCount(Integer.parseInt(money));
    }

    private void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private int lottoCount(int money) throws IllegalArgumentException{
        validateDivisible(money);
        return money / 2;
    }

    private void validateDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
        }
    }
}
