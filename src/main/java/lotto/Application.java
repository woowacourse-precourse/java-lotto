package lotto;

import lotto.Domain.LottoShop;

public class Application {
    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        try {
            shop.purchase();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
