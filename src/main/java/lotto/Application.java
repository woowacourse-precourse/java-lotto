package lotto;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.presentation.LottoController;
import lotto.domain.user.domain.User;
import lotto.domain.user.presentation.UserController;
import lotto.domain.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final LottoController lottoController = new LottoController();
        final UserController userController = new UserController();

        int investmentAmount = userController.getInputMoney();
        int lottoCount = lottoController.getLottoCount(investmentAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoController.getLotto());
        }

        User user = new User(investmentAmount, lottos);
        Lotto prizeLotto = lottoController.getPrizeLotto();
        int bonusNumber = lottoController.getBonusNumber(prizeLotto);

        OutputView.printDividingLine();
        double benefit = lottoController.compareNumbers(user.getLottos(), prizeLotto, bonusNumber);

        OutputView.printGrossEarnings(lottoController.getGrossEarnings(benefit, investmentAmount));
    }
}
