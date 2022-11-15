package domain;

public class PurchaseMoney {
    private final int LOTTO_PRICE = 1000;
    private final int MIN_RANGE = 1000;

    private final int purchaseMoney;

    public PurchaseMoney(String purchaseMoney) {
        validate(purchaseMoney);
        this.purchaseMoney = Integer.parseInt(purchaseMoney);
    }

    public void validate(String purchaseMoney) {
        checkBlank(purchaseMoney);
        int money = numberFormatValidate(purchaseMoney);
        checkRange(money);
        checkUnit(money);
    }

    public void checkBlank(String purchaseMoney) {
        if (purchaseMoney.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 널값 또는 공백은 입력될 수 없습니다.");
        }
    }

    public int numberFormatValidate(String purchaseMoney) {
        try {
            return Integer.parseInt(purchaseMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 문자열이 아닙니다.");
        }
    }

    private void checkUnit(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위로 가능합니다.");
        }
    }

    private void checkRange(int money) {
        if ( money < MIN_RANGE) {
            throw new IllegalArgumentException("[ERROR] 최소 " + MIN_RANGE + "원 이상부터 구입이 가능합니다.");

        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getLottoCount() {
        return purchaseMoney / LOTTO_PRICE;
    }
}
