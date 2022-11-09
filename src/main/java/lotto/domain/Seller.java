package lotto.domain;

import static lotto.resources.ValidationPattern.PATTERN;

public class Seller {
    private int sellCount;

    private Seller() {
    }

    public static Seller getInstance() {
        return new Seller();
    }

    public int sellLotto(String money){
        int purchaseMoney = convertStringToInt(money);
        validateUnitAmount(purchaseMoney);
        sellCount = purchaseMoney / 1000;
        return sellCount;
    }

    private int convertStringToInt(String payment){
        if (PATTERN.canConvert(payment)) {
            return Integer.parseInt(payment);
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주시기 바랍니다.");
    }

    private void validateUnitAmount(int purchaseMoney){
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }


}
