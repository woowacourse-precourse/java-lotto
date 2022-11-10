package lotto;

import lotto.domain.Price;

public class Application {
    public static void main(String[] args) {
        Price price = new Price();
        askPrice();
        price.purchaseAmount();
    }

    public static void askPrice() {
        System.out.println("수입금액을 입력해 주세요.");
    }
}
