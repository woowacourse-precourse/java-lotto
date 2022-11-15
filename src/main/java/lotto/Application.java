package lotto;

import lotto.core.LotteryPublisher;
import lotto.core.User;
import lotto.input.NextStepInputReader;
import lotto.random.NextStepLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.MainView;

public class Application {
    public static void main(String[] args) {
        User user = new User(new NextStepInputReader());
        LotteryPublisher publisher = new LotteryPublisher(new NextStepLottoNumberGenerator());
        new MainView(new InputView(user), publisher).start();
    }
}
