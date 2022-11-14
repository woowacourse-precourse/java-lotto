package lotto;

import lotto.domain.Consumer;

public class Application {
    public static void main(String[] args) {
        try {
            Consumer consumer = new Consumer();
            consumer.purchase();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
