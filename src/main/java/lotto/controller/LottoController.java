package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.dto.ProfitDto;
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
        User user = User.of(purchaseAmountDto);
        showPurchaseHistory(user);
        WinningLotto winningLotto = getWinningLotto();

        lottoService.calculateRankings(user, winningLotto);
        ProfitDto profitDto = lottoService.calculateProfit(user);
        showLottoResult(user, profitDto);
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

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();

        InputView.printInputBonusNumber();
        Integer bonusNumber = Converter.toInteger(Console.readLine());
        Validator.validateLottoNumber(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void showPurchaseHistory(User user) {
        OutputView.printLottoInformation(user.getLottos());
    }

    private void showLottoResult(User user, ProfitDto profitDto) {
        OutputView.printResultInformation(user.getRankings(), profitDto.getProfit());
    }
}
