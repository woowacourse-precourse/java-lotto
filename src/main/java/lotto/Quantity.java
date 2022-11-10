package lotto;

public class Quantity {

    // TODO: 2022-11-10 Quantity가 존재해야하는지?, != 0을 어떻게 정의할지 고민하기
    private static final int UNIT_STANDARD = 1_000;
    private static final String UNIT_STANDARD_ERROR = "[ERROR] 구입금액은 1,000원 단위입니다.";

    private final int number;

    public Quantity(int purchaseAmount) {
        validate(purchaseAmount);
        this.number = calculateQuantity(purchaseAmount);
    }

    public void validate(int purchaseAmount) {
        if (purchaseAmount % UNIT_STANDARD != 0) {
            throw new IllegalArgumentException(UNIT_STANDARD_ERROR);
        }
    }

    public int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / UNIT_STANDARD;
    }

    public int getNumber() {
        return number;
    }
}
