package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningResult;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.generator.LottoGenerator;
import lotto.generator.WinningLottoGenerator;
import lotto.validator.LottoPurchaseValidator;
import lotto.validator.UserInputValidator;
import lotto.view.UserInputView;
import lotto.view.UserOutputView;

public class LottoGame {

    public void start() {
        int inputMoney = receiveMoney();
        List<Lotto> purchasedLottos = purchaseLotto(inputMoney);
        WinningLotto winningLotto = generateWinningLotto();
        LottoWinningResult lottoWinningResult = checkWinning(purchasedLottos, winningLotto);
        WinningStatistics userWinningStatistics = new WinningStatistics(
                lottoWinningResult.getTotalWinningMoney(),
                inputMoney
        );
        UserOutputView.printWinningResult(lottoWinningResult.getNumberOfWinningEachRanks());
        UserOutputView.printRateOfReturn(userWinningStatistics.getRateOfReturn());
    }

    private int receiveMoney() {
        UserInputView.printInputPurchasePrice();
        String inputMoney = Console.readLine();
        UserInputValidator.validateStringIsNumeric(inputMoney);
        int inputMoneyParseInt = Integer.parseInt(inputMoney);
        LottoPurchaseValidator.validatePurchaseUnit(inputMoneyParseInt);
        return inputMoneyParseInt;
    }

    private List<Lotto> purchaseLotto(int inputMoney) {
        List<Lotto> purchasedLottos = LottoGenerator.generateByMoney(inputMoney);
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
        return WinningLottoGenerator.generate(winningLotto, bonusNumber);
    }

    private LottoWinningResult checkWinning(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);
        return lottoWinningChecker.checkWinning(purchasedLottos);
    }
}
