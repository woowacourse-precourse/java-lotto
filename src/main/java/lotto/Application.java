package lotto;

import lotto.domain.Purchase;

public class Application {
    public static void main(String[] args) {
        try {
            Purchase.lotto();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
