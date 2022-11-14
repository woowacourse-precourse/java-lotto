package lotto.domain;

import lotto.util.Input;

public class PurchaseLotto {

    public int purchaseAmount;
    public int purchaseCount;

    public PurchaseLotto() {
        this.purchaseAmount = purchaseAmountCal(Input.input());
        this.purchaseCount = purchaseAmount/1000;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    // 입력값 검증 메서드
    private int purchaseAmountCal(String input) {
        int inputInt = StringToInt(input);
        return inputInt;
    }


    // 입력값 int로 형변환
    private int StringToInt(String input) {
        return Integer.parseInt(input);
    }


}
