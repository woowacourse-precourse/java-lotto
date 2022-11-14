package lotto.model;

import lotto.view.InputView;

public class Money {
    private static int inputMoney;

    public void setInputMoney() {
        String input = InputView.purchaseInput();
        int money = isMoneyNumber(input);
    }
    public Integer isMoneyNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력 가능합니다.");
        }
    }
    // 입력 받은 money 유효성 검사
    // 로또 발행 수량 구하기

}