package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.InputConverter;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        User user = new User(purchaseAmount);
        OutputView.printLottoInformation(user.getLottos());
        WinningLotto winningLotto = createWinningLotto();
    }

    private Integer getPurchaseAmount() {
        InputView.printInputMoneyMessage();
        Integer purchaseAmount = InputConverter.toInteger(Console.readLine());
        Validator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private List<Integer> getWinningNumbers() {
        InputView.printInputWinningNumbers();
        List<Integer> winningNumbers = InputConverter.toIntegerList(Console.readLine());
        Validator.validateLottoNumber(winningNumbers);
        return winningNumbers;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();

        InputView.printInputBonusNumber();
        Integer bonusNumber = InputConverter.toInteger(Console.readLine());
        Validator.validateLottoNumber(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
