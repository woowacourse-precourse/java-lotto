package lotto.domain;

public class LottoMoney {
    private final int money;

    public LottoMoney(int money) {
        this.money = money;
    }

    public LottoMoney(String money) {
        this.money = validateUnit(convertToInt(money));
    }

    public int getMoney() {
        return money;
    }

    private int validateUnit(int money) {
        if (money / 1000 < 1) {
            throw new IllegalArgumentException("로또 구매 금액은 최소 1,000원 이상이어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1,000원 단위어야 합니다.");
        }

        return money;
    }

    private int convertToInt(String money) {
        validateInt(money);
        return Integer.parseInt(money);
    }

    private void validateInt(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("로또 구매 금액은 숫자만 입력해 주세요.");
        }
    }
}
