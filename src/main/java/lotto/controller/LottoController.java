package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.dto.PurchaseAmountDto;
import lotto.service.LottoService;
import lotto.utils.Converter;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmountDto purchaseAmountDto = getPurchaseAmountDto();
        User user = new User(purchaseAmountDto);
        OutputView.printLottoInformation(user.getLottos());
        WinningLotto winningLotto = createWinningLotto();

        lottoService.calculateLottoRanks(user, winningLotto);
        double profit = lottoService.calculateProfit(user);
        OutputView.printResultInformation(user.getLottoRanks(), profit);
    }

    private PurchaseAmountDto getPurchaseAmountDto() {
        InputView.printInputMoneyMessage();
        Integer purchaseAmount = Converter.toInteger(Console.readLine());
        Validator.validatePurchaseAmount(purchaseAmount);
        return PurchaseAmountDto.of(purchaseAmount);
    }

    private List<Integer> getWinningNumbers() {
        InputView.printInputWinningNumbers();
        List<Integer> winningNumbers = Converter.toIntegerList(Console.readLine());
        Validator.validateLottoNumber(winningNumbers);
        return winningNumbers;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();

        InputView.printInputBonusNumber();
        Integer bonusNumber = Converter.toInteger(Console.readLine());
        Validator.validateLottoNumber(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
