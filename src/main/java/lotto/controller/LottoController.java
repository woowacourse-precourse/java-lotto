package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private static final String DELIMITER = ",";

    public LottoController() {
        String moneyInput = InputView.getMoney();

        validateMoney(moneyInput);

        int money = Integer.parseInt(moneyInput);

    }

    private void validateMoney(String moneyInput) {
        if (moneyInput.length() <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력의 길이가 잘못됐습니다.");
        }

        long money = 0;
        try {
            money = Integer.parseInt(moneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 입력해주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해주세요.");
        }
    }

}
