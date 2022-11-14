package lotto;


public class Purchase {
    public int price;

    public Purchase(String price) throws IllegalArgumentException {
        validatePurchase(price);
        validatePurchaseUnit(price);
        this.price = Integer.parseInt(price);
    }

    public void validatePurchase(String price) throws IllegalArgumentException {
        for (int i = 0; i < price.length(); i++) {
            if (price.charAt(i) >= 48 && price.charAt(i) <= 57) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력하여야합니다.");
        }
    }

    public void validatePurchaseUnit(String price) throws IllegalArgumentException{
        if (Integer.parseInt(price) % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력하여야 합니다.");
    }
}
