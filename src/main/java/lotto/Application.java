package lotto;

import lotto.domain.Consumer;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            OutputView outputView = new OutputView();
            Consumer consumer = new Consumer();

            outputView.print(consumer.purchase());
            outputView.print(consumer.getLotteriesResult());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
