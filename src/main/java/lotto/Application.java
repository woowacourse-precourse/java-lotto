package lotto;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.presentation.LottoController;
import lotto.domain.user.domain.User;
import lotto.domain.user.presentation.UserController;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final LottoController lottoController = new LottoController();
    private static final UserController userController = new UserController();

    public static void main(String[] args) {
        try {
            int investmentAmount = userController.getInputMoney();
            int lottoCount = lottoController.getLottoCount(investmentAmount);

            List<Lotto> lottos = getLottos(lottoCount);
            User user = new User(investmentAmount, lottos);
            double benefit = compareAndTreatLottoNumbers(user);

            OutputView.printGrossEarnings(lottoController.getGrossEarnings(benefit, investmentAmount));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoController.getLotto());
        }
        return lottos;
    }

    private static double compareAndTreatLottoNumbers(User user) {
        Lotto prizeLotto = lottoController.getPrizeLotto();
        int bonusNumber = lottoController.getBonusNumber(prizeLotto);

        OutputView.printDividingLine();
        return lottoController.compareNumbers(user.getLottos(), prizeLotto, bonusNumber);
    }
}
