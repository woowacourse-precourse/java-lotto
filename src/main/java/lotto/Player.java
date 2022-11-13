package lotto;

import java.util.List;

public class Player {
    private int numberOfPurchase;
    private List<List<Integer>> lottoNumbers;
    private Manager manager;

    public Player() {
        Manager manager = new Manager();
    }

    public void purchaseLotto() {
        manager.requestMoneyStatementPrint();
        int money = manager.inputMoney();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_IS_NOT_DIVISIBLE_BY_1000);
        }
        numberOfPurchase = money / 1000;
    }

    public void getLottoNumbers() {
        for (int i = 0; i < numberOfPurchase; i++) {
            lottoNumbers.add(manager.generator());
        }
    }
    public void checkGetLottoNumbers() {
        System.out.println(numberOfPurchase + "개를 구매했습니다.");
        System.out.println(lottoNumbers);
    }

}
