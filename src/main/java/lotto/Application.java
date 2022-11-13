package lotto;

import lotto.input.NextStepInputReader;
import lotto.random.NextStepLottoNumberGenerator;
import lotto.view.MainView;

public class Application {
    public static void main(String[] args) {
        User user = new User(new NextStepInputReader());
        LotteryPublisher publisher = new LotteryPublisher(new NextStepLottoNumberGenerator());
        new MainView(user, publisher).run();
    }
}
