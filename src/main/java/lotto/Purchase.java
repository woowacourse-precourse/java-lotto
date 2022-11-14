package lotto;

public class Purchase {
    static final int asciiZero = 48;
    static final int asciiNine = 57;
    static final int divideNumber = 1000;

    public int price;

    public Purchase(String price) throws IllegalArgumentException {
        validatePurchase(price);
        validatePurchaseUnit(price);
        this.price = Integer.parseInt(price);
    }

    public void validatePurchase(String price) throws IllegalArgumentException {
        for (int i = 0; i < price.length(); i++) {
            if (price.charAt(i) >= asciiZero && price.charAt(i) <= asciiNine) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력하여야합니다.");
        }
    }

    public void validatePurchaseUnit(String price) throws IllegalArgumentException{
        if (Integer.parseInt(price) % divideNumber == 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력하여야 합니다.");
    }
}
