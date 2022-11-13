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

        int userMoney = userController.getInputMoney();
        int lottoCount = lottoController.getLottoCount(userMoney);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoController.getLotto());
        }

        User user = new User(userMoney, lottos);
        Lotto prizeLotto = lottoController.getPrizeLotto();
        int bonusNumber = lottoController.getBonusNumber(prizeLotto);

        OutputView.printDividingLine();
        lottoController.compareNumbers(user.getLottos(), prizeLotto, bonusNumber);

        // 수익률 = 수익 / 로또 산 돈 * 100
//        userController.getBenefit(benefit, userMoney);
    }
}
