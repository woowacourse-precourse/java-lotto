package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Purchase {

    private final long purchaseAmount;
    private final long purchaseQuantity;
    private List<Integer> lottos;

    public Purchase(String purchaseAmount) {
        validatePurchase(purchaseAmount);
        this.purchaseAmount = Long.parseLong(purchaseAmount);
        this.purchaseQuantity = calculatePurchaseQuantity(this.purchaseAmount);
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public List<Integer> getLottos() {
        return lottos;
    }

    public void validatePurchase(String purchaseAmountInput) {
        validateNumber(purchaseAmountInput);
        validateNotInput(purchaseAmountInput);
        validateUnit(purchaseAmountInput);
    }

    public void validateNumber(String purchaseAmountInput) {
        if (!purchaseAmountInput.replaceAll("[0-9]", "").equals("")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        }
    }

    public void validateNotInput(String purchaseAmountInput) {
        if (purchaseAmountInput.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해 주세요.");
        }
    }

    public void validateUnit(String purchaseAmountInput) {
        long intPurchaseAmountInput = Long.parseLong(purchaseAmountInput);
        if(intPurchaseAmountInput % 1000 != 0 || intPurchaseAmountInput == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
        }
    }

    public Long calculatePurchaseQuantity(long purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
