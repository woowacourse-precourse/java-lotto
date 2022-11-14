package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningResult;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.generator.LottoGenerator;
import lotto.view.UserInputView;
import lotto.view.UserOutputView;

public class LottoGame {

    public void start() {
        Payment userPayment = receiveMoney();
        List<Lotto> purchasedLottos = purchaseLotto(userPayment);
        WinningLotto winningLotto = generateWinningLotto();
        LottoWinningResult lottoWinningResult = checkWinning(purchasedLottos, winningLotto);
        WinningStatistics userWinningStatistics = new WinningStatistics(
                lottoWinningResult.getTotalWinningMoney(),
                userPayment.getMoney()
        );
        UserOutputView.printWinningResult(lottoWinningResult.getNumberOfWinningEachRanks());
        UserOutputView.printRateOfReturn(userWinningStatistics.getRateOfReturn());
    }

    private Payment receiveMoney() {
        UserInputView.printInputPurchasePrice();
        String inputMoney = Console.readLine();
        Payment payment = new Payment(inputMoney);
        return payment;
    }

    private List<Lotto> purchaseLotto(Payment payment) {
        List<Lotto> purchasedLottos = LottoGenerator.generateByPayment(payment);
        UserOutputView.printPurchaseQuantity(purchasedLottos.size());
        purchasedLottos.stream().forEach(lotto -> UserOutputView.printPurchasedLottoNumbers(lotto.getNumbers()));
        return purchasedLottos;
    }

    private WinningLotto generateWinningLotto() {
        UserInputView.printInputWinningLottoNumbers();
        String winningLottoNumbers = Console.readLine();
        Lotto winningLotto = LottoGenerator.generateByNumbers(winningLottoNumbers);

        UserInputView.printInputBonusNumber();
        String bonusNumber = Console.readLine();
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private LottoWinningResult checkWinning(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);
        return lottoWinningChecker.checkWinning(purchasedLottos);
    }
}
